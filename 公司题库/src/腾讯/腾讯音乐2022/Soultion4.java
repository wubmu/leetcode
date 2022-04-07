package 腾讯.腾讯音乐2022;

public class Soultion4 {
    public int dfs(char pr, int num, int depth , int n, int k ,int account){

        //终止的条件
        if (depth == k){
            if (n-account >=2)
                return 1;
            else
                return 0;
        }

        int sum = 0 ;
        

    }
}
