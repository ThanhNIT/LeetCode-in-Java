package g3001_3100.s3013_divide_an_array_into_subarrays_with_minimum_cost_ii;

import java.util.Comparator;
import java.util.TreeSet;

public class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        Comparator<Integer> comparator =
                (i, j) ->
                        nums[i] == nums[j]
                                ? Integer.compare(i, j)
                                : Integer.compare(nums[i], nums[j]);
        TreeSet<Integer> used = new TreeSet<>(comparator), unused = new TreeSet<>(comparator);
        k--;
        long sum = 0;
        long n = nums.length;
        long answer = Long.MAX_VALUE;

        for (int currentWindow = 1; currentWindow <= Math.min(dist + 1, n - 1); currentWindow++) {
            sum += nums[currentWindow];
            used.add(currentWindow);
        }

        while (used.size() > k) {
            int largeValueIndex = used.pollLast();
            sum -= nums[largeValueIndex];
            unused.add(largeValueIndex);
        }

        answer = Math.min(sum, answer);

        for (int currentWindow = dist + 2, prevWindow = 1;
                currentWindow < n;
                currentWindow++, prevWindow++) {
            unused.add(currentWindow);

            if (used.contains(prevWindow)) {
                sum -= nums[prevWindow];
                used.remove(prevWindow);
                int smallValueIndex = unused.pollFirst();
                sum += nums[smallValueIndex];
                used.add(smallValueIndex);
            } else {
                unused.remove(prevWindow);

                if (nums[used.last()] > nums[unused.first()]) {
                    int largeValueIndex = used.pollLast();
                    sum -= nums[largeValueIndex];
                    unused.add(largeValueIndex);
                    int smallValueIndex = unused.pollFirst();
                    sum += nums[smallValueIndex];
                    used.add(smallValueIndex);
                }
            }
            answer = Math.min(answer, sum);
        }
        return nums[0] + answer;
    }
}
