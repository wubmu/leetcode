/*
 * @lc app=leetcode.cn id=187 lang=cpp
 *
 * [187] 重复的DNA序列
 */

// @lc code=start

class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        vector<string> ans;
        unordered_map<string,int> cnt;
    
        int L = 10;
        int n = s.length();
        for(int i=0; i <=n-10; i++){
            string sub = s.substr(i,L);
            if (++cnt[sub] == 2)
            {
                ans.push_back(sub);
            }
            
        }
        return ans;
    }
};
// @lc code=end

