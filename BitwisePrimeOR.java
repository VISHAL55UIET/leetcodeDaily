import java.util.*;

 /************************************************************************************************ */




 //Time = O(n)
 //Space = O(n)







 /*******************************************************************************************************8 */

class Slution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            int y = nums.get(i);

            if(y % 2 == 0) {
                ans[i] = -1;
                continue;
            }

            if((y & (y + 1)) == 0) {
                ans[i] = y >> 1;
            } 
            else {
                int lowest = y & -y;
                ans[i] = y - lowest;
            }
        }

        return ans;
    }
}


/****************************************************************************************************** */

public class BitwisePrimeOR {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(2, 3, 5, 7);

        Slution sol = new Slution();
        int[] result = sol.minBitwiseArray(nums);

        System.out.println(Arrays.toString(result));
    }
}




/********************************************************************************************************* */