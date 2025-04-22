package Blind75.Sequences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> pair = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (pair.containsKey(nums[i])) {
                return new int[]{pair.get(nums[i]),i};
            }
            pair.put(target - nums[i],i);
        }
        return null;
    }
}