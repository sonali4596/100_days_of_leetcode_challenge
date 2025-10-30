//1526. Minimum Number of Increments on Subarrays to Form a Target Array
class Solution {
    public int minNumberOperations(int[] target) {
        long ops = 0;
        int prev = 0;
        for (int x : target) {
            if (x > prev) ops += x - prev;
            prev = x;
        }
        return (int) ops;
    }
}
