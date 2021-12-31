package g0401_0500.s0493_reverse_pairs;

// #Hard #Array #Binary_Search #Ordered_Set #Divide_and_Conquer #Segment_Tree #Binary_Indexed_Tree #Merge_Sort

import java.util.Arrays;

public class Solution {
    //reference: https://discuss.leetcode.com/topic/78933/very-short-and-clear-mergesort-bst-java-solutions
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int cnt = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        for (int i = start, j = mid + 1; i <= mid; i++) {
            //it has to be 2.0 instead of 2, otherwise it's going to stack overflow, i.e. test3 is going to fail
            while (j <= end && nums[i] > nums[j] * 2.0) {
                j++;
            }
            cnt += j - (mid + 1);
        }
        Arrays.sort(nums, start, end + 1);
        return cnt;
    }
}