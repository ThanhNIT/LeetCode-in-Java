package g0801_0900.s0823_binary_trees_with_factors;

// #Medium #Array #Hash_Table #Dynamic_Programming

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Long> dp = new HashMap<>();
    private Map<Integer, Integer> nums = new HashMap<>();
    private final int mod = (int) 1e9+7;

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i<arr.length; i++) {
            nums.put(arr[i], i);
        }
        long ans = 0;
        for (int i = arr.length-1; i>=0; i--) {
            ans = (ans%mod+recursion(arr, arr[i], i)%mod)%mod;
        }
        return (int) ans;
    }

    private long recursion(int[] arr, int v, int idx) {
        if (dp.containsKey(v)) {
            return dp.get(v);
        }
        long ret = 1;
        for (int i = 0; i<idx; i++) {
            int child = arr[i];
            if (v%child==0 && nums.containsKey(v/child)) {
                ret += (recursion(arr, child, nums.get(arr[i])) % mod * recursion(arr, v/child, nums.get(v/child)) % mod) % mod;
            }
        }
        dp.put(v, ret);
        return ret;
    }
}