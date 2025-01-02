package DailyQuestions;

public class MaximumScoreAfterSplittingAString_1422 {
    public static void main(String[] args) {
        String s = "011101";

        int max = 0;
        int n = s.length();
        int[] zero = new int[n-1];
        int[] one = new int[n-1];

        zero[0] = s.charAt(0) == '0' ? 1:0;
        one[n-2] = s.charAt(n-1) == '1' ? 1:0;

        for (int x=1 ; x<n-1 ; x++) {
            zero[x] = s.charAt(x) == '0' ? zero[x-1] +1 : zero[x-1];
        }
        for (int y=n-2; y>0 ; y--) {
            one[y-1] = (s.charAt(y) == '1') ? one[y] + 1 : one[y];
        }

        for (int i=0; i<zero.length; i++) {
            zero[i] = zero[i] + one[i];
            max = Math.max(zero[i],max);
        }
        System.out.println(max);
    }
}