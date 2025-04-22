package OctoberGrinds.Math;

public class _172FactorialTrailingZeros {
    public static void main(String[] args) {
        int n = 200;
        System.out.println(trailingZeroes(n));
    }

    public static int trailingZeroes(int n) {
        /*
        Time complexity: O(log5 n)
        Space Complexity: O(1)

        +1 at every multiple of 5
        an extra +1 at every multiple of 25
        an extra +1 again at every multiple of 125, and so on (powers of 5)
        */

        if (n < 5) return 0;

        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }

        // Manual count
//        BigInteger result = BigInteger.ONE;
//        for (int i = 2; i <= n; i++) {
//            result = result.multiply(BigInteger.valueOf(i));
//            System.out.println(i + " : " + result);
//        }

        return count;
    }
}