package encrypt;

import java.math.BigInteger;

public class Main {


    public static void main(String[] args) {

        RSA rsa = new RSA(128);
        BigInteger secret = rsa.Encrypt(new BigInteger("123456789123456789"));
        System.out.println(secret);
        System.out.println(rsa.Decrypt(secret));


    }
}
