//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1285 👎 0

  
package com.shuzijun.leetcode.editor.en;

import java.util.*;

public class CombinationSumIi{
    public static void main(String[] args) {
        int[] in = {10,1,2,7,6,1,5};
        Solution solution = new CombinationSumIi().new Solution();
        solution.combinationSum2(in,8);
    }

    
    
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new LinkedList<>();
        private LinkedList<Integer> path = new LinkedList<>();
        int sum=0;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            recall(candidates,target,0);
            return res;
        }

        public void recall(int[] nums,int target,int start){
            if (sum == target){
                res.add(new LinkedList<>(path));
                return;
            }
            if (sum > target){
                return;
            }

            for (int i=start;i<nums.length;i++){

                //剪枝
                if(i>start && nums[i]==nums[i-1])continue;
                if(sum>target)break;

                sum+=nums[i];
                path.add(nums[i]);
                recall(nums,target,i+1);
                path.removeLast();
                sum-=nums[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}