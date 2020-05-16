package encrypt;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;
import java.util.LinkedList;
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
            System.out.println("Enter (e) to encrypt or (d) to decrypt:");

            input = userInput.next(Pattern.compile("[ed]")).charAt(0);

            if(input == 'e'){
                System.out.println("Enter your message:");
                message = new BigInteger( userInput.next() );
                rsa = new RSA();
                System.out.println("Encrypted message: "+ rsa.Encrypt(message));
                System.out.println("public key: " + rsa.getPublicKey());
                System.out.println("private key: " + rsa.getPrivateKey());
                System.out.println("decryypted: "+ rsa.Decrypt(rsa.Encrypt(message)));
                break;
            }else if(input == 'd'){
                System.out.println("Enter your encrypted message:");
                encrypted = new BigInteger( userInput.next() );
                System.out.println("Enter the private key:");
                System.out.println("d:");
                privateKey = new BigInteger( userInput.next() );
                System.out.println("n:");
                n = new BigInteger( userInput.next() );

                System.out.println("Decrypted: "+RSA.Decrypt(privateKey,n,encrypted));

                break;
            }
        }





    }
}
