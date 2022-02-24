
/**
1. 最长字串，必须连续，长度可变，求最大值
2. 浮现解法：滑动窗口
**/

class Solution {
public:
    int lengthOfLongestSubstring(string s) {

        int start(0), end(0), len(0), result(0);
        unordered_map<char, int> hash;

        while(end < s.size()){
            char tmpChar = s[end];

            // 查找是否之前出现过
            if(hash.find(tmpChar) != hash.end() && hash[tmpChar] >= start){
                //如果[start,end)中出现过s[end] , start 移动到曾经出现的下一位
                start = hash[tmpChar] + 1;
                len = end - start;
            }
            hash[tmpChar] = end;

            end++;
            len++;

            result = max(result, len);
        }
        return result;
    }
};
