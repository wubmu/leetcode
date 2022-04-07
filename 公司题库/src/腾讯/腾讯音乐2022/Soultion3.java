package 腾讯.腾讯音乐2022;

import java.util.ArrayList;
import java.util.List;

public class Soultion3 {
    public static int res = 0;
//    int numsofString(int n, int k){
//
//    }
    public static boolean jugle(List<Character> path, int k){
        int cnt = 0;
        //判断是否合法
        for (int i = 0 ; i < path.size() -1 ; i ++){
            if (path.get(i) == path.get(i+1)){
                cnt++;
                while (path.get(i) == path.get(i+1) && i<path.size()-1){
                    i++;
                }
            }else
                return false;
        }

        return cnt==k;
    }
    public static void dfs( List<Character> path, int n , int k){
        if (path.size() == n){
            if (jugle(path,k))
                res++;
            return;
        }

        for (char ch = 'a'; ch <= 'z'; ch++){
            path.add(ch);

            //
            dfs(path, n,k);
            path.remove(path.size() -1);
        }

    }

    public static void main(String[] args) {
        List<Character> path = new ArrayList<>();
        dfs(path,2,2);
        System.out.println(res);
    }
}
