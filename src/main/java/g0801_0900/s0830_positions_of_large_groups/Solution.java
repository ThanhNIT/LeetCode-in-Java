package g0801_0900.s0830_positions_of_large_groups;

// #Easy #String

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> map = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) j++;
            if ((j - 1) - i + 1 >= 3) {
                map.add(Arrays.asList(i, j - 1));
            }
            i = j;
        }
        return map;
    }
}
