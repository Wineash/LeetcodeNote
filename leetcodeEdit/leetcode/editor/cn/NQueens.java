//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
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
// Related Topics 数组 回溯 👍 1675 👎 0

  
package com.shuzijun.leetcode.editor.en;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens{
    public static void main(String[] args) {

        Solution solution = new NQueens().new Solution();
        solution.solveNQueens(1);

    }

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<String>> res = new ArrayList<>();
        private List<LinkedList<Integer>> resNum=new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            boolean[] used=new boolean[n];
            LinkedList path= new LinkedList<>();
            recall(n,used,path);
//            printNums(resNum);
            numsToString(resNum);

            return res;
        }

        public void recall(int n, boolean[] used, LinkedList<Integer> path){
            if (path.size()==n){
                resNum.add(new LinkedList(path));
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

        public void printNums(List<LinkedList<Integer>> lists){
            for (LinkedList<Integer> list:lists){
                System.out.println(list);
            }
        }

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

        public void numsToString(List<LinkedList<Integer>> resNum){
            for (LinkedList<Integer> list:resNum){
                String aRes="";
                List<String> aResList=new ArrayList<String>();
                for (Integer num:list){
                    aRes="";
                    for (int i=0;i<list.size();i++){
                        if (i==num){
                            aRes+="Q";
                        }else {
                            aRes+=".";
                        }
                    }
                    aResList.add(aRes);
                }
                res.add(new ArrayList(aResList));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}