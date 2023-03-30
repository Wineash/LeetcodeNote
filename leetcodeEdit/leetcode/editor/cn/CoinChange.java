//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2334 👎 0

  
package com.shuzijun.leetcode.editor.en;

import java.util.Arrays;

public class CoinChange{
    public static void main(String[] args) {
        int[] list=new int[]{186,419,83,408};
        Solution solution = new CoinChange().new Solution();

        System.out.println(solution.coinChange(list,6249));
        System.out.println("count :"+solution.count);
    }

    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int count=0;
//    自顶向下  备忘录法
//    public int coinChange(int[] coins, int amount) {
//        int[] memo=new int[amount+1];
//        for (int i = 0; i < memo.length; i++)memo[i]=-2;
//        return onceCoinChange(coins,amount,memo);
//    }
//
//    public int onceCoinChange(int[] coins, int amount,int[] memo){
//        count++;
//        if(amount == 0)return 0;
//        if (amount <0)return -1;
//        if (memo[amount]!=-2)return memo[amount];
//
//        int res=Integer.MAX_VALUE;
//        for(int i=0;i<coins.length;i++){
//
//            int subRes = onceCoinChange(coins,amount-coins[i],memo);
//            if (subRes == -1)continue;
//            res=Math.min(res,subRes+1);
//        }
//
//        memo[amount]=(res == Integer.MAX_VALUE ?-1:res);
//        return memo[amount];
//    }

    //    自底向上  备忘录法
    public int coinChange(int[] coins, int amount) {

        int[] subAmount=new int[amount+1];
        Arrays.fill(subAmount,Integer.MAX_VALUE-1);
        subAmount[0]=0;
        for (int i = 1; i <= amount; i++) {
            for (int j=0; j<coins.length;j++){
                if (i-coins[j]<0)continue;
                subAmount[i]=Math.min(subAmount[i-coins[j]]+1,subAmount[i]);
            }
        }
        return subAmount[amount] == Integer.MAX_VALUE-1 ? -1 : subAmount[amount];
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}