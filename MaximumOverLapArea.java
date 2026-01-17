import java.util.*;


    // Time Complexity:   O(n2)






//********************************************************************************************************* */

public class MaximumOverLapArea {

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxSide = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int w =
                    Math.min(topRight[i][0], topRight[j][0]) -
                    Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int h =
                    Math.min(topRight[i][1], topRight[j][1]) -
                    Math.max(bottomLeft[i][1], bottomLeft[j][1]);

                if (w > 0 && h > 0) {
                    int side = Math.min(w, h);
                    maxSide = Math.max(maxSide, side);
                }
            }
        }
        return maxSide * maxSide;
    }




    //********************************************************************************************** */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] bottomLeft = new int[n][2];
        int[][] topRight = new int[n][2];

        for (int i = 0; i < n; i++) {
            bottomLeft[i][0] = sc.nextInt();
            bottomLeft[i][1] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            topRight[i][0] = sc.nextInt();
            topRight[i][1] = sc.nextInt();
        }

        MaximumOverLapArea sol = new MaximumOverLapArea();
        long result = sol.largestSquareArea(bottomLeft, topRight);
        System.out.println(result);

 
    }
}


//***************************************************************************************************** */