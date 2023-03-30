//给定一个二维矩阵 matrix，以下类型的多个请求： 
//
// 
// 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。 
// 
//
// 实现 NumMatrix 类： 
//
// 
// NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化 
// int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下
//角 (row2, col2) 所描述的子矩阵的元素 总和 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: 
//["NumMatrix","sumRegion","sumRegion","sumRegion"]
//[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,
//1,2,2],[1,2,2,4]]
//输出: 
//[null, 8, 11, 12]
//
//解释:
//NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,
//0,1,7],[1,0,3,0,5]]);
//numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
//numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
//numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200
// 
// -10⁵ <= matrix[i][j] <= 10⁵ 
// 0 <= row1 <= row2 < m 
// 0 <= col1 <= col2 < n 
// 
// 最多调用 10⁴ 次 sumRegion 方法 
// 
//
// Related Topics 设计 数组 矩阵 前缀和 👍 480 👎 0

  
package com.shuzijun.leetcode.editor.en;
public class RangeSumQuery2dImmutable{
    public static void main(String[] args) {
//        Solution solution = new RangeSumQuery2dImmutable().new Solution();
        int[][] in = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7,},{1,0,3,0,5}};
        int[][] in2 = {{-4,-5}};
        NumMatrix numMatrix = new NumMatrix(in2);
        //System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        //numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
        //numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
        //numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)

    }

}
    
//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {
        int[][] preMatrix;

    public NumMatrix(int[][] matrix) {
        preMatrix = new int[matrix.length][matrix[0].length];
        int[] rowSum=new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i==0){
                    rowSum[j]=matrix[i][j];
                    if (j==0){
                        preMatrix[i][j]=rowSum[j];
                    }else{
                        preMatrix[i][j]=preMatrix[i][j-1]+matrix[i][j];
                    }
                }else {
                    rowSum[j]+=matrix[i][j];
                    if (j==0){
                        preMatrix[i][j]=rowSum[j];
                    }else{
                        preMatrix[i][j]=preMatrix[i][j-1]+rowSum[j];
                    }
                }
            }
        }

//        for (int i = 0; i < preMatrix.length; i++) {
//            for (int j = 0; j < preMatrix[i].length; j++) {
//                System.out.print(preMatrix[i][j]+"  ");
//            }
//            System.out.println();
//        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1==0&&col1==0){
            return preMatrix[row2][col2];
        }
        if (row1==0){
            return preMatrix[row2][col2]-preMatrix[row2][col1-1];
        }
        if (col1==0){
            return preMatrix[row2][col2]-preMatrix[row1-1][col2];
        }
        return preMatrix[row2][col2]+preMatrix[row1-1][col1-1]-preMatrix[row1-1][col2]-preMatrix[row2][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

