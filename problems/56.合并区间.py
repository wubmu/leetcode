#
# @lc app=leetcode.cn id=56 lang=python3
#
# [56] 合并区间
#

# @lc code=start
from cProfile import label


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key = lambda x:x[0])
        result = []
        for i in range(len(intervals)):
            if not result or result[-1][-1] < intervals[i][0]:#只有结果数组为空或者没有交集的情况才直接加入
                result.append(intervals[i])
            else:
                result[-1] = [result[-1][0],max(intervals[i][-1],result[-1][-1])]#取两个数组中较大的数作为上界
        return result

# @lc code=end

