/*
 * @lc app=leetcode.cn id=525 lang=cpp
 *
 * [525] 连续数组
 */

// @lc code=start
class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        unordered_map<int,int> hash {{0,-1}};
        int sum=0,ans=0;
        for (int i = 0; i < nums.size(); i++)
        {
            nums[i] == 0? sum++:sum--;
            if (hash.count(sum))
            {
                ans = max(ans, i-hash[sum]);
            }else
                hash[sum] = i;
            
        }

        return ans;
        
    }
};
// @lc code=end

