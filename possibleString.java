import java.util.*;
public class possibleString {
   static class State {
        String str;
        int idx;

        State(String s, int i) {
            str = s;
            idx = i;
        }
    }

    public static String solve(String s, int x, int y) {

        Queue<State> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.add(new State("", 0));

        while (!q.isEmpty()) {

            State cur = q.poll();

            if (cur.idx == s.length())
                return cur.str;

            for (int d : new int[]{x, y}) {

                String next = cur.str + d;

                if (vis.contains(next)) continue;
                vis.add(next);

                int newIdx = cur.idx;

                if (newIdx < s.length() && s.charAt(newIdx) == (char)(d + '0'))
                    newIdx++;

                q.add(new State(next, newIdx));
            }
        }

        return "-1";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            String s = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(solve(s, x, y));
        }
    }
}
