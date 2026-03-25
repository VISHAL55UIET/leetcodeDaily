import java.util.*; 

/********************************************************************************************* */








              
/*********************************************************************************************** */
public class EqualPartitionSum {
      public boolean canPartitionGrid(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        long totalSum = 0;
        for (int[] row : grid) {
            for (int val : row) {
                totalSum += val;
            }
        }
        long upperHalfSum = 0;
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols; j++) {
                upperHalfSum += grid[i][j];
            }
            if (upperHalfSum * 2 == totalSum) {
                return true;
            }
        }

        long[]cs = new long[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cs[j] += grid[i][j];
            }
        }

        long ls = 0;
        for (int j = 0; j < cols - 1; j++) {  
            ls += cs[j];
            if (ls * 2 == totalSum) {
                return true;
            }
        }

        return false;
    }
}
