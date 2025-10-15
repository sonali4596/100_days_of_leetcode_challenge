class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int inc = 1;        
        int prev = 0;

        for (int i = 1; i < nums.size(); ++i) {
            if (nums.get(i) > nums.get(i - 1)) {
                ++inc;
            } else {
                prev = inc;
                inc = 1;
            }
            if (inc / 2 >= k || Math.min(prev, inc) >= k) return true;
        }
        return false;
    }
}
