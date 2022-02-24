
/**
1. ��ִ����������������ȿɱ䣬�����ֵ
2. ���ֽⷨ����������
**/

class Solution {
public:
    int lengthOfLongestSubstring(string s) {

        int start(0), end(0), len(0), result(0);
        unordered_map<char, int> hash;

        while(end < s.size()){
            char tmpChar = s[end];

            // �����Ƿ�֮ǰ���ֹ�
            if(hash.find(tmpChar) != hash.end() && hash[tmpChar] >= start){
                //���[start,end)�г��ֹ�s[end] , start �ƶ����������ֵ���һλ
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
