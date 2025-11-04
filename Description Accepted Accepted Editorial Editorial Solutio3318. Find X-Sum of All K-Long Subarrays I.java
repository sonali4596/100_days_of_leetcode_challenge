import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] out = new int[n - k + 1];

        for (int i = 0; i + k <= n; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                freq.merge(nums[j], 1, Integer::sum);
            }
            // sort by (count desc, value desc)
            List<int[]> list = new ArrayList<>();
            for (var e : freq.entrySet()) list.add(new int[]{e.getKey(), e.getValue()});
            list.sort((a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1];
                return b[0] - a[0];
            });

            int sum = 0, picked = 0;
            for (int[] p : list) {
                if (picked == x) break;
                sum += p[0] * p[1];
                picked++;
            }
            out[i] = sum;
        }
        return out;
    }
}
