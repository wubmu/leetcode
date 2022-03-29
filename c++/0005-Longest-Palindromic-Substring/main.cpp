class Solution {
public:
    string longestPalindrome(string s) {
        int len = s.size();

        int start = 0; // 回文
        int maxlen = 1;// 最长回文长度
        if(len ==0 || len == 1)
            return s;
        vector<vector<int>> dp(len, vector<int>(len)); // 定义dp动态数组
        //初始化p[i][i], p[i][i+1]
        for(int i =0 ; i< len; i++){
            dp[i][i] = 1;
            if( i+1 < len && s[i] == s[i+1]){
                dp[i][i+1] = 1;
                maxlen = 2;
                start = i;
            }

        }

        for (l= 3; l <= len; l++){
                // 长度为3的子串
            for(i = 0; i+l <= len; i++){
                int j = i+l -1; // 结束的位置
                if(dp[i+1][j-1] == 1 && s[i]==s[j]){ // dp动态变化
                    dp[i][j]==1;
                    start = i;
                    maxlen = l;
                }

            }

        }

        return s.substr(start,maxlen)

    }
};
