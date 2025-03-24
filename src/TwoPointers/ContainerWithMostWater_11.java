package TwoPointers;

public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        int[] height = {1,2,4,3};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int result = 0;

        int l=0;
        int r=height.length-1;
        while (l<r) {
            int min = Math.min(height[l], height[r]);
            result = Math.max(min * (r-l),result);

            while (l < r && height[l] <= min) l++;
            while (l < r && height[r] <= min) r--;
        }
        return result;
    }
}
