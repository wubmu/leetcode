import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start
class MedianFinder {
    PriorityQueue<Integer> right;
    PriorityQueue<Integer> left;
    public MedianFinder() {
        left = new PriorityQueue<Integer>((a,b)->b-a);
        right = new PriorityQueue<>((a,b)->a-b);
    }
    
    public void addNum(int num) {
        int s1 = left.size(), s2 = right.size();
        if(s1==s2){
            if(right.isEmpty() || num < right.peek()){
                left.add(num);
            }else{
                // num 大于 right.peak
                left.add(right.poll());
                right.add(num);
            }
        }else{
            if(left.peek() <= num)
                right.add(num);
            else{
                right.add(left.poll());
                left.add(num);
            }
        }
       
    }
    
    public double findMedian() {
        int s1 = left.size(), s2 = right.size();
        if(s1==s2){
            return (left.peek()+right.peek()) / 2.0;
        }else{
            return left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

