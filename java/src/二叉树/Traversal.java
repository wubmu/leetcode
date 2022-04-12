package 二叉树;

import java.util.Stack;

/**
 * 每个节点会访问三次
 * 如完全二叉树[1,2,3,4,5,6]
 * 递归序列：124442555213...
 * 先序：（头，左，右）：1，2，4，5，3，6，7
 * 中序：（左，中，右）：4，2，5，1，6，3，7
 * 后序：（左，右，中）：4，5，2，6，7，3，1
 * */

class Node{
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }
}
public class Traversal {

    public static void preOrderRecur(Node head){
        if (head == null)
            return;

        System.out.print(head.value+" ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head){
        if (head == null)
            return;

        inOrderRecur(head.left);
        System.out.print(head.value+" ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(Node head){
        if (head == null)
            return;

        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value+" ");
    }

    public static void preOrderUnRecur(Node head){
        /**
         * 1) 从栈中弹出一个节点cur
         * 2) 打印处理cur
         * 3) 先右再左（如果有）
         * 4)循环
         * */
        if (head != null){
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                //2)处理cur
                System.out.print(head.value+" ");
                //先压右再压左
                if (head.right != null)
                    stack.push(head.right);
                if (head.left != null)
                    stack.push(head.left);
            }
        }
    }

    public static void inOrderUnRecur(Node head){
        /**
         * 中
         * 左边界：头-》左
         * 弹出栈：左，头
         * 每课子树整棵树左边进栈
         * 每次弹出节点时，打印
         * 对弹出节点的右数周而复始
         *
         *
         * **/

        if (head != null){
            Stack<Node> s1 = new Stack<Node>();
            while (!s1.isEmpty() || head != null){
                if (head != null){
                    s1.push(head);
                    head = head.left;
                }else {
                    head = s1.pop();
                    System.out.printf(head.value + " ");
                    head = head.right;
                }
            }

            }
    }

    public static void posOrderUnRecur1(Node head){
        /**
         * 中序：中右左
         * 收集栈：左右中
         *
         * 1)弹出,cur
         * 2)放入收集栈
         * 3)先左再右
         * 4)循环
         *
         * **/

        if (head != null){
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();

            s1.push(head);
            while (!s1.isEmpty()){

                head = s1.pop();
                s2.push(head);
                if (head.left != null){
                    s1.push(head.left);
                }
                if (head.right != null)
                    s1.push(head.right);
            }

            while (!s2.isEmpty())
                System.out.printf(s2.pop().value + " ");
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);

        head.right.left = new Node(1);
        head.right.left.left = new Node(7);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        //recursive
        System.out.println("================recursive==================");
        System.out.println("前序遍历");
        preOrderRecur(head);
        System.out.println("\n中序遍历");
        inOrderRecur(head);
        System.out.println("\n后续遍历");
        posOrderRecur(head);

        System.out.println("\n================unrecursive================");
        System.out.println("前序遍历");
        preOrderUnRecur(head);
        System.out.println("\n中序遍历");
        inOrderUnRecur(head);
        System.out.println("\n后序遍历");
        posOrderUnRecur1(head);
    }



}
