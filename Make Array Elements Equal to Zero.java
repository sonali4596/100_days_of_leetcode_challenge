//3354. Make Array Elements Equal to Zero
//Prefix–Suffix Difference Pattern (Balance Condition)

//This pattern appears when you need to:

//Compare the sum of elements to the left and right of a position, or

//Find a position where some balance or near-balance condition holds.
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
