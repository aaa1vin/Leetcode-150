package DailyQuestions;

public class ReverseOddLevelsOfBinaryTrees_2415 {
    public static class TreeNode { //Leetcode's custom class
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,
                new TreeNode(3,
                        new TreeNode(8),
                        new TreeNode(13)
                ),
                new TreeNode(5,
                        new TreeNode(21),
                        new TreeNode(34)
                )
        );

        dfs(root.left, root.right, 0);
        System.out.println(root);

//        int level = 0;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.add(root);
//
//        while (!q.isEmpty()) {
//            int size = q.size();
//            List<TreeNode> nodes = new ArrayList<>();
//
//            for (int i = 0; i < size; i++) {
//                TreeNode curr = q.poll();
//                nodes.add(curr);
//
//                if (curr.left != null) q.add(curr.left);
//                if (curr.right != null) q.add(curr.right);
//            }
//
//            if (level % 2 == 1) {
//                int n = nodes.size();
//                for (int j = 0; j < n / 2; j++) {
//                    int tmp = nodes.get(j).val;
//                    nodes.get(j).val = nodes.get(n - j - 1).val;
//                    nodes.get(n - j - 1).val = tmp;
//                }
//            }
//            level++;
//        }
//        printPreorder(root);
    }
    private static void dfs(TreeNode left, TreeNode right, int depth) {
        if (left == null && right == null) return;

        if (depth % 2 == 0) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        dfs(left.left, right.right, depth + 1);
        dfs(left.right, right.left, depth + 1);
    }

//    public static void printPreorder(TreeNode node) {
//        if (node == null) return;
//        System.out.print(node.val + " ");
//        printPreorder(node.left);
//        printPreorder(node.right);
//    }
}