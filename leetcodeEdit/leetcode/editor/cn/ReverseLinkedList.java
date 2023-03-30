//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics 递归 链表 👍 3054 👎 0

  
package com.shuzijun.leetcode.editor.en;
public class ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
    }
//    链表的数据结构
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
//    ListNode n3=new ListNode(-4);
//    ListNode n2=new ListNode(0,n3);
//    ListNode n1=new ListNode(2,n2);
//    ListNode p=new ListNode(-1,n1);

//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode() {}
//        TreeNode(int val) { this.val = val; }
//        TreeNode(int val, TreeNode left, TreeNode right)
//        {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //常规实现
//    public ListNode reverseList(ListNode head) {
//        ListNode zero = new ListNode();
//        while(head!=null){
//            ListNode temp = head;
//            head=head.next;
//            temp.next=zero.next;
//            zero.next=temp;
//        }
//        return zero.next;
//    }

    //递归反转实现
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)return head;
        head=reverse(head,head.next);
        return head;
    }
    public ListNode reverse(ListNode before,ListNode head){
        if (head.next==null){
            head.next=before;
            before.next=null;
            return head;
        }
        ListNode last = reverse(head,head.next);
        head.next=before;
        before.next=null;
        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}