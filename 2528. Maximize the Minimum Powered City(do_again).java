//2528. Maximize the Minimum Powered City (hard)
class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + stations[i];
        }

        long[] power = new long[n];
        for (int i = 0; i < n; i++) {
            int L = Math.max(0, i - r);
            int R = Math.min(n - 1, i + r);
            power[i] = pref[R + 1] - pref[L];
        }

        long low = 0;
        long high = pref[n] + k; // safe upper bound

        while (low < high) {
            long mid = (low + high + 1) >>> 1;  // upper mid

            if (can(mid, power, n, r, k)) {
                low = mid;    // mid is achievable, try higher
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean can(long mid, long[] power, int n, int r, long k) {
        long used = 0;
        long addCover = 0;
        long[] extra = new long[n];

        for (int i = 0; i < n; i++) {
            int idx = i - r - 1;
            if (idx >= 0) addCover -= extra[idx];

            long cur = power[i] + addCover;

            if (cur < mid) {
                long need = mid - cur;
                if (used + need > k) return false;

                int pos = Math.min(n - 1, i + r);
                extra[pos] += need;
                addCover += need;
                used += need;
            }
        }
        return true;
    }
}
