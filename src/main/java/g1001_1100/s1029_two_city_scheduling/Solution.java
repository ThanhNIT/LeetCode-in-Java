package g1001_1100.s1029_two_city_scheduling;

// #Medium #Array #Sorting #Greedy

import java.util.Arrays;

public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1] - (b[0] - b[1])));
        int cost = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                cost += costs[i][0];
            } else {
                cost += costs[i][1];
            }
        }
        return cost;
    }
}
