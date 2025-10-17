//3003. Maximize the Number of Partitions After Operations
import java.util.*;

class Solution {
    private String s;
    private int k;
    private Map<Long, Integer> memo;

    public int maxPartitionsAfterOperations(String s, int k) {
        this.s = s;
        this.k = k;
        this.memo = new HashMap<>();
        return dfs(0, 0, 1);
    }

    private int dfs(int i, int curMask, int changeLeft) {
        if (i == s.length()) return 1;

        long key = (((long)i) << 27) | (((long)curMask) << 1) | changeLeft;
        Integer got = memo.get(key);
        if (got != null) return got;

        int v = 1 << (s.charAt(i) - 'a');
        int nxt = curMask | v;

        int best;
        if (Integer.bitCount(nxt) > k) {
            best = dfs(i + 1, v, changeLeft) + 1;
        } else {
            best = dfs(i + 1, nxt, changeLeft);
        }

        if (changeLeft == 1) {
            for (int c = 0; c < 26; ++c) {
                int v2 = 1 << c;
                int nxt2 = curMask | v2;
                if (Integer.bitCount(nxt2) > k) {
                    best = Math.max(best, dfs(i + 1, v2, 0) + 1);
                } else {
                    best = Math.max(best, dfs(i + 1, nxt2, 0));
                }
            }
        }

        memo.put(key, best);
        return best;
    }
}
