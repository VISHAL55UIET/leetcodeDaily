import java.util.*;

/*************************************************************************************************** */





      // T.C=O((n + m) log n)



     // S.C=O(n + m)








/**************************************************************************************************** */


public class minCost {

    static class Edge {
        int to, w;
        Edge(int t, int w) {
            this.to = t;
            this.w = w;
        }
    }

    static class State {
        int node, used;
        long dist;
        State(int n, int u, long d) {
            node = n;
            used = u;
            dist = d;
        }
    }

    public static int minCost(int n, int[][] edges) {

        List<Edge>[] out = new ArrayList[n];
        List<Edge>[] in = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            out[i] = new ArrayList<>();
            in[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            out[e[0]].add(new Edge(e[1], e[2]));
            in[e[1]].add(new Edge(e[0], e[2]));
        }

        long INF = Long.MAX_VALUE / 4;
        long[][] dist = new long[n][2];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);

        PriorityQueue<State> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a.dist));

        dist[0][0] = 0;
        pq.add(new State(0, 0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.node;
            long d = cur.dist;

            if (d > dist[u][cur.used]) continue;

            // normal edges
            for (Edge e : out[u]) {
                long nd = d + e.w;
                if (nd < dist[e.to][0]) {
                    dist[e.to][0] = nd;
                    pq.add(new State(e.to, 0, nd));
                }
            }

            // reverse edges once (cost doubled)
            if (cur.used == 0) {
                for (Edge e : in[u]) {
                    long nd = d + 2L * e.w;
                    if (nd < dist[e.to][0]) {
                        dist[e.to][0] = nd;
                        pq.add(new State(e.to, 0, nd));
                    }
                }
            }
        }

        long ans = dist[n - 1][0];
        return ans >= INF ? -1 : (int) ans;
    }

    // REQUIRED to run: java minCost



    /************************************************************************************************ */
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {
                {0, 1, 5},
                {1, 2, 3}
        };

        System.out.println(minCost(n, edges));
    }
}






/***************************************************************************************************** */