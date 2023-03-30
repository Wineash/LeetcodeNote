//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
//
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 614 👎 0

  
package com.shuzijun.leetcode.editor.en;
public class FibonacciNumber{
    public static void main(String[] args) {
        Solution solution = new FibonacciNumber().new Solution();
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
class Solution {
    //自顶向下的思路 没有优化
//    public int fib(int n) {
//        if (n==0)return 0;
//        if(n==1 || n==2)return 1;
//        return fib(n-1)+fib(n-2);
//    }

    //自顶向下的思路 备忘录优化
//    public int fib(int n) {
//        int[] memo=new int[n+1];
//        return subFib(n,memo);
//    }
//
//    public int subFib(int n,int[] memo)
//    {
//        if (n==0)return 0;
//        if(n==1 || n==2)return 1;
//        if (memo[n]!=0)return memo[n];
//        int res=subFib(n-1,memo)+subFib(n-2,memo);
//        memo[n]=res;
//        return res;
//    }

    //自底向上的思路
//    public int fib(int n) {
//        if (n==0)return 0;
//        if (n==1)return 1;
//        if (n==2)return 1;
//        int[] table=new int[n+1];
//        table[1]=1;
//        table[2]=1;
//        for (int i=3;i<=n;i++){
//            table[i]=table[i-1]+table[i-2];
//        }
//        return table[n];
//    }

    //自底向上的思路 继续缩小table尺寸
    public int fib(int n) {
        if (n==0)return 0;
        if (n==1)return 1;
        if (n==2)return 1;
        int n1=1;
        int n2=1;
        int res=0;
        for (int i=3;i<=n;i++){
            res=n1+n2;
            n1=n2;
            n2=res;
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}