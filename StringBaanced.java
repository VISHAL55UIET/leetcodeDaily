import java.util.*;

/********************************************************************************************* */
   

    // T.C = O(N)

    // S.C = O(1)









/*********************************************************************************************** */

public class StringBaanced {
   public int minimumDeletions(String s) {
        int n = s.length();
        int bcount = 0;
        int del = 0;
        for(char ch : s.toCharArray()){
            if(ch=='b'){
              bcount++;         
            }  else { // ch = a;
             del = Math.min(del+1,bcount);
            }
        }
        return del;
    }
}
