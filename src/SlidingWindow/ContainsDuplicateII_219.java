package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII_219 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        Set<Integer> win = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (i-l >k) {
                win.remove(nums[l]);
                l++;
            }

            if (win.contains(nums[i])) {
                return true;
            }
            win.add(nums[i]);
        }
        return false;
    }
}