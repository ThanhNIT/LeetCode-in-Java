package g0001_0100.s0007_reverse_integer;

// #Medium #Top_Interview_Questions #Math #2022_02_17_Time_2_ms_(66.13%)_Space_41.4_MB_(15.90%)

public class Solution {
    public int reverse(int x) {
        long rev = 0;
        while (x != 0) {
            rev = (rev * 10) + (x % 10);
            x /= 10;
        }
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) rev;
    }
}