package encrypt;

import java.math.BigInteger;
import java.util.LinkedList;

public class RSA {

    private BigInteger publicKey;
    private BigInteger privateKey;
    private BigInteger n;
    private BigInteger fi;

    public RSA(BigInteger p,BigInteger q) {
        this.n = p.multiply(q);
        this.fi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        this.publicKey = new BigInteger("3");

        while (!this.publicKey.gcd(n).equals(BigInteger.ONE) || !this.publicKey.gcd(fi).equals(BigInteger.ONE)){
            this.publicKey = this.publicKey.add(BigInteger.ONE);
        }

        this.privateKey = EncryptMath.ExtEuclidean(this.publicKey,this.fi).add(this.fi);

        Logger.Detailed("fi(n): "+this.fi);
        Logger.Basic("n:" + this.n);
        Logger.Basic("Public key: "+this.publicKey.toString());
        Logger.Basic("Private key: "+this.privateKey.toString());
    }

    public RSA(int bits){
        this(PrimeGenerator.GetPrime(bits),PrimeGenerator.GetPrime(bits));
    }

    public RSA(){
        this(256);
    }

    public RSA(BigInteger p, BigInteger q, LinkedList<BigInteger> e){
        this.n = p.multiply(q);
        this.fi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        this.publicKey = new BigInteger("3");

        for (BigInteger ee:e) {
            this.publicKey = ee;
            if(this.publicKey.gcd(n).equals(BigInteger.ONE) || !this.publicKey.gcd(fi).equals(BigInteger.ONE)){
                break;
            }
        }

        this.privateKey = EncryptMath.ExtEuclidean(this.publicKey,this.fi).add(this.fi);

        Logger.Detailed("fi(n): "+this.fi);
        Logger.Basic("n:" + this.n);
        Logger.Basic("Public key: "+this.publicKey.toString());
        Logger.Basic("Private key: "+this.privateKey.toString());
    }


    public BigInteger Encrypt(BigInteger message){
        return EncryptMath.ModPow(message,this.publicKey,this.n);
    }

    public BigInteger Decrypt(BigInteger encrypted){
        return EncryptMath.ModPow(encrypted,this.privateKey,this.n);
    }

    public static String Decrypt(BigInteger d, BigInteger n, BigInteger c){
        return EncryptMath.ModPow(c,d,n).toString();
    }

    public static String Encrypt(BigInteger e, BigInteger n, BigInteger m){
        return EncryptMath.ModPow(m,e,n).toString();
    }

    public String getPublicKey(){
        return "e: " + this.publicKey.toString() + ", n: " + this.n.toString();
    }

    public String getPrivateKey(){
        return "d: " + this.privateKey.toString() + ", n: " + this.n.toString();
    }
}
