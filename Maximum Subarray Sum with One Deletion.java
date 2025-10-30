//dp
//1186. Maximum Subarray Sum with One Deletion
class Solution {
    public int maximumSum(int[] arr) {
        int keep = arr[0];            
        int drop = Integer.MIN_VALUE; 
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            int newDrop = Math.max(drop == Integer.MIN_VALUE ? Integer.MIN_VALUE : drop + x, keep);
            keep = Math.max(keep + x, x);
            drop = newDrop;
            ans = Math.max(ans, Math.max(keep, drop));
        }
        return ans;
    }
}
