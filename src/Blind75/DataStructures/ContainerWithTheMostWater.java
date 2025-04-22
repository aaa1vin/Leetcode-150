package Blind75.DataStructures;

public class ContainerWithTheMostWater {
    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    /*
    Choose the height that provides the biggest area
     */
    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;

        while (l<r) {
            // area = min of two pillars * width
            int h = Math.min(height[l], height[r]);
            res = Math.max(res, (r - l) * h);
            while (l < r && height[l] <= h) l++;
            while (l < r && height[r] <= h) r--;
        }

        return res;
    }
}