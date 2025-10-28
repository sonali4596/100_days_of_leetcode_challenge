//3354. Make Array Elements Equal to Zero

class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        long total = 0;
        for (int x : nums) total += x;

        long prefix = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            long rightSum = total - prefix - nums[i];

            if (nums[i] == 0) {
                if (prefix == rightSum) {
                    result += 2;
                } else if (Math.abs(prefix - rightSum) == 1) {
                    result += 1;
                }
            }
            prefix += nums[i];
        }

        return result;
    }
}
