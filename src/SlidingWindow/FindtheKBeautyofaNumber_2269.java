package SlidingWindow;

public class FindtheKBeautyofaNumber_2269 {
    public static void main(String[] args) {
        int num = 430043, k = 2;
        System.out.println(divisorSubstrings(num, k));
    }

    public static int divisorSubstrings(int num, int k) {
        // Convert to num to string
        String s = String.valueOf(num);
        int n = s.length();
        int res = 0;

        if (k == n) return 1;

        for (int i = 0; i <= n - k; i++) {
            int win = Integer.parseInt(s.substring(i, i + k));
            if (win!=0 && num % win == 0) {
                res += 1;
            }
        }
        return res;
    }
}
