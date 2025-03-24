package ArrayString;

import java.util.Arrays;

public class MergeSortedArray_88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int main = m+n-1;
        int midx = m-1;
        int nidx = n-1;

        while (nidx >= 0) {
            if (nums1[midx] > nums2[nidx]) {
                nums1[main] = nums1[midx];
                midx--;
            } else {
                nums1[main] = nums2[nidx];
                nidx--;
            }
            main--;
        }
    }
}
