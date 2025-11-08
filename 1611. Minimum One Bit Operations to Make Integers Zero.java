class Solution {
    public int minimumOneBitOperations(int n) {
        if (n == 0) return 0;
        int k = 31 - Integer.numberOfLeadingZeros(n);   // index of highest set bit
        int mask = 1 << k;                              // that highest bit
        // (1 << (k+1)) - 1 is the cost to go from 1<<k (1000..0) down to 0
        // then subtract the cost for the remaining lower bits (Gray-like recurrence)
        return ((1 << (k + 1)) - 1) - minimumOneBitOperations(n ^ mask);
    }
}
