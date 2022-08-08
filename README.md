##

| 题号                                                        | 题解                                                         | 标签                                        | 难度 | 备注 |
| ----------------------------------------------------------- | ------------------------------------------------------------ | ------------------------------------------- | ---- | ---- |
|                                                             |                                                              |                                             |      |      |
| [0141](https://leetcode-cn.com/problems/linked-list-cycle/) | 环形链表                                                     | `哈希表` ， `双指针` ， `链表` , `快慢指针` | easy |      |
|                                                             |                                                              |                                             |      |      |
|                                                             |                                                              |                                             |      |      |
|                                                             |                                                              |                                             |      |      |
| 0124                                                        | 二叉树中的最长路径                                           | `递归`                                      |      |      |
| 0139                                                        | 单词拆分                                                     | `动态规划`，`完全背包`                      |      |      |
| 0152                                                        | 乘积最大子数组                                               | `动态规划`                                  |      | :+1: |
| 0198                                                        | 打家劫舍                                                     | `动态规划`                                  |      |      |
|                                                             |                                                              |                                             |      |      |
|                                                             |                                                              |                                             |      |      |
|                                                             |                                                              |                                             |      |      |
| 0416                                                        | 分割等和子集                                                 | `动态规划`，`0-1背包`                       |      |      |
|                                                             |                                                              |                                             |      |      |
|                                                             |                                                              |                                             |      |      |
| 0714                                                        | [买卖股票的最佳时机含手续费](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/) | `动态规划`，`贪心`                          |      |      |
| 0918                                                        | 环形子数组的最大和                                           | 环形动态规划                                |      | :+1: |

## 贪心

- 0714 卖股票的最佳时机含手续费用 ：[贪心题解](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/ti-hao-122mei-you-shou-xu-fei-jia-yi-dian-dong-xi-/)

## 双指针

- 0141 环形链表：`哈希表` ， `双指针` ， `链表` , `快慢指针`

### 动态规划

- 124 二叉树中的最长路径

- 139 单词拆分：可用完全背包求解
- **152 乘积最大子数组**：双动态规划
- 198 打家劫舍
- 0714 卖股票的最佳时机含手续费用

分割问题

- 279 完全平方数
- 91 解码方法
- 139 单词拆分
- 416分割等和子集

子序列问题

- 300 最长递增子序列



「完全背包问题」`内层循环正序`，而「0-1 背包问题」中`内层循环反序`，从原始的状态转移方程来看，在这一点上两者的区别也是显而易见的。

![image-20220421211444787](https://gitee.com/wubmu/image/raw/master/img/image-20220421211444787.png)



背完问题

0-1背包

- 416 [分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum/description/)：是否能组成总容量的一半
- [474. 一和零](https://leetcode-cn.com/problems/ones-and-zeroes/)：（多背包问题）
- [494. 目标和](https://leetcode-cn.com/problems/target-sum/)
- [1049. 最后一块石头的重量 II](https://leetcode-cn.com/problems/last-stone-weight-ii/)

完全背包问题

[背包技巧](https://leetcode-cn.com/problems/combination-sum-iv/solution/xi-wang-yong-yi-chong-gui-lu-gao-ding-bei-bao-wen-/)



- 322 零钱兑换
- 518 零钱兑换2

>
>
>在下面的代码中，我们先遍历硬币，后遍历背包，求得的是「组合数目」，即硬币选出的顺序不重要。例如，要从 coins = [1, 2, 5]coins=[1,2,5] 中凑出 5， \[1, 2, 2] 和 \[2,1,2] 被认为是同一种方案。
>而如果要求的是「排列数目」，即不同的硬币选出顺序被认为是不同的方案数，如 \[1, 2, 2] 和 \[2,1,2] 被认为是两种不同的方案，那么此时对遍历顺序稍加修改：内外循环颠倒一下即可，即「先遍历背包，再遍历硬币」。可用于解决 「377. 组合总和 Ⅳ」 和 「139. 单词拆分」。

组合问题

- 377 组合总结iv
- 494 目标和
- 518 零钱兑换2
