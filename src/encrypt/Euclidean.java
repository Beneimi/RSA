package encrypt;

import java.math.BigInteger;

public class Euclidean {

    public static BigInteger ExtEuclidean(BigInteger m, BigInteger n){
        BigInteger a;
        BigInteger b;
        if(m.compareTo(n) == 1) {
            a = m;
            b = n;
        }
        else {
            b = m;
            a=n;
        }
        BigInteger q;
        BigInteger r = new BigInteger("1");
        BigInteger gcd = new BigInteger("1");
        BigInteger s0 = new BigInteger("1");
        BigInteger s1 = new BigInteger("0");
        BigInteger t0 = new BigInteger("0");
        BigInteger t1 = new BigInteger("1");
        BigInteger zero = new BigInteger("0");

        BigInteger buffer;

        while (!r.equals(zero)){
            gcd = r;
            q = a.divide(b);
            r = a.subtract(b.multiply(q));
            a = b;
            b = r;
            buffer = s1;
            s1 = s0.subtract(q.multiply(s1));
            s0 = buffer;

            buffer = t1;
            t1 = t0.subtract(q.multiply(t1));
            t0 = buffer;

        }

        return t0;
    }
}
