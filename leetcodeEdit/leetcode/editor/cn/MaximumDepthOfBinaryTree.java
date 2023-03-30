//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1538 👎 0

  
package com.shuzijun.leetcode.editor.en;
public class MaximumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    
    
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
//************************回溯方式***************************//
//    private int maxDepth=0;
//    private int nowDepth=0;
//    public int maxDepth(TreeNode root)
//    {
//        traverse(root);
//        return maxDepth;
//    }
//    public void traverse(TreeNode t)
//    {
//        if (t==null)return;
//        nowDepth++;
    //    前序的位置
//        maxDepth=Math.max(nowDepth,maxDepth);
//        traverse(t.left);
    //    中序的位置
//        traverse(t.right);
    //    后序的位置
//        nowDepth--;
//    }

//************************分解问题方式***************************//
    public int maxDepth(TreeNode root)
    {
        int res=traverse(root);
        return res;
    }

    public int traverse(TreeNode t)
    {
        if (t==null)return 0;
        int leftMaxDepth=traverse(t.left);
        int rightMaxDepth=traverse(t.right);
        return Math.max(leftMaxDepth,rightMaxDepth)+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}