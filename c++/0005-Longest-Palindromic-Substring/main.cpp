class Solution {
public:
    string longestPalindrome(string s) {
        int len = s.size();

        int start = 0; // ����
        int maxlen = 1;// ����ĳ���
        if(len ==0 || len == 1)
            return s;
        vector<vector<int>> dp(len, vector<int>(len)); // ����dp��̬����
        //��ʼ��p[i][i], p[i][i+1]
        for(int i =0 ; i< len; i++){
            dp[i][i] = 1;
            if( i+1 < len && s[i] == s[i+1]){
                dp[i][i+1] = 1;
                maxlen = 2;
                start = i;
            }

        }

        for (l= 3; l <= len; l++){
                // ����Ϊ3���Ӵ�
            for(i = 0; i+l <= len; i++){
                int j = i+l -1; // ������λ��
                if(dp[i+1][j-1] == 1 && s[i]==s[j]){ // dp��̬�仯
                    dp[i][j]==1;
                    start = i;
                    maxlen = l;
                }

            }

        }

        return s.substr(start,maxlen)

    }
};
