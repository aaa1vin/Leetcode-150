package Intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;

        // if nums size is 0
        if (n == 0) return res;

        // if nums size more than 1
        int start = nums[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i == n || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    res.add(String.valueOf(start));
                } else {
                    sb.append(start).append("->").append(nums[i - 1]);
                    res.add(sb.toString());
                    sb.setLength(0);
                }

                if (i < n) start = nums[i];
            }
        }

        return res;
    }
}