//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1265 👎 0

  
package com.shuzijun.leetcode.editor.en;

import com.shuzijun.leetcode.editor.en.doc.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DiameterOfBinaryTree{

    public static void main(String[] args) {
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        TreeNode n2=new TreeNode(3,n4,n5);
        TreeNode n1=new TreeNode(3,n2,n3);

        Solution solution = new DiameterOfBinaryTree().new Solution();
        solution.diameterOfBinaryTree(n1);
    }
//    链表的数据结构
//    public static class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }
//    ListNode n3=new ListNode(-4);
//    ListNode n2=new ListNode(0,n3);
//    ListNode n1=new ListNode(2,n2);
//    ListNode p=new ListNode(-1,n1);


    
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //（后序）遍历法*************************************//
    int maxWidth=0;
    public int diameterOfBinaryTree(TreeNode root) {
        traveral(root);
        return maxWidth;
    }

    public int traveral(TreeNode root) {
        if (root==null)return 0;
        int left=traveral(root.left);
        int right=traveral(root.right);
        int myWidth=left+right;
        maxWidth=Math.max(myWidth,maxWidth);
        return Math.max(right,left)+1;
    }



//  （前序）遍历法*************************************//
//    int maxWidth=0;
//    public int diameterOfBinaryTree(TreeNode root) {
//        traveral(root);
//        return maxWidth;
//    }
//
//    public void traveral(TreeNode root) {
//        if (root==null)return;
//        maxWidth=Math.max(maxWidth,maxDepth(root.left)+maxDepth(root.right));
//        traveral(root.left);
//        traveral(root.right);
//    }
//
//    public int maxDepth(TreeNode root)
//    {
//        int res=traverse2(root);
//        return res;
//    }
//
//    public int traverse2(TreeNode t)
//    {
//        if (t==null)return 0;
//        int leftMaxDepth=traverse2(t.left);
//        int rightMaxDepth=traverse2(t.right);
//        return Math.max(leftMaxDepth,rightMaxDepth)+1;
//    }


//  分解法 *************************************//
//    public int diameterOfBinaryTree(TreeNode root) {
//        if (root==null)return 0;
//        int myWidth=maxDepth(root.left)+maxDepth(root.right);
//        int leftWidth=diameterOfBinaryTree(root.left);
//        int rightWidth=diameterOfBinaryTree(root.right);
//        return Math.max(myWidth,Math.max(leftWidth,rightWidth)) ;
//    }
//    public int maxDepth(TreeNode root)
//    {
//        int res=traverse2(root);
//        return res;
//    }
//
//    public int traverse2(TreeNode t)
//    {
//        if (t==null)return 0;
//        int leftMaxDepth=traverse2(t.left);
//        int rightMaxDepth=traverse2(t.right);
//        return Math.max(leftMaxDepth,rightMaxDepth)+1;
//    }



}
//leetcode submit region end(Prohibit modification and deletion)

}

