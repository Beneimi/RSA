package Main;


import encrypt.RSA;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        BigInteger message;
        BigInteger encrypted;
        BigInteger n;
        BigInteger privateKey;
        BigInteger publicKey;
        RSA rsa;
        char input;

        while (true){
            System.out.println("Enter (e) to encrypt, (d) to decrypt, or (g) to generate RSA keys:");

            input = userInput.next(Pattern.compile("[edg]")).charAt(0);

            // Encrypt
            if(input == 'e'){

                System.out.println("Enter (e) to use existing RSA key, or (g) to generate a new one:");
                input = userInput.next(Pattern.compile("[eg]")).charAt(0);

                System.out.println("Enter your message:");
                message = new BigInteger( userInput.next() );

                // existing key
                if(input == 'e'){
                    System.out.println("Enter the public key:");
                    publicKey = new BigInteger( userInput.next() );
                    System.out.println("Enter n:");
                    n = new BigInteger( userInput.next() );
                    System.out.println("Encrypted message:" + RSA.Encrypt(publicKey,message,n));

                // generated key
                }else if(input == 'g'){
                    rsa = new RSA();
                    System.out.println("Encrypted message: "+ rsa.Encrypt(message));
                    System.out.println("public key: " + rsa.getPublicKey());
                    System.out.println("private key: " + rsa.getPrivateKey());
                    System.out.println("decryypted: "+ rsa.Decrypt(rsa.Encrypt(message)));
                }

            // Decrypt
            }else if(input == 'd'){
                System.out.println("Enter your encrypted message:");
                encrypted = new BigInteger( userInput.next() );
                System.out.println("Enter the private key:");
                System.out.println("d:");
                privateKey = new BigInteger( userInput.next() );
                System.out.println("n:");
                n = new BigInteger( userInput.next() );

                System.out.println("Decrypted: "+RSA.Decrypt(privateKey,n,encrypted));

            // Generate keys
            }else if(input == 'g'){
                rsa = new RSA();
                System.out.println("public key: " + rsa.getPublicKey());
                System.out.println("private key: " + rsa.getPrivateKey());
            }
        }





    }
}
