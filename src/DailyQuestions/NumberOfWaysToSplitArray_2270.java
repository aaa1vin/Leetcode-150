package DailyQuestions;

public class NumberOfWaysToSplitArray_2270 {
    public static void main(String[] args) {
        int[] nums = {10,4,-8,7};

        int count = 0;
        int size = nums.length;
        //sum from left
        long[] left = new long[size-1];
        //sum from right
        long[] right = new long[size-1];

        //left
        left[0] = nums[0];
        for (int i=1; i<size-1 ; i++) {
            left[i] = left[i-1] + nums[i];
        }

        right[size-2] = nums[size-1];
        for (int i=size-3 ; i>=0 ; i--) {
            right[i] = right[i+1] + nums[i+1];
        }

        for (int x=0; x<left.length ; x++) {
            if (left[x] >= right[x]) {
                count += 1;
            }
        }

        System.out.println(count);
    }
}