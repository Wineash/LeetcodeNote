//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 963 👎 0

  
package com.shuzijun.leetcode.editor.en;

import com.shuzijun.leetcode.editor.en.doc.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree{
    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2,n4,n5);
        TreeNode n1 = new TreeNode(1,n2,n3);
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();

        System.out.println(solution.minDepth(n1));
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

class Solution {
    public int minDepth(TreeNode root) {
        if (root==null)return 0;

        int deep=1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            //不要让size变动
            int nowSize=q.size();
            //一个for一层
            for (int i=0;i<nowSize;i++){
                TreeNode node = q.poll();
                if (node.left==null&&node.right==null){
                    return deep;
                }
                if (node.left!=null){
                    q.offer(node.left);
                }
                if (node.right!=null){
                    q.offer(node.right);
                }
            }
            deep++;
        }
        return deep;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}