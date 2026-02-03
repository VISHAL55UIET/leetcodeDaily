import java.util.*;
/********************************************************************************************** */










/*********************************************************************************************** */


  // T.C = O(N^3)

  // S.C = O(1)


   /******************************************************************************************** */
public class TrionicArrayOne {
    public boolean isTrionic(int[] nums) {
         int n =  nums.length;
          if(n<=3) return false;
          for(int p = 1;p<=n-3;p++){
               boolean inc1 = true;
            for(int i = 0;i<p;i++){
                if(nums[i]>=nums[i+1]){
                    inc1 =  false;
                    break;
                }
            }
              if(!inc1) continue;
            for(int q = p+1;q<=n-2;q++){
                boolean dec = true;
                for(int i = p;i<q;i++){
                    if(nums[i]<=nums[i+1]){
                        dec =  false;
                        break;
                    }
                }
              if(!dec) continue;
                boolean inc2 =  true;
                for(int i = q;i<n-1;i++){
             if(nums[i]>=nums[i+1]){
                inc2 = false;
                break;
             }
                }
                if(inc2) return true;
            }
          }
          return false;
    }
}




/*********************************************************************************************** */




// METHOD = 2




/***************************************************************************************************** */
class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int i = 0;
        //increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0 || i == n - 1) return false;
        // decreasing
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }
        if (i == n - 1) return false;
        // increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        return i == n - 1;
    }
}


/*************************************************************************************************** */