package DailyQuestions;

public class BitwiseXOROfAllPairings_2425 {
    public static void main(String[] args) {
        int[] nums1 = {2,1,3};
        int[] nums2 = {10,2,5,0};

        int x = 0, y = 0;
        for (int a: nums1)
            x ^= a;
        for (int b: nums2)
            y ^= b;
        System.out.println((nums1.length % 2 * y) ^ (nums2.length % 2 * x));
    }
}