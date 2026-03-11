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





/* 

//     SECOND METHOD


class Solution {
    public int findComplement(int num) {
      return ((Integer.highestOneBit(num) << 1) - 1) ^ num;   
    }
}


// THIRD METHOD

class Solution {
    public int bitwiseComplement(int n) {
        if(n==0)return 1;
        int mask = 0;
        int temp = n;
        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }
        return n ^ mask;
    }
}

// FOURTH METHOD
class Solution {
    public int bitwiseComplement(int n) {
        int m = n;
        int mask = 0;
        if (n == 0) {
            return 1;
        }
        while (m != 0) {
            mask = (mask << 1) | 1;
            m = m >> 1;
        }
        int ans = (~n) & mask;
        return ans;
    }
}

*/