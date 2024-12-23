package BinaryTree;

public class MaximumDepthOfBinaryTree_104 {
    public static class TreeNode { //Leetcode's custom class
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode node) {
        if (node == null) return 0;

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        System.out.println(left + " " + right);
        System.out.println(Math.max(left,right) + 1);
        return Math.max(left,right) + 1;
    }
}