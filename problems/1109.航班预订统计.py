#
# @lc app=leetcode.cn id=1109 lang=python
#
# [1109] 航班预订统计
#

# @lc code=start



class Solution(object):
    def corpFlightBookings(self, bookings, n):
        """
        :type bookings: List[List[int]]
        :type n: int
        :rtype: List[int]
        """
        nums = [0] * n
        for l ,r , v in bookings:
            nums[l-1] += v
            if r < n:
                nums[r] -=v
        
        for i in range(1,n):
            nums[i] += nums[i-1]
        
        return nums
        # 还原数据
# @lc code=end

