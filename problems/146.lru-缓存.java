import java.util.HashMap;
import java.util.Map;

import jdk.nashorn.internal.ir.ReturnNode;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class Node{
    int key, val;
    public Node pre, next;
    public Node(int key, int val){this.key=key;this.val=val;}
}
class DoubleList{
    private Node head , tail; // 头节点，尾节点
    private int size; // 链表大小
    public DoubleList(){
        head  = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre  = head;
        size = 0;
    }

    public void addLast(Node x){
        x.pre = tail.pre;
        x.next = tail;

        tail.pre.next = x;
        tail.pre = x;
        size++;
    }

    public void remove(Node x){
        x.pre.next = x.next;
        x.next.pre = x.pre;
        size--;

    }
    public Node removeFirst(){
        if (head.next == tail){return null;}
        Node first = head.next;
        remove(first);
        return first;
    }
    public int getSize(){
        return this.size;
    }
}
class LRUCache {
    private int capacity;
    private HashMap<Integer,Node> hashMap;
    private DoubleList linklist;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<>();
        linklist = new DoubleList();
    }
    
    public void removeLRU(){
        Node re = linklist.removeFirst(); // 队头删除
        hashMap.remove(re.key); // map 删除
        // capacity--;
    }

    public void addRecent(int key, int val){
        Node x = new Node(key, val);
        linklist.addLast(x);
        hashMap.put(key, x);
        
    }

    public void makeRec(int key){
        Node x = hashMap.get(key);
        linklist.remove(x);
        linklist.addLast(x);
    }

    public int get(int key) {
        if(!hashMap.containsKey(key)) return -1;
        else{
            makeRec(key);
            return hashMap.get(key).val;
        }
    }
    
    public void put(int key, int value) {
        // 存在修改
        if(hashMap.containsKey(key)){
        
            Node node = hashMap.get(key);
            node.val = value;
            makeRec(key);    
            return;
        }

        // 不存在
        if(capacity == linklist.getSize()){
            removeLRU();
            addRecent(key, value);
        }else{
            addRecent(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

