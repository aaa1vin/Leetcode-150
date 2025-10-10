package Stack;

import java.util.Stack;

public class SimplifyPath_71 {
    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String comp: split) {
            if (comp.equals(".") || (comp.equals(""))) {
                continue;
            }
            if (comp.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(comp);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0,"/" + stack.pop());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
