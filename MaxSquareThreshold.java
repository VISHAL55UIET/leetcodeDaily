
import java.util.*;


/******************************************************************************************************** */


    // O(n*m)  +  log(min(n,m)) * O(n*m)  O(n * m * log(min(n,m)))


   



  // Space → O(n * m)






/********************************************************************************************************* */
public class MaxSquareThreshold {

    public static int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] pre = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                pre[i][j] = mat[i-1][j-1]
                          + pre[i-1][j]
                          + pre[i][j-1]
                          - pre[i-1][j-1];
            }
        }

        int low = 0, high = Math.min(n,m);
        int ans = 0;

        while(low <= high){
            int mid = (low + high)/2;

            if(check(mid, pre, threshold, n, m)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }

    static boolean check(int k, int[][] pre, int t, int n, int m){

        for(int i=k;i<=n;i++){
            for(int j=k;j<=m;j++){

                int sum = pre[i][j]
                        - pre[i-k][j]
                        - pre[i][j-k]
                        + pre[i-k][j-k];

                if(sum <= t) return true;
            }
        }

        return false;
    }




/***************************************************************************************************** */

    public static void main(String[] args) {

        int[][] mat = {
            {1,1,3,2,4,3,2},
            {1,1,3,2,4,3,2},
            {1,1,3,2,4,3,2}
        };

        int threshold = 4;

        System.out.println(maxSideLength(mat, threshold));
    }
}




/******************************************************************************************************* */