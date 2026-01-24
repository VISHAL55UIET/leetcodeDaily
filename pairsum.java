import java.util.Arrays;
/************************************************************************************************* */



      // TC = O(n log n)

      // SC = O(1)













/**************************************************************************************************** */

public class pairsum {

    public static int minimizeMaxPairSum(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int maxPairSum = Integer.MIN_VALUE;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > maxPairSum) {
                maxPairSum = sum;
            }
            left++;
            right--;
        }
        return maxPairSum;
    }

    /**************************************************************************************************** */

    // Test case
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 3};

        int result = minimizeMaxPairSum(nums);

        System.out.println("Minimized Maximum Pair Sum = " + result);
    }
}


/**************************************************************************************************8**** */








// second appraoch 

/********************************************************************************************************** */


/* 
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxSum = 0;
        for (int i = 0; i < n / 2; i++) {
            int pairSum = nums[i] + nums[n - 1 - i];
            maxSum = Math.max(maxSum, pairSum);
        }
        return maxSum;
    }
}

*/


/******************************************************************************************************** */