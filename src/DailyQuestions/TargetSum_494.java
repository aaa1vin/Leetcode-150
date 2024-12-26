package DailyQuestions;

import java.util.HashMap;
import java.util.Map;

public class TargetSum_494 {
    //Dynamic Programming
    public static void main(String[] args) {
//        int[] nums = {7,46,36,49,5,34,25,39,41,38,49,47,17,11,1,41,7,16,23,13};
//        int target = 3;

        int[] nums = {1, 1, 1};
        int target = 1;

        Map<String, Integer> memo = new HashMap<>();
        System.out.println(findWays(nums,0,0, memo, target));
    }

    public static int findWays(int[] nums, int idx, int curr, Map<String, Integer> memo, int target) {
        if (idx == nums.length) {
            return curr==target ? 1: 0;
        }

        String key = idx + "," + curr;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int add = findWays(nums, idx+1, curr+nums[idx], memo, target);
        int sub = findWays(nums, idx+1, curr-nums[idx], memo, target);

        memo.put(key, add+sub);
        return add+sub;
    }



    // Recursive way - not recommended
//    public static void main(String[] args) {
//        int[] nums = {7,46,36,49,5,34,25,39,41,38,49,47,17,11,1,41,7,16,23,13};
//        int target = 3;
//
//        Set<String> exp = new HashSet<>();
//        generateExpressions(nums, 0, 0, "", exp, target);
//
//        System.out.println(exp.size());
//    }
//
//    private static void generateExpressions(int[] nums, int idx, int currentSum, String expression, Set<String> exp, int target) {
//        if (idx == nums.length) {
//            if (currentSum == target) {
//                exp.add(expression);
//            }
//            return;
//        }
//
//        generateExpressions(nums, idx + 1, currentSum + nums[idx], expression + "+" + nums[idx], exp, target);
//        generateExpressions(nums, idx + 1, currentSum - nums[idx], expression + "-" + nums[idx], exp, target);
//    }
}