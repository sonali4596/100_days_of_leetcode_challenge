
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        if (nums.size()== 0) return 0;
        int ans = 0;
        int prevRun = 0; 
        int curRun = 1;  

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                curRun++;
            } else {
                ans = Math.max(ans, curRun / 2);               
                ans = Math.max(ans, Math.min(prevRun, curRun)); 
                prevRun = curRun;
                curRun = 1;
            }
        }
        ans = Math.max(ans, curRun / 2);
        ans = Math.max(ans, Math.min(prevRun, curRun));
        return ans;
    }
}
