package DailyQuestions;

import java.util.*;

public class FindLargestValueInEachTreeRow_515 {
    private static class TreeNode { //Leetcode's custom class
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
        Integer[] values = {1,3,2,5,3,null,9};
        TreeNode root = constructTree(values);
        System.out.println(largestValues(root));

    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> largestVal = new ArrayList<>();

        if (root != null) {
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                int size = q.size(); //number of nodes at current level
                int[] tmp = new int[size];

                for (int i = 0; i < size; i++) {
                    TreeNode curr = q.poll(); //dequeue
                    tmp[i] = curr.val;

                    if (curr.left != null) q.add(curr.left); //enqueue
                    if (curr.right != null) q.add(curr.right); //enqueue
                }
                int max = (int) -Math.pow(2, 31);
                for (int i = 0; i < tmp.length; i++) {
                    if (max < tmp[i]) {
                        max = tmp[i];
                    }
                }
                largestVal.add(max);
            }
        }
        return largestVal;
    }

    private static TreeNode constructTree(Integer[] values) {
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
