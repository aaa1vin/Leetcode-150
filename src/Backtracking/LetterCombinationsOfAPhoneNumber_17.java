package Backtracking;

import java.util.Hashtable;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_17 {
    public static void main(String[] args) {
        String digits = "23";

        Hashtable<Integer, String> numpad = new Hashtable<>();
        numpad.put(2, "abc");
        numpad.put(3, "def");
        numpad.put(4, "ghi");
        numpad.put(5, "jkl");
        numpad.put(6, "mno");
        numpad.put(7, "pqrs");
        numpad.put(8, "tuv");
        numpad.put(9, "wxyz");
    }

   // base case: currentString == digits len return list
    public static void backtrack(int idx, String currentString, String digits, List<String> res, Hashtable<Integer, String> numpad) {
        if (currentString.length() == digits.length()) {
            res.add(currentString);
        }


    }

}