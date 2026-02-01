import java.util.*;
/************************************************************************************************* */











/**************************************************************************************************** */
public class MinimumCostSubarray {
  
public int minimumCost(int[] nums) {
        int n =  nums.length;
        int score = nums[0];
        int first_MIN = Integer.MAX_VALUE;
        int second_MIN=Integer.MAX_VALUE;
        for(int i = 1;i<n;i++){
            if(nums[i]<first_MIN){
                second_MIN =  first_MIN;
                 first_MIN =  nums[i];
            }  else if(nums[i]<second_MIN){
                second_MIN = nums[i];
            }
        }
        return score+ first_MIN+second_MIN;
    }
}

/******************************************************************************************* */


/*

ME.T.H.O.D=2



class Solution {
    public int minimumCost(int[] nums) {
        int n =  nums.length;
        int first =  nums[0];
        Arrays.sort(nums,1,n);
        return first+nums[1]+nums[2];
    }
}


*/



/*
M.E.T.H.O.D =3
    class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;

        // Step 1: build suffix minimum
        int[] sufMin = new int[n];
        sufMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            sufMin[i] = Math.min(nums[i], sufMin[i + 1]);
        }

        // Step 2: try all i as start of 2nd subarray
        int best = Integer.MAX_VALUE;
        for (int i = 1; i <= n - 2; i++) {
            best = Math.min(best, nums[i] + sufMin[i + 1]);
        }

        // Step 3: add first subarray cost
        return nums[0] + best;
    }
}

 */