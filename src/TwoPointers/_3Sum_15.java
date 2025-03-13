package TwoPointers;

import java.util.*;

public class _3Sum_15 {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        System.out.println(threeSum(nums).toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        int size = nums.length;
        for (int i=0; i<size-1; i++) {
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            Set<Integer> seen = new HashSet<>();
            for (int j=i+1; j<size;j++) {
                int toFind = -nums[i] - nums[j];
                if (seen.contains(toFind)) {
                    res.add(Arrays.asList(nums[i],nums[j],toFind));

                    while (j + 1 < size && nums[j] == nums[j + 1]) j++;
                }
                seen.add(nums[j]);
            }
        }
        return res;
    }
}
