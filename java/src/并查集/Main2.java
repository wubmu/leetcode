package 并查集;

public class Main2 {
    int[] fa= new int[1001];
    
    void init(){
        for (int i = 1; i <= 1001 ; i++) {
            fa[i] = i;
        }
    }
    void union(int a, int b){
        fa[find(a)] = find(b);
    }
    int find(int x){
        if (x == fa[x])
            return x;
        else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }
}
