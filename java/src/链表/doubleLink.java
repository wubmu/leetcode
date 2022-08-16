package 链表;

import java.util.LinkedList;
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