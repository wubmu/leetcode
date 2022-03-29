// @before-stub-for-debug-begin
#include <vector>
#include <string>
#include "commoncppproblem11.h"

using namespace std;
// @before-stub-for-debug-end

/*
 * @lc app=leetcode.cn id=11 lang=cpp
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
public:
    int maxArea(vector<int>& height) {
        int area = 0, i=0, j= height.size()-1;
        while(i<j){
            int tmpArea = min(height[i],height[j]) * (j-i);
            area =  max(area,tmpArea);
            if(height[i]< height[j]){
                i++;
            }else{
                j--;
            }

        }

        return area;
    }
};
// @lc code=end

