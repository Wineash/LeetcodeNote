//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2458 👎 0

  
package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations{
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> res =new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path= new LinkedList<Integer>();
        boolean[] used=new boolean[nums.length];
        recall(nums,used,path);
        return res;
    }

    public void recall(int[] nums,boolean[] used,LinkedList<Integer> path){
        if( nums.length == path.size() ){
            res.add(new LinkedList(path));
            return;
        }
        for ( int i=0; i<nums.length; i++){
            if (used[i]==false){
                path.add(nums[i]);
                used[i]=true;
                recall(nums,used,path);
                path.removeLast();
                used[i]=false;
            }else {
                continue;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}