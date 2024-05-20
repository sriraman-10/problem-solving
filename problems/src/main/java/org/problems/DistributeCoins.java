package org.problems;

public class DistributeCoins {


    public class TreeNode {
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


    public int distributeCoins(TreeNode root) {
        TreeNode moves = new TreeNode(0);
        process(root, moves);
        return moves.val;
    }

    private int process(TreeNode root, TreeNode moves) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val - 1;
        }
        int left = process(root.left, moves);
        int right = process(root.right, moves);
        moves.val += Math.abs(left) + Math.abs(right);
        return left + right + root.val - 1;
    }

}