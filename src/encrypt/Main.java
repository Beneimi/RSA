package encrypt;

import java.math.BigInteger;

public class Main {


    public static void main(String[] args) {

        long time = System.nanoTime();
        BigInteger prime = PrimeGenerator.GetPrime(512);
        System.out.println("Time: " + (System.nanoTime()-time) * 0.000000001);
        System.out.println("Prime: " + prime);
        System.out.println("BitLength: "+prime.bitLength());

    }
}
