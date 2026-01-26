import java.util.*;

/************************************************************************************************ */



  //Approach (Sort and find and collect)
//T.C : O(nlogn) 
//S.C : O(1)










/**********************************************************************************************8******** */
 // 









 // two pass solution
public class PairDiff {
  
   public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        int minDiff = Integer.MAX_VALUE;

        // First pass: find minimum difference
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            minDiff = Math.min(minDiff, diff);
        }

        // Second pass: collect pairs with min difference
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}



/********************************************************************************************************** */


// one pass  solutuion

/*

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];

            if (diff < minDiff) {
                minDiff = diff;
                res.clear(); // reset bz smaller diff found
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (diff == minDiff) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return res;
    }
}







*/