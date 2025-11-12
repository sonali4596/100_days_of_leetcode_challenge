class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // Case 1: if we already have some 1s, we only need to convert the rest
        int ones = 0;
        for (int x : nums) if (x == 1) ones++;
        if (ones > 0) return n - ones;

        // Case 2: find the shortest subarray with gcd == 1
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            // If this single element is 1 (rare due to Case 1), best = 1
            if (g == 1) { best = 1; break; }
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    best = Math.min(best, j - i + 1);
                    break; // extending further won't give shorter length
                }
            }
        }

        if (best == Integer.MAX_VALUE) return -1; // impossible to create any 1

        return (best - 1) + (n - 1);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
