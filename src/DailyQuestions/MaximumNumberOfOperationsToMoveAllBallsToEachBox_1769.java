package DailyQuestions;

import java.util.Arrays;

public class MaximumNumberOfOperationsToMoveAllBallsToEachBox_1769 {
    public static void main(String[] args) {
        String boxes = "001011";

        int size = boxes.length();

        int[] result = new int[size];
        int idx = 0;
        while (idx <size) {
            int count = 0;
            for (int x=0; x<size; x++) {
                int val = boxes.charAt(x) - 48;
                if (val == 1 && idx != x) {
                    count += Math.abs(x - idx);
                }
            }
            result[idx] = count;
            idx++;
        }
        System.out.println(Arrays.toString(result));
    }
}