import java.util.Arrays;
  
/************************************************************************************************* */

     // T.C = O(Nlogn)
     // S.C = O(1)







/****************************************************************************************8 */
public class MinimumRemovableSubarray {
public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int maxlen = 1;
        for(int right = 0;right<n;right++){
            while( (long) nums[right] > (long)k*nums[left]){
                left++;
            }
            maxlen = Math.max(maxlen,right-left+1);
        }
        return n-maxlen;
    }




}




/******************************************************************************************** */

    // S.E.C.O.N.D. M.E.T.H.O.D

    // TOW POINER APPROACH



//Approach (Using sorting and two pointers)
//T.C : O(nlogn)
//S.C : O(1)
class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int i = 0;
        int maxLen = 1;

        for (int j = 0; j < n; j++) {
            long maxEl = nums[j];
            long minEl = nums[i];

            while (i < j && maxEl > (long) k * minEl) {
                i++;
                minEl = nums[i];
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return n - maxLen;
    }
}


/***************************************************************************************** */