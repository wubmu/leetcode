package problem_2022.得物;

import java.util.ArrayList;
import java.util.List;

public class Solution {
     class Obj {
         List list = new ArrayList();

         void Insert(String[] words) {
             for (String word : words) {
                 if (list.contains(word))
                     continue;
                 list.add(word);
             }
         }

         boolean[] Search(String[] w) {
             boolean[] b = new boolean[w.length];
             for (int i = 0; i < w.length; i++) {
                 b[i] = list.contains(w[i]);
             }

             return b;
         }
     }
    public boolean[] check(String[] words, String[] w){
        Obj obj = bulid();
        obj.Insert(words);
        return obj.Search(w);
    }

    public Obj bulid(){
        return new Obj();
    }

    public static void main(String[] args) {
        String[] words= {"search","app","start","word"};
        String[] w = {"key","word"};
        Solution solution = new Solution();
        boolean[] b = solution.check(words,w);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
