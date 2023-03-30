//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2231 👎 0

  
package com.shuzijun.leetcode.editor.en;
public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] in={5,7,7,8,8,10};
        int target=6;
        int[] res = solution.searchRange(in,target);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }

    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int start = -1;
        int end =-1;
    public int[] searchRange(int[] nums, int target) {
        if (nums.length!=0){
            trackLeft(nums,0,nums.length-1,target);
            trackLRight(nums,0,nums.length-1,target);
        }
        int[] res = new int[2];
        res[0]=start;
        res[1]=end;
        return res;
    }

    public void trackLeft(int[] nums,int left,int right,int target){

        while (left<=right){
            int mid=left +(right-left)/2;
            if (nums[mid]==target){
                right=mid-1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }
        }

        if(right+1>=0 && right+1<nums.length && nums[right+1]==target)start=right+1;
    }
    public void trackLRight(int[] nums,int left,int right,int target){

        while (left<=right){
            int mid=left +(right-left)/2;
            if (nums[mid]==target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }
        }
        if(left-1>=0 && left-1<nums.length && nums[left-1]==target)end=left-1;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}