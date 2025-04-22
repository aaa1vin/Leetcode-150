package Blind75.DataStructures;

public class FindMinimumInRototedSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[] {2,1};
        System.out.println(findMin(nums));
    }

    // binary search
    public static int findMin(int[] nums) {
        if (nums.length == 1){ return nums[0]; }
        int l = 0;
        int r = nums.length-1;
        while (l<r) {
            int mid = l + (r-l) /2;
            if (nums[mid] >  nums[r]) {
                l++;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }
}
