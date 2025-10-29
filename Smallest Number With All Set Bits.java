//3370. Smallest Number With All Set Bits
//Time: O(1) (bit ops)
//Space: O(1)
class Solution {
    public int smallestNumber(int n) {
        int k = Integer.SIZE - Integer.numberOfLeadingZeros(n); 
        return (1 << k) - 1;
    }
}
