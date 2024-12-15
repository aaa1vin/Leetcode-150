package DailyQuestions;

import java.util.Arrays;

public class MaximumAveragePassRatio_1792 {
    public static void main(String[] args) {
        int[][] classes = {{2,4},{3,9},{4,5},{2,10}};
        int extraStudents = 4;

        double bestRatio = 0;
        double[][] permutate = new double[classes.length][2];
        double diff = 0;
        int point = 0;

        for (int i=0; i<classes.length; i++) {
            double x = classes[i][0];
            double y = classes[i][1];

            permutate[i][0] = (x/y);
            permutate[i][1] = (x+extraStudents) / (y+extraStudents);

            if (diff < permutate[i][1] - permutate[i][0]) {
                diff = permutate[i][1] - permutate[i][0];
                point = i;
            }
        }

        for (int j=0 ; j< classes.length ; j++) {
            if (j == point) {
                bestRatio += permutate[j][1];
            } else {
                bestRatio += permutate[j][0];
            }
        }
        System.out.println(Arrays.deepToString(permutate));
        System.out.println(bestRatio/= classes.length);
    }
}