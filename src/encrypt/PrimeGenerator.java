package encrypt;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class PrimeGenerator {


    public static BigInteger GetPrime(int bits){
        BigInteger p;
        BigInteger d;
        BigInteger s;

        while (true){
            p = RandomBitsOf(bits);
            d = p.subtract(BigInteger.ONE);
            s = new BigInteger("1");

            while (!d.testBit(0)){
                d = d.divide(BigInteger.TWO);
                s = s.multiply(BigInteger.TWO);
            }
            s = s.divide(BigInteger.TWO);

            if (Test(p,d,s)){
                break;
            }
        }

        return p;
    }

    public static BigInteger RandomBitsOf(int bit) {

        BigInteger n = new BigInteger(bit,new Random());
        if (n.testBit(0)){
            n.subtract(BigInteger.ONE);
        }
        return n;
    }

    public static BigInteger RandomTo(BigInteger to){

        Random rand = new Random();

        BigDecimal t = new BigDecimal(to);

        BigDecimal d = new BigDecimal(rand.nextDouble()).multiply(t.subtract(BigDecimal.ONE).add(BigDecimal.ONE));

        return d.toBigInteger();
    }

    public static boolean Test(BigInteger n, BigInteger d, BigInteger s){

        BigInteger a;

        boolean prime = false;
        for (int k = 0; k<4; k++){
            a = RandomTo(n.subtract(BigInteger.ONE));

            if(EncryptMath.ModPow(a,d,n).equals(BigInteger.ONE)){
                prime = true;
            }
            for (int i = 0; i < s.intValue(); i++){

                if(EncryptMath.ModPow(a, BigInteger.TWO.pow(i).multiply(d), n ).equals(n.subtract(BigInteger.ONE))){
                    prime = true;
                    i = s.intValue();
                }
            }
            if (!prime){
                return false;
            }
            prime = false;
        }
        return true;
    }
}
