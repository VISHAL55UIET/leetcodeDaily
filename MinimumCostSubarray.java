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