### 子集 元素不重复 可复选问题
1. 是一个元素可以复选的组合问题。但又要保证由(2,3)生成[2,2,3]而不生成[2，3，2]。即保证选择列表同一个元素可复选又保证访问元素相对顺序不能逆序，在组合问题39的基础上将传入的start不用加1。
2. 这样即保证了同元素可重复访问也不生成因逆序元素生成相同子集。
3. sum作为节点状态，回溯时也要回归之前的状态，而不是在递归开头变成0