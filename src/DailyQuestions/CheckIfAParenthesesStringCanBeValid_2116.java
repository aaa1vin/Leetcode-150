package DailyQuestions;

import java.util.Stack;

public class CheckIfAParenthesesStringCanBeValid_2116 {
    public static void main(String[] args) {
        String s = "((()(()()))()((()()))))()((()(()";
        String locked = "10111100100101001110100010001001";

        int n = s.length();
        boolean tf = true;
        if (n%2 == 1) tf = false;

        /*
        Stack method
         */
        Stack<Integer> match = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else if (s.charAt(i) == '(') {
                match.push(i);
            } else if (s.charAt(i) == ')') {
                if (!match.empty()) {
                    match.pop();
                } else if (!unlocked.empty()) {
                    unlocked.pop();
                } else {
                    tf = false;
                    break;
                }
            }
        }

        while (!match.empty() && !unlocked.empty() && match.peek() < unlocked.peek()) {
            match.pop();
            unlocked.pop();
        }

        if (!match.empty()) {
            tf = false;
        }

        System.out.println(String.valueOf(tf));


        /*
        Using lower and upper bound
        lower: to be matched with
        upper: ambigious, can match make with other pairs
         */
/*        int upper = 0;
        int lower = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    lower++;
                    upper++;
                } else {
                    lower--;
                    upper--;
                }
            } else {
                upper++;
                lower--;
            }
            if (lower < 0) {
                lower += 2;
            }
            if (upper < 0) {
                return false;
            }
        }
        return lower == 0;*/
    }
}