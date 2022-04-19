## 百度笔试算法

### 机器学习岗(4.19)
**容易等级**

题目描述

从一个字符串中按照次序找到E或e、A或a、S或s、Y或y这四个字母，每四个字母为一组 
构成easy,每找到一组ans+1。找出最多的字母组合。注意多于一个easy，每个easy都要
按照次序出现，也就是说下个easy中'e'必须在前一个easy的'y'之后出现

测试用例
```
输入：
abcdesAssayEaaaassYy

输出
2
```

代码：思路很简单
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] easy = {'e','a','s','y'};
        int ans = 0;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == easy[idx % 4] || s.charAt(i) == (easy[idx % 4]-32) ){
                if (idx % 4 ==3)
                    ans++;
                idx++;
            }
        }
        System.out.println(ans);
    }
}

```

部队集合
