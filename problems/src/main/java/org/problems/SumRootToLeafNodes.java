package org.problems;



class TreeNode {
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
public class SumRootToLeafNodes {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2,null,null);
        TreeNode right = new TreeNode(3, null, null);
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(sumNumbers(root));
    }
    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    public static int dfs(TreeNode root, int sum)
    {
        if(root == null)
            return 0;

        sum = sum * 10 + root.val;

        if(root.left == null && root.right == null)
            return sum;

        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}
