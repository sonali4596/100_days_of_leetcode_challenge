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

//optimized 
//t.c o(n) s.c o(1)
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = 0;
        // n is max value range, i.e., 1 + max(nums[i]) or given externally.
        // From constraints we can derive n = 1 + max(nums[i]), but since
        // 0 <= nums[i] < n and nums.length = n+2, we can compute n as:
        for (int x : nums) n = Math.max(n, x + 1);

        // Count occurrences by adding n at index = value
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i] % n;       // original value
            nums[v] += n;              // bump count for value v
        }

        int[] ans = new int[2];
        int k = 0;
        for (int v = 0; v < n; v++) {
            int freq = nums[v] / n;    // how many times v appeared
            if (freq >= 2) ans[k++] = v;
        }
        return ans;
    }
}

