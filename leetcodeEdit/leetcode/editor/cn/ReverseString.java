//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。 
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = ["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 
//输入：s = ["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 都是 ASCII 码表中的可打印字符 
// 
//
// Related Topics 双指针 字符串 👍 732 👎 0

  
package com.shuzijun.leetcode.editor.en;
public class ReverseString{
    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
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
    public void reverseString(char[] s) {
        int slow=0;
        int fast=s.length-1;
        while (slow<fast){
            char temp=s[slow];
            s[slow]=s[fast];
            s[fast]=temp;
            slow++;
            fast--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}