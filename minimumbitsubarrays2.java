import java.util.*;

/************************************************************************************************ */



//  Time Complexity=O(n×32)=O(n)​

//  Space Complexity=O(n)​












/***********************************************************************************************8 */
public class minimumbitsubarrays2 {    // minimumbitsubarrays2

    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);

            if (num == 2) {          // edge case
                result[i] = -1;
                continue;
            }

            boolean found = false;

            for (int j = 1; j < 32; j++) {
                // if j-th bit is set, skip
                if ((num & (1 << j)) != 0) continue;

                // flip (j-1)-th bit
                result[i] = num ^ (1 << (j - 1));
                found = true;   
                break;
            }

            if (!found) result[i] = -1;
        }
        return result;
    }
    /************************************************************************************************ */











    // ================= TESTING =================
    public static void main(String[] args) {
        minimumbitsubarrays2 sol = new minimumbitsubarrays2();

        // Test case 1
        List<Integer> nums1 = Arrays.asList(2, 3, 5, 7);
        System.out.println("Input: " + nums1);
        System.out.println("Output: " + Arrays.toString(sol.minBitwiseArray(nums1)));
        System.out.println();

        // Test case 2
        List<Integer> nums2 = Arrays.asList(1, 4, 6, 8);
        System.out.println("Input: " + nums2);
        System.out.println("Output: " + Arrays.toString(sol.minBitwiseArray(nums2)));
        System.out.println();

        // Test case 3
        List<Integer> nums3 = Arrays.asList(3, 7, 15, 31);
        System.out.println("Input: " + nums3);
        System.out.println("Output: " + Arrays.toString(sol.minBitwiseArray(nums3)));
        System.out.println();

        // Test case 4 (single element)
        List<Integer> nums4 = Arrays.asList(2);
        System.out.println("Input: " + nums4);
        System.out.println("Output: " + Arrays.toString(sol.minBitwiseArray(nums4)));
    }
}





/********************************************************************************************************* */