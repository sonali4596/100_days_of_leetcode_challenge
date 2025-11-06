//3607. Power Grid Maintenance
//solved by dsu
import java.util.*;

class Solution {
    static class DSU {
        int[] p, r;
        DSU(int n){
            p = new int[n+1];
            r = new int[n+1];
            for (int i = 1; i <= n; i++) p[i] = i;
        }
        int find(int x){ return p[x]==x ? x : (p[x] = find(p[x])); }
        void union(int a, int b){
            a = find(a); b = find(b);
            if (a == b) return;
            if (r[a] < r[b]) { int t=a; a=b; b=t; }
            p[b] = a;
            if (r[a] == r[b]) r[a]++;
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c);
        for (int[] e : connections) dsu.union(e[0], e[1]);

        // 2) Bucket stations by component root
        Map<Integer, TreeSet<Integer>> compSet = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            compSet.computeIfAbsent(root, k -> new TreeSet<>()).add(i); // initially all online
        }

        boolean[] online = new boolean[c+1];
        Arrays.fill(online, true);

        
        List<Integer> out = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0], x = q[1];
            if (type == 1) { 
                if (online[x]) {
                    out.add(x);
                } else {
                    int root = dsu.find(x);
                    TreeSet<Integer> set = compSet.get(root);
                    if (set == null || set.isEmpty()) out.add(-1);
                    else out.add(set.first()); // smallest online id in this component
                }
            } else { // type == 2: go offline
                if (online[x]) {
                    online[x] = false;
                    int root = dsu.find(x);
                    TreeSet<Integer> set = compSet.get(root);
                    if (set != null) set.remove(x);
                }
            }
        }
        int[] ans = new int[out.size()];
        for (int i = 0; i < out.size(); i++) ans[i] = out.get(i);
        return ans;
    }
}
