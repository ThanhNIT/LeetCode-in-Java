package g0701_0800.s0756_pyramid_transition_matrix;

// #Medium #Depth_First_Search #Breadth_First_Search #Bit_Manipulation

import java.util.List;

public class Solution {

    private boolean dfs(char[] c, int i, int L, int[][] map) {
        if (L == 1) {
            return true;
        }
        if (i == L - 1) {
            return dfs(c, 0, L - 1, map);
        }
        char save = c[i];
        char p = 'A';
        for (int v = map[c[i] - 'A'][c[i + 1] - 'A']; v != 0; v >>= 1, p++)
            if ((v & 1) != 0) {
                c[i] = p;
                if (dfs(c, i + 1, L, map)) {
                    return true;
                }
            }
        c[i] = save;
        return false;
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int[][] map = new int[7][7];
        for (String s : allowed) {
            map[s.charAt(0) - 'A'][s.charAt(1) - 'A'] |= 1 << (s.charAt(2) - 'A');
        }
        return dfs(bottom.toCharArray(), 0, bottom.length(), map);
    }
}
