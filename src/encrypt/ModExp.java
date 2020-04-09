package encrypt;

import java.util.LinkedList;

public class ModExp {

    public static int GetModExp(int base, int power, int mod){

        int result = 1;

        LinkedList<Integer> binary = new LinkedList<Integer>();

        while(power != 0){
            binary.addLast(power%2);
            power /= 2;
        }

        LinkedList<Integer> mods = new LinkedList<Integer>();
        mods.add(base%mod);

        for (int i = 1; i < binary.size(); i++){
            mods.addLast((int) (Math.pow(mods.getLast(),2) % mod));
        }

        for (int i = 0; i < binary.size(); i++){
            if (binary.get(i) == 1){
                result *= mods.get(i);
            }
        }

        return result % mod;
    }
}
