//3542. Minimum Operations to Convert All Elements to Zero
import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);

        for (int num : nums) {
            
            while (!st.isEmpty() && st.peek() > num) {
                st.pop();
            }

            if (st.isEmpty() || st.peek() < num) {
                if (num > 0) {       // zero doesn't need its own op
                    ans++;
                }
                st.push(num);
            }
            
        }

        return ans;
    }
}
