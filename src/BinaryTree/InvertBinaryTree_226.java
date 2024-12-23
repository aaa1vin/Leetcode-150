package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertBinaryTree_226 {
    public static class TreeNode { //Leetcode's custom class
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        @Override
        public String toString() {
            return String.valueOf(val); // Print the value of the node
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                null
        );

        invertTree(root);
        printPreorder(root);
    }

    //BFS
    public static void invertTree(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> levelNodes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                levelNodes.add(curr);

                if (curr.left != null) {
                    q.offer(curr.left);
                } else {
                    q.offer(null);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                } else {
                    q.offer(null);
                }
            }

            int l = 0, r = levelNodes.size() - 1;
            while (l < r) {
                Integer temp = levelNodes.get(l).val;
                levelNodes.get(l).val = levelNodes.get(r).val;
                levelNodes.get(r).val = temp;

                l++;
                r--;
            }
        }
    }

    public static void printPreorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}
