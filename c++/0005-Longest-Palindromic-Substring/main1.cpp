/**
Given a string s, return the longest palindromic substring in s.

������ɢ��
ʱ�临�Ӷ�O(n^2)
�ռ临�Ӷ�O(1)
**/


#include <iostream>
#include <vector>
#include <cassert>

using namespace std;


class Solution {
public:
    string longestPalindrome(string s) {


        int len = s.length();
        if(len == 1 || len==0)
            return s;
        int start = 0,end =0;
        int mlen = 1;
        for(int i=0; i<len ; i++){
            int len_odd = centerSpread(s, i,i);
            int len_even = centerSpread(s, i,i+1);
            int len = max(len_odd, len_even);
            if(len > mlen){
                start = i - (len- 1)/2;
                end = i+ len/2;
                mlen = len;
            }

        }
        return s.substr(start, mlen);

    }


private:
    int centerSpread(string s , int left, int right){
        //������left, right Ϊ���ĵĻ��ĵĳ���
        while(left >= 0 && right< s.length() && s[left]== s[right]){
            left--;
            right++;
        }
        return right - left - 1;



    }

};


int main() {

    //cout << Solution().longestPalindrome("babad") << endl;
    //cout << Solution().longestPalindrome("cbbd") << endl;
    cout << Solution().longestPalindrome("a") << endl;
    
    return 0;
}
