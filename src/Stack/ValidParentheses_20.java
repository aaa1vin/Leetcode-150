package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses_20 {
    public static void main(String[] args) {
        String s = "([])";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put('}', '{');
        pair.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {

            if (pair.containsValue(c)) {
                stack.push(c);
            } else if (pair.containsKey(c)) {
                if (stack.isEmpty() || pair.get(c) != stack.pop()) {
                    return false;
                }
            }



        }
        return stack.isEmpty();
    }
}
