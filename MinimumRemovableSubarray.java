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