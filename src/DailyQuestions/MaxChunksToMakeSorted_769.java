package DailyQuestions;

public class MaxChunksToMakeSorted_769 {
    public static void main(String[] args) {
        int[] arr = {1,0};

        int res = 0;
        int cur_max = -1;
        for (int i=0; i<arr.length; i++) {
            cur_max = Math.max(arr[i],cur_max);
            if (cur_max == i) {
                res += 1;
            }
        }

        System.out.println(res);
    }
}