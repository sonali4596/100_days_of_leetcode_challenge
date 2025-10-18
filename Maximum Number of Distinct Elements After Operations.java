//3397. Maximum Number of Distinct Elements After Operations
import java.util.*;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        long occupied = Long.MIN_VALUE / 4;

        for (int x : nums) {
            long L = (long)x - k, R = (long)x + k;
            if (occupied < R) {
                occupied = Math.max(occupied + 1, L);
                ans++;
            }
        }
        return ans;
    }
}
