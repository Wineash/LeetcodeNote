//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 1967 👎 0

  
package com.shuzijun.leetcode.editor.en;
public class ReverseNodesInKGroup{

    public static void main(String[] args) {
        ListNode n4=new ListNode(4);
        ListNode n3=new ListNode(3,n4);
        ListNode n2=new ListNode(2,n3);
        ListNode n1=new ListNode(1);
        ListNode p=new ListNode(0,n1);

        Solution solution = new ReverseNodesInKGroup().new Solution();
        p=solution.reverseKGroup(p,2);

        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
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


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head ==null || head.next==null)return head;

        ListNode left = head;
        ListNode right = head;

        //获取一定步数后的right节点，该节点可以为null，因为闭区间
        int step=k;
        while (step-->0){
            if (right.next!=null){
                right=right.next;
            }else{
                if(step!=0){
                    return head;
                }else {
                    right=null;
                }
            }
        }

        //获取反转后的头节点
        ListNode res=reverse(left,right);
        //因为子链表被反转过了，因此尾指针时left而不是right，将置空的尾指针指向邻子列表的头节点（拼接）
        left.next=reverseKGroup(right,k);
        return res;
    }

    //将区间[a,b)中的数反转，返回反转的头节点，且尾节点的next置空
    public ListNode reverse(ListNode a,ListNode b){
        if (a==null || a.next==null)return a;

        ListNode pre=null;
        ListNode now=a;
        ListNode temp=null;
        while (now!=b){
            temp=now.next;
            now.next=pre;
            pre=now;
            now=temp;
        }
        a.next=null;
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}