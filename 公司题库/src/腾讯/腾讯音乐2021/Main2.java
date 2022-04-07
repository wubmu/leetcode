package 腾讯.腾讯音乐2021;

import java.io.BufferedReader;

import java.io.*;
import java.util.*;
class Node{
    List<Node> child = new ArrayList<>();


    public void addChild(Node child){
        this.child.add(child);
    }
}
public class Main2 {
    public static void main(String[] args) throws IOException{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] tree = new Node[n + 1];
        for(int i = 2 ; i<= n ; i++ ){
            int parent = sc.nextInt();
            tree[parent].addChild(tree[i]);
        }



    }
}