package DailyQuestions;

import java.util.HashSet;

public class FindThePrefixCommonArrayOfTwoArrays_2657 {
    public static void main(String[] args) {
        int[] A = {1,3,2,4};
        int[] B = {3,1,2,4};

        int n = A.length;
        int[] res = new int[n];
        HashSet<Integer> hsA = new HashSet<>();
        HashSet<Integer> hsB = new HashSet<>();


        for (int i=0; i<n; i++) {
            hsA.add(A[i]);
            hsB.add(B[i]);

            HashSet<Integer> common = new HashSet<>(hsA);
            common.retainAll(hsB);
            res[i] = common.size();
        }
        System.out.println(res);
    }
}