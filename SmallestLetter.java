import java.util.*;
/*********************************************************************************************** */





   //              T.C=O(n)







// METHOD -1 LENEAR SEARCH
public class SmallestLetter {
       public char nextGreatestLetter(char[] letters, char target) {
        for(char ch : letters){
            if(ch>target) return ch;
        }
        return letters[0];
    }
}





/************************************************************************************************** */



// METHOD -2 BINARY SEARCH





// T.C=O(nlogn)



class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi =  letters.length-1;
        char ans =  letters[0];
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(letters[mid]>target){
                ans = letters[mid];
                hi =  mid-1;
            } else{
                lo = mid+1;
            }
        }
        return ans;
    }
}











/************************************************************************************************* */