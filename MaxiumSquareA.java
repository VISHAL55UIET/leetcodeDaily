import java.util.*;


/********************************************************************************************** */
    //  time Complextiy O(H2+V2+HlogH+VlogV)

    //  Space Complexity = O(H²)




/*************************************************************************************************** */
public class MaxiumSquareA{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int hfSize = sc.nextInt();
        int[] hF = new int[hfSize];
        for(int i = 0; i < hfSize; i++) {
            hF[i] = sc.nextInt();
        }
        int vfSize = sc.nextInt();
        int[] vF = new int[vfSize];
        for(int i = 0; i < vfSize; i++) {
            vF[i] = sc.nextInt();
        }
        Solution sol = new Solution();
        System.out.println(sol.maximizeSquareArea(m, n, hF, vF));
    }
}

/******************************************************************************************************* */

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hF, int[] vF) {
        int MOD = 1_000_000_007;
        int[] H = new int[hF.length + 2];
        int[] V = new int[vF.length + 2];
        H[0] = 1; 
        H[H.length-1] = m;
        for(int i = 0; i < hF.length; i++) 
            H[i+1] = hF[i];  
        V[0] = 1;
        V[V.length-1] = n;
        for(int i = 0; i < vF.length; i++) 
            V[i+1] = vF[i];
        Arrays.sort(H);
        Arrays.sort(V);
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < H.length; i++){
            for(int j = i + 1; j < H.length; j++){
                set.add(H[j] - H[i]);
            }
        }
        long ans = -1;
        for(int i = 0; i < V.length; i++){
            for(int j = i + 1; j < V.length; j++){
                int gap = V[j] - V[i];
                if(set.contains(gap)){
                    ans = Math.max(ans, gap);
                }
            }
        }
        if(ans == -1) return -1;
        return (int)((ans * ans) % MOD);
    }
}





/********************************************************************************************************* */
