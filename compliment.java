import java.util.*;
/********************************************************************************************** */











/************************************************************************************************** */
public class compliment {
   public int findComplement(int num) {
          int mask = 1;

        // create mask like 1,3,7,15...
        while(mask < num){
            mask = (mask << 1) | 1;
        }

        return num ^ mask;   
    }
}
