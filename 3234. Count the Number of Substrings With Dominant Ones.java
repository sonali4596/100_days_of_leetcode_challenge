class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;

        // zero = number of '0's in the substring
        // zero + zero*zero <= n  (otherwise such a substring can't exist)
        for (int zero = 0; zero + zero * zero <= n; ++zero) {
            int lastInvalidPos = -1;   // last index that cannot be inside a valid substring
            int[] count = new int[2];  // count[0] = zeros, count[1] = ones

            // sliding window [l..r]
            for (int l = 0, r = 0; r < n; ++r) {
                count[s.charAt(r) - '0']++;

                // Try to shrink from the left while keeping:
                // - at most 'zero' zeros
                // - enough ones to still possibly meet ones >= zero*zero
                for (; l < r; ++l) {
                    char c = s.charAt(l);
                    if (c == '0' && count[0] > zero) {
                        // Too many zeros, we must drop this '0'
                        count[0]--;
                        lastInvalidPos = l;
                    } else if (c == '1' && count[1] - 1 >= zero * zero) {
                        // We can safely drop this '1' and still have enough ones
                        count[1]--;
                    } else {
                        // Can't remove s[l] without breaking the constraints
                        break;
                    }
                }

                // Now [l..r] is the minimal window end at r with:
                //   count[0] <= zero and if count[0] == zero, it's as short as possible 
                if (count[0] == zero && count[1] >= zero * zero) {
                    // Any start index from lastInvalidPos+1 up to l works
                    ans += l - lastInvalidPos;
                }
            }
        }

        return ans;
    }
}
