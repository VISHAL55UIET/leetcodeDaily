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



/*********************************************************************************************** */



// METHOD -2

// USING STACK VERSION

class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();
        int deletions = 0;

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == 'b' && ch == 'a') {
                // conflict "ba"
                deletions++;   // delete current 'a'
            } else {
                stack.push(ch);
            }
        }
        return deletions;
    }
}



/*********************************************************************************************** */