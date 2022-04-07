/*
 * @lc app=leetcode.cn id=1 lang=cpp
 *
 * [1] 两数之和
 */

// @lc code=start
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> hash;
        
        for (int i = 0; i < nums.size(); i++)
        {
            /* code */
            int t = target - nums[i];
            if (hash.count(t))
            {
                return vector<int>({hash[t],i});
            }
            hash[nums[i]] = i;
            
        }
        return vector<int>();
        
    }
};
// @lc code=end

