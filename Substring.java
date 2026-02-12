
import java.util.*;
/***************************************************************************************************** */


        







/**************************************************************************************************** */
public class Substring {
   public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> freqMap = new HashMap<>();
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
                if (isBalanced(freqMap)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
    private boolean isBalanced(HashMap<Character, Integer> freqMap) {
       HashSet<Integer>set =  new HashSet<>();
       for(int f :freqMap.values()){
           set.add(f);
           if(set.size()>1)return false;
       }
       return true;
    }
}
