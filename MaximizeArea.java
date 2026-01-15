import java.util.*;

//*********************************************************************************************** */




  // You will find Daily LeetCode POTD solutions here in Java.
// Each solution includes:
// 1) Brute Force approach
// 2) Optimized approach
// 3) Time and Space Complexity analysis
     //O(H log H + V log V)

// Optimize approach
//****************************************************************************************************** */
public class MaximizeArea{

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = maxGraph(hBars);
        int maxV = maxGraph(vBars);
        int side = Math.min(maxH, maxV);
        return side * side;
    }

    public int maxGraph(int[] bars) {
        if (bars.length == 0) return 1;

        Arrays.sort(bars);
        int maxOnes = 1;
        int curr = 1;

        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                curr++;
            } else {
                curr = 1;
            }
            maxOnes = Math.max(maxOnes, curr);
        }
        return maxOnes + 1;
    }
    //************************************************************************************************* */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // input horizontal bars
        int h = sc.nextInt(); // size of hBars
        int[] hBars = new int[h];
        for (int i = 0; i < h; i++) {
            hBars[i] = sc.nextInt();
        }
        // input vertical bars
        int v = sc.nextInt(); // size of vBars
        int[] vBars = new int[v];
        for (int i = 0; i < v; i++) {
            vBars[i] = sc.nextInt();
        }

        MaximizeArea sol = new MaximizeArea();
        int ans = sol.maximizeSquareHoleArea(n, m, hBars, vBars);
        System.out.println(ans);

        sc.close();
    }
}



//****************************************************************************************************** */