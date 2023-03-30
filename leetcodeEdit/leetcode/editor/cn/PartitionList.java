//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics 链表 双指针 👍 683 👎 0

  
package com.shuzijun.leetcode.editor.en;

import java.util.logging.Logger;

public class PartitionList{
    public static void main(String[] args) {
//        ListNode p6=new ListNode(2);
//        ListNode p5=new ListNode(5,p6);
//        ListNode p4=new ListNode(2,p5);
//        ListNode p3=new ListNode(3,p4);
//        ListNode p2=new ListNode(4,p3);
//        ListNode p1=new ListNode(1,p2);
//        ListNode p=new ListNode(-1,p1);
//        int num=3;
        ListNode p2=new ListNode(1);
        ListNode p1=new ListNode(2,p2);
        ListNode p=new ListNode(-1,p1);
        int num=2;
        Solution solution = new PartitionList().new Solution();
        ListNode res=solution.partition(p,num).next;
        while (res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }

    }
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
        public ListNode partition(ListNode head, int x) {
            ListNode p=head;
            ListNode isSmall= new ListNode(-1);
            ListNode smallP=isSmall;
            ListNode isBig= new ListNode(-1);
            ListNode bigP=isBig;

            //边界条件判断
            if (head==null)return null;


            //for
            while (p!=null){
                ListNode temp=p;
                p=p.next;
                if (temp.val<x){
                    smallP.next=temp;
                    smallP=smallP.next;
                    smallP.next=null;
                }else if(temp.val>=x){
                    bigP.next=temp;
                    bigP=bigP.next;
                    bigP.next=null;
                }
            }

            //conbine
            smallP.next=isBig.next;
            return isSmall.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}