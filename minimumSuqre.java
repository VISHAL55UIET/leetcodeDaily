import java.util.*;
/***************************************************************************************** */










/*********************************************************************************************8 */
public class minimumSuqre {
   public int minSwaps(int[][] grid) {
       int n =  grid.length;
       int []zero =  new int[n];
       for(int i = 0;i<n;i++){
        int count = 0;
        for(int j = n-1;j>=0;j--){
            if(grid[i][j]==0)count++;
            else break;
        }
        zero[i]=count;
       }  
       int swap = 0;
       for(int i =0;i<n;i++){
        int required = n-i-1;
        int j = i;
        while(j<n && zero[j]<required) j++;
        while(j>i){
            if(j==n) return -1;
            int temp = zero[j];
            zero[j]=zero[j-1];
                 zero[j-1] = temp;
                 j--;
                 swap++;
            }
       }
       return swap;
    }
}
