//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2338 👎 0

  
package com.shuzijun.leetcode.editor.en;

import java.util.PriorityQueue;

public class MergeKSortedLists{

    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        ListNode n3=new ListNode(5);
        ListNode n2=new ListNode(4,n3);
        ListNode n1=new ListNode(1,n2);
        ListNode p1=new ListNode(-1,n1);
        ListNode n6=new ListNode(4);
        ListNode n5=new ListNode(3,n6);
        ListNode n4=new ListNode(1,n5);
        ListNode p2=new ListNode(-1,n4);
        ListNode n8=new ListNode(6);
        ListNode n7=new ListNode(2,n8);
        ListNode p3=new ListNode(-1,n7);
        ListNode[] lists= {p1.next,p2.next,p3.next};
        ListNode res=solution.mergeKLists2(lists);
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

    //暴力想法
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
         ListNode minNode=lists[0];
         ListNode res=new ListNode(-1);
         ListNode resP=res;
         while (true){
             int listsIsOver=1;
             int isFirstFor=1;
             for(ListNode list:lists){
                 if (list!=null){
                     if (isFirstFor==1){
                         minNode=list;
                         isFirstFor=0;
                     }
                     listsIsOver=0;
                     if (list.val< minNode.val){
                         minNode=list;
                     }
                 }
             }

             if (listsIsOver==1){
                 break;
             }else {
                 for (int i=0;i<lists.length;i++){
                     if (lists[i]==minNode){
                         lists[i]=lists[i].next;
                     }
                 }
                 resP.next=minNode;
                 resP=resP.next;
                 resP.next=null;
                 minNode=null;
             }
         }
         return res.next;
    }
        //二叉堆(优先队列)排序
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length==0){
                return null;
            }
             ListNode minNode=lists[0];
             ListNode res=new ListNode(-1);
             ListNode resP=res;

            PriorityQueue<ListNode> pq=new PriorityQueue<>(
                    lists.length,(a,b)->(a.val-b.val)
            );
            for (ListNode list:lists){
                if (list!=null){
                    pq.add(list);
                }
            }
            while (pq.isEmpty()!=true){
                ListNode temp=pq.poll();
                resP.next=temp;
                resP=resP.next;
                if(temp.next!=null){
                    pq.add(temp.next);
                }
            }

             return res.next;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}