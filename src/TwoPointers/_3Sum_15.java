package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum_15 {
    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int size = nums.length;
        Arrays.sort(nums);

        for (int i=0; i<size ; i++) {
            if (i> 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int l = i + 1;
            int r = size-1;

            while (l < r) {
                int total = nums[i] + nums[l] + nums[r];

                if (total > 0) {
                    r--;
                } else if (total < 0) {
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    l++;
                    while (nums[l] == nums[l-1] && l<r) {
                        l++;
                    }
                }
            }
        }

        return res;
    }
}
