package ACM输入输出;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strNM = br.readLine().trim().split(" ");
        int n = Integer.parseInt(strNM[0]);
        int m = Integer.parseInt(strNM[1]);
        Node[] goods = new Node[n];
        for(int i = 0; i < n; i++){
            String[] params = br.readLine().trim().split(" ");
            int v = Integer.parseInt(params[0]);
            int w = Integer.parseInt(params[1]);
            goods[i] = new Node(i + 1, v, w);
        }
        Arrays.sort(goods, new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                if(node1.income > node2.income){
                    return -1;
                }else if(node1.income < node2.income){
                    return 1;
                }else{
                    return node1.id - node2.id;
                }
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < m; i++)
            pq.offer(goods[i].id);
        for(int i = 0; i < m; i++)
            System.out.print(pq.poll() + " ");
    }
}

class Node {
    public int income;
    public int id;
    public Node(int id, int v, int w) {
        income = v + 2*w;
        this.id = id;
    }
}