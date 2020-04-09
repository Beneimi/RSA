package encrypt;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PrimeGenerator {

    public static BigDecimal mills = new BigDecimal("1.3063778838630806904686144926");


    public static BigInteger GetMillsPrime(int n){
        return mills.pow((int)Math.pow(3,n)).toBigInteger();
    }
}
