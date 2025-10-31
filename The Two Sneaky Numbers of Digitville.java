//3289. The Two Sneaky Numbers of Digitville
//space complexity o(n)
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans=new int[2];
        HashMap<Integer,Integer>mp=new HashMap<Integer,Integer>();
        int k=0;
        for(int i=0;i<nums.length;i++)
        {
            if(mp.containsKey(nums[i]))
            {
                ans[k]=nums[i];
                k++;
            }
            else mp.put(nums[i],1);
        }
        return ans;
    }
}
