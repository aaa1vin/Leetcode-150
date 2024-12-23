package DailyQuestions;

import java.util.*;

public class MinimumNumberofOperationstoSortaBinaryTreebyLevel_2471 {
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

    private static void main(String[] args) {
        Integer[] values = {1, 4, 3, 7, 6, 8, 5, null, null, null, null, null, 9, null, 10};
        TreeNode root = constructTree(values);

        System.out.println(sort(root));
    }

    private static int sort(TreeNode root) {
        int n = 0;
        if (root == null) return 0;

        //Use BFS logic
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size(); //number of nodes at current level
            int[] tmp = new int[size];

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll(); //dequeue
                tmp[i] = curr.val;

                if (curr.left != null) q.add(curr.left); //enqueue
                if (curr.right != null) q.add(curr.right); //enqueue
            }
            //Sorting logic
            int[] sorted = Arrays.copyOf(tmp,tmp.length);
            Arrays.sort(sorted);
            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i] != sorted[i]) {
                    int ph = tmp[i];
                    tmp[indexOf(tmp,sorted[i])] = ph;
                    tmp[i] = sorted[i];
                    n++;
                }
            }
        }
        return n;
    }

    private static int indexOf(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) return i;
        }
        return -1;
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