import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/************************************************************************************************** */


     // T.C=O(E + N)

     // S.C=O(E)










/***************************************************************************************************** */

public class MinimumCostConvertString {

    public long minimumCost(
            String source,
            String target,
            char[] original,
            char[] changed,
            int[] cost
    ) {

        // Graph: from char -> (toChar, cost)
        List<int[]>[] graph = new List[26];
        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < original.length; i++) {
            graph[original[i] - 'a'].add(new int[]{changed[i] - 'a', cost[i]});
        }

        // Precompute shortest paths from every character
        long[][] dist = new long[26][26];
        for (int i = 0; i < 26; i++) {
            dist[i] = dijkstra(i, graph);
        }

        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                long c = dist[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
                if (c == -1) return -1;
                totalCost += c;
            }
        }

        return totalCost;
    }

    private long[] dijkstra(int start, List<int[]>[] graph) {

        PriorityQueue<long[]> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        long[] minCost = new long[26];
        Arrays.fill(minCost, -1);

        pq.offer(new long[]{0, start});
        minCost[start] = 0;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long cost = cur[0];
            int node = (int) cur[1];

            if (cost > minCost[node]) continue;

            for (int[] edge : graph[node]) {
                int next = edge[0];
                long newCost = cost + edge[1];

                if (minCost[next] == -1 || newCost < minCost[next]) {
                    minCost[next] = newCost;
                    pq.offer(new long[]{newCost, next});
                }
            }
        }

        return minCost;
    }
}






/************************************************************************************************** */