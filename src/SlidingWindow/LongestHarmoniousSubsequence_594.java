package SlidingWindow;

import java.util.Arrays;

public class LongestHarmoniousSubsequence_594 {
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
    }

    /*
        Hashmap approach:
        Count the number of occurrene and put in hashmap
        Then loop through keyset to the the max length

        Runtime: O(n)
        Space: O(n)
    */
    /*public static int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxLength = 0;

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int length = map.get(key) + map.get(key + 1);
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }*/

    /*
        Sliding window approach
    */
    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = 1, res = 0;
        while(r < nums.length) {
            int diff = nums[r] - nums[l];
            if(diff == 1) res = Math.max(res, r - l + 1);
            if(diff <= 1) r++;
            else l++;
        }
        return res;
    }
}