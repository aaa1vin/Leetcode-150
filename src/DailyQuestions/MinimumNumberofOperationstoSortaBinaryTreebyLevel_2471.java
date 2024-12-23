package DailyQuestions;

import java.util.*;

public class MinimumNumberofOperationstoSortaBinaryTreebyLevel_2471 {
    public static class TreeNode { //Leetcode's custom class
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

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
        Integer[] values = {1, 4, 3, 7, 6, 8, 5, null, null, null, null, null, 9, null, 10};
        TreeNode root = constructTree(values);

        System.out.println(sortLevels(root));
    }

    public static int sortLevels(TreeNode root) {
        int ops = 0;

        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size(); // specify the size at each level
            TreeNode curr = q.poll();

            for (int i = 0; i < size; i++) {
                curr = q.remove();

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }


        // to add in sort logic
        return ops;
    }

    public static TreeNode constructTree(Integer[] values) {
        if (values == null || values.length == 0) return null;

        // Create the root node
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1; // Start from the second element
        while (i < values.length) {
            TreeNode current = queue.poll();

            // Assign the left child
            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;

            // Assign the right child
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
}