//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6218 👎 0

  
package com.shuzijun.leetcode.editor.en;
public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        String s="abaaba";
        System.out.println(solution.Palindrome(s,2,3));
    }
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String Palindrome(String s, int l, int r) {
            while (l >= 0 && r <= s.length() - 1) {
                if (s.charAt(l) != s.charAt(r)) break;
                l--;
                r++;
            }
            return s.substring(l + 1, r);
        }

        public String longestPalindrome(String s) {
            String res = null;
            for (int i = 0; i < s.length(); i++) {
                String str1 = Palindrome(s, i, i);
                String str2 = Palindrome(s, i, i + 1);
                if (res == null) res = str1;
                res = res.length() < str1.length() ? str1 : res;
                res = res.length() < str2.length() ? str2 : res;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}