package DailyQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindScoreOfAnArrayAfterMarkingAllElements_2593 {
    public static void main(String[] args) {
//        int[] nums = {2,3,5,1,3,2};
        int[] nums = {10, 44, 10, 8, 48, 30, 17, 38, 41, 27, 16, 33, 45, 45, 34, 30, 22, 3, 42, 42};

        // Create a 2D array
        int n = nums.length;
        int [][] arr2d = new int[n][2];
        for (int i = 0 ; i<n ; i++) {
            arr2d[i][0] = nums[i];
            arr2d[i][1] = i;
        }

        // Sort the array
        Arrays.sort(arr2d, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1]-b[1];
            }
            return a[0] - b[0];
        });

        Set<Integer> set = new HashSet<>();
        long score = 0;
        for (int i = 0 ; i < n ; i++) {
            int val = arr2d[i][0];
            int index = arr2d[i][1];

            if (!set.contains(index)) {
                score += val;
                set.add(index);
                set.add(index + 1);
                set.add(index - 1);
            }
        }

    }
}