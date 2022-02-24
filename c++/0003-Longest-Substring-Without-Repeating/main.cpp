/*

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

# ��������
s[start,end)

ʱ�临�Ӷ�: O(n^2)
�ռ临�Ӷȣ�O(1)
*/

class Solution {
public:
    int lengthOfLongestSubstring(string s) {

        int start(0), end(0), len(0), result(0);

        while(end < s.size()){

            char tmpChar = s[end];
            for (int index = start; index < end; index++){
                if(tmpChar == s[index]){
                    start = index+1;
                    len = end - start;
                    break;
                }
            }
            end++;
            len++; // a b c  3-1 +1

           result = max(result,len);
        }
    }
};
