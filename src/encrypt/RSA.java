package encrypt;

import java.math.BigInteger;

public class RSA {

    private BigInteger publicKey;
    private BigInteger privateKey;
    private BigInteger n;
    private BigInteger fi;

    public RSA(int bits){
        BigInteger p = PrimeGenerator.GetPrime(bits);
        BigInteger q = PrimeGenerator.GetPrime(bits);

        this.n = p.multiply(q);
        this.fi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        this.publicKey = PrimeGenerator.RandomTo(fi);

        while (!this.publicKey.gcd(n).equals(BigInteger.ONE) || !this.publicKey.gcd(fi).equals(BigInteger.ONE)){
            this.publicKey = this.publicKey.subtract(BigInteger.ONE);
        }

        this.privateKey = EncryptMath.ExtEuclidean(this.publicKey,this.fi).add(this.fi);
    }

    public RSA(){
        this(256);
    }

    public BigInteger Encrypt(BigInteger message){
        return EncryptMath.ModPow(message,this.publicKey,this.n);
    }

    public BigInteger Decrypt(BigInteger encrypted){
        return EncryptMath.ModPow(encrypted,this.privateKey,this.n);
    }
}
