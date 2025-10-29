//3370. Smallest Number With All Set Bits
class Solution {
    public int smallestNumber(int n) {
        int k = Integer.SIZE - Integer.numberOfLeadingZeros(n); 
        return (1 << k) - 1;
    }
}
