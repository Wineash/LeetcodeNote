//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
// 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 回溯 👍 415 👎 0

  
package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueensIi{
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
    }

    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int res = 0;
    public int totalNQueens(int n) {
        boolean[] used=new boolean[n];
        LinkedList path= new LinkedList<>();
        recall(n,used,path);
        return res;
    }

    public void recall(int n, boolean[] used, LinkedList<Integer> path){
        if (path.size()==n){
            res++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]==false){
                if (stepOk(i,path)){
                    used[i]=true;
                    path.add(i);
                    recall(n,used,path);
                    path.removeLast();
                    used[i]=false;
                }else {
                    continue;
                }
            }else {
                continue;
            }
        }

    };

    public boolean stepOk(int i,LinkedList<Integer> path){
        int c=path.size()-1;
        int add=1;
        while (c>=0){
            if (path.get(c)==i+add ||path.get(c)==i-add){
                return false;
            }
            c--;
            add++;
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}