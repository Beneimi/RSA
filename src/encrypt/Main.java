package encrypt;

import java.math.BigInteger;

public class Main {

    private void TestModExp(){

        int a = 0;
        BigInteger b = new BigInteger("1848161521");
        long t = 0;
        t = System.nanoTime();
        a = ModExp.GetModExp(1848161521,71,13);
        System.out.println(System.nanoTime()-t);

        t = System.nanoTime();

        b = b.modPow(new BigInteger("71"),new BigInteger("13"));

        System.out.println(System.nanoTime()-t);

        System.out.println("a: "+ a +", b: "+b);

    }

    public static void main(String[] args) {

      //  BigInteger p1 = new BigInteger("63517947780168748793");
       // BigInteger p2 = new BigInteger("23405859083053345847");

        BigInteger p1 = new BigInteger("328299467195427909930002077200660509529022934252741669833953094817720212438368216136898400124643845504974321473216950805088311827790995809999318116106040954578235123885227247022652974491488605824195266974251786595760031803000751147942867594000108705569247853043213372775134158274129502979053191429571");
        BigInteger p2 = new BigInteger("808479509864179231459863826000825006736657840024258352507503580485099999797120666234248998078329808948838543783214224717570846462431752726131728952509160407894072981790909335356570178571803977139434590668170673920124734799309210975697083355519278387713700505128710651362954258758553796970883015695113");

        System.out.println("bitcount " + p1.bitCount());

        BigInteger N = p2.multiply(p1);

        BigInteger fi = p2.subtract(new BigInteger("1")).multiply(p1.subtract(new BigInteger("1")));

        BigInteger e = new BigInteger("0");

        BigInteger one = new BigInteger("1");

        for (int i=3; i < 100; i++){
            e = new BigInteger(Integer.toString(i));
            if(N.gcd(e).equals(one) && fi.gcd(e).equals(one)){
                break;
            }
        }

        BigInteger d = Euclidean.ExtEuclidean( e,fi).mod(fi) ;

        BigInteger msg = new BigInteger("123456789123456789");

        BigInteger enc = msg.modPow(e,N);

        System.out.println("msg: "+ msg + " encrypted: "+enc);

        System.out.println("e: " + e + " d: " + d + " fi: "+fi+" N: "+N);

        System.out.println("Decrypted: "+enc.modPow(d,N));


    }
}
