//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1530 👎 0

  
package com.shuzijun.leetcode.editor.en;

import java.util.LinkedList;

public class ReverseLinkedListIi{
    public static void main(String[] args) {

        Solution solution = new ReverseLinkedListIi().new Solution();
//        ListNode n4=new ListNode(5);
//        ListNode n3=new ListNode(4,n4);
//        ListNode n2=new ListNode(3,n3);
        ListNode n1=new ListNode(5);
        ListNode p=new ListNode(3,n1);
        int left = 1;
        int right = 2;
        solution.reverseBetween(p,left,right);
    }
//    链表的数据结构
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        //无需处理的情况
        if (head.next==null || left==right)return head;

        //记录反转节点前驱
        ListNode before=null;

        //获取反转节点最后的后驱
        ListNode start=head;
        int end=right;
        while (--end>0){
            start=start.next;
        }
        ListNode allend =start.next;

        //获取反转节点前驱
        start=head;
        int go=left;
        while (--go>0){
            before=start;
            start=start.next;
        }

        //反转的链表长度
        int step=right-left;

        //前驱是否为空，有两种返回状态
        if (before==null){
            return reverse(start,allend,step);
        }else {
            before.next=reverse(start,allend,step);
            return head;
        }


    }

    public ListNode reverse(ListNode head, ListNode before,int step){

        //base case变成步数
        if (step==0){
            head.next=before;
            return head;
        }
        step--;

        //逐级递归至最后节点
        ListNode last = reverse(head.next,head,step);
        //当前节点更改next指向
        head.next=before;
        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}