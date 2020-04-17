package encrypt;

import java.math.BigInteger;

public class Main {


    public static void main(String[] args) {

        BigInteger p = PrimeGenerator.GetPrime(256);
        BigInteger q = PrimeGenerator.GetPrime(256);
        //BigInteger p = new BigInteger("61");
        //BigInteger q = new BigInteger("53");
        BigInteger n = p.multiply(q);
        BigInteger fi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        BigInteger msg = new BigInteger("123456789123456789");


        BigInteger e = PrimeGenerator.RandomTo(fi);

        while (!e.gcd(n).equals(BigInteger.ONE) || !e.gcd(fi).equals(BigInteger.ONE)){
            e = e.subtract(BigInteger.ONE);
        }


        BigInteger d = EncryptMath.ExtEuclidean(e,fi).add(fi);

        BigInteger secret = EncryptMath.ModPow(msg,e,n);

        System.out.println("n: "+ n);
        System.out.println("e: "+ e);
        System.out.println("d: "+ d);

        System.out.println("Decrypted: " + EncryptMath.ModPow(secret,d,n));

    }
}
