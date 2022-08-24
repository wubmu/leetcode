package 单调队列栈;

import java.util.LinkedList;

public class MonotonicQueue {
    // 双链表，支持头部和尾部增删元素
// 维护其中的元素自尾部到头部单调递增
    private LinkedList<Integer> maxq = new LinkedList<>();

    // 在队尾添加元素 n
    void push(int n){
        if (n == maxq.getFirst()) {
            maxq.pollFirst();
        }
    }
    // 返回当前队列中的最大值
    int max(){
        // 队头的元素肯定是最大的
        return maxq.getFirst();
    }
    // 队头元素如果是 n，删除它
    void pop(int n){
        // 将前面小于自己的元素都删除
        while (!maxq.isEmpty() && maxq.getLast() < n) {
            maxq.pollLast();
        }
        maxq.addLast(n);
    }

    int min(){
        return maxq.getLast();
    }

    int size(){
        return maxq.size();
    }
}
