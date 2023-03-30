//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1319 👎 0

  
package com.shuzijun.leetcode.editor.en;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        int[] nums={1,1,2};
        System.out.println(solution.permuteUnique(nums).toString());
        return;
    }



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] used=new int[nums.length];
        LinkedList<Integer> path = new LinkedList<>();
        recall(nums,used,path);
        return res;
    }

    public void recall(int[] nums, int[] used, LinkedList path){
        if (path.size()==nums.length){
            res.add(new LinkedList(path));
            return;
        }

        int leftNode=11;
        for (int i = 0; i < nums.length; i++) {
            if (used[i]==1 || nums[i]==leftNode)continue;
            used[i]=1;
            path.add(nums[i]);
            leftNode=nums[i];
            recall(nums,used,path);
            path.removeLast();
            used[i]=0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}