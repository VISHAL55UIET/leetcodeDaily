import java.util.*;
 /************************************************************************************************** */



    // T.C=O(Nlogn)

    // S.C=O(1)








 /******************************************************************************************************** */
class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n  = nums.length;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int i = 0;
        int j = k-1;
        while(j<nums.length){
           diff = Math.min(diff,nums[j]-nums[i]);
           i++;
           j++;
        }
        return diff ;
    }
}


/***************************************************************************************************** */

/*

    SECOND METHOD






   class Solution {

    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < n; ++i) {
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans;
    }
}



*/