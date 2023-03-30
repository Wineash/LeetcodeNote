//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1648 👎 0

  
package com.shuzijun.leetcode.editor.en;

import java.util.List;

public class PalindromeLinkedList{
    public static void main(String[] args) {
        ListNode n4=new ListNode(5);
        ListNode n3=new ListNode(4,n4);
        ListNode n2=new ListNode(3,n3);
        ListNode n1=new ListNode(2);
        ListNode p=new ListNode(1,n1);
        Solution solution = new PalindromeLinkedList().new Solution();
        solution.isPalindrome(p);
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }


    }

    
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
      //递归 On On
//    ListNode left=null;
//    public boolean isPalindrome(ListNode head) {
//        left = head;
//        return nodeIsLindraome(head);
//    }
//    public boolean nodeIsLindraome(ListNode right){
//        if (right==null)return true;
//        boolean res = nodeIsLindraome(right.next);
//        if (res==false)return res;
//        if (left.val!= right.val)res=false;
//        left=left.next;
//        return res;
//    }

    //部分迭代反转 On O1
    public boolean isPalindrome(ListNode head) {
        if (head==null)return false;
        if (head.next==null)return true;

        ListNode midNode = midNode(head);
        ListNode leftList =  reverse(head,midNode);
        ListNode rightList = midNode;
        return isSameList(leftList,rightList) || isSameList(leftList,rightList.next);
    }

    public ListNode midNode(ListNode head){
        ListNode slow=head;
        ListNode fast = head;
        while (true){
            if (fast==null || fast.next==null )return slow;
            fast=fast.next.next;
            slow=slow.next;
        }
    }

    public ListNode reverse(ListNode left,ListNode right){
        ListNode temp = left;
        ListNode now = left;
        ListNode before = null;
        while (now!=right){
            temp= now.next;
            now.next=before;
            before= now;
            now=temp;
        }
        return before;
    }

    public boolean isSameList(ListNode l1,ListNode l2){
        while (true){
            if (l1==null&&l2==null)return true;
            if (l1==null||l2==null)return false;
            if (l1.val!=l2.val)return false;
            l1=l1.next;
            l2=l2.next;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
