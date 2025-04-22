package Blind75.Sequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        /*
        Use for loop to traverse left to right
        use while loop for 2 pointer
        */
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // check distinct
            if (i> 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int total = nums[i] + nums[l] + nums[r];
                if (total == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    while (nums[l] == nums[l-1] && l<r) { // check distinct
                        l++;
                    }
                } else if (total < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }


        return res;
    }
}
