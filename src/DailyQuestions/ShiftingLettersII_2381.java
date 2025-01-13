package DailyQuestions;

public class ShiftingLettersII_2381 {
    public static void main(String[] args) {
        String s = "xuwdbdqik";
        int[][] shifts = {{4,8,0},{4,4,0},{2,4,0},{2,4,0},{6,7,1},{2,2,1},{0,2,1},{8,8,0},{1,3,1}}; // [start: end: direction]

        int n = s.length();
        int[] ops = new int[n+1];
        for (int[] shift : shifts) {
            int end = shift[1] + 1;
            int value = (shift[2] == 1) ? 1 : -1;
            ops[shift[0]] += value;
            if (end < n) {
                ops[end] -= value;
            }
        }

        int cumulativeShift = 0;
        for (int i = 0; i < n; i++) {
            cumulativeShift += ops[i];
            ops[i] = cumulativeShift;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int ch = (s.charAt(i) - 'a' + ops[i]) % 26;
            if (ch < 0) {
                ch += 26;
            }
            sb.append((char) (ch + 'a'));
        }
        System.out.println(sb.toString());
    }



    //Reference
    /*static {
        for(int i = 0 ; i < 500 ; i++ ){
            shiftingLetters(" " , new int[][]{{0 , 0 , 0}});
        }
    }
    public static String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < shifts.length; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int dir = shifts[i][2];
            int val = dir == 0 ? -1 : 1;
            prefix[start] += val;
            if (end + 1 < n) {
                prefix[end + 1] -= val;
            }
        }
        for (int i = 1; i < n; i++) {
            prefix[i] += prefix[i - 1];
        }
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            int shift = prefix[i];
            int o = s.charAt(i) - 'a';
            int sc = (o + shift) % 26;
            if (sc < 0) {
                sc += 26;
            }
            result[i] = (char) ('a' + sc);
        }

        return new String(result);
    }*/
}