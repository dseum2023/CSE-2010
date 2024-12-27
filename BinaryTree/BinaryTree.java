/*
 * Author:  Daniella Seum, dseum2023@my.fit.edu
 * Course:  CSE 2010, Summer 2024
 * Project: Binary Tree Traversal
 */
import java.util.LinkedList;

public class BinaryTree {

    // Queue class using LinkedList to store Node objects
    static class Queue {
        private LinkedList<Node> list = new LinkedList<>();

        public void enqueue(Node item) {
            list.addLast(item);
        }

        public Node dequeue() {
            return list.removeFirst();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }
    }
    
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor
        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }
    
    public static void visit(Node node) {
        System.out.print(node.data + " ");
    }
   
    public static void preOrder(Node node) {
        if (node != null) {            
            visit(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
   
    public static void inOrder(Node node) {
        if (node != null) {     
            inOrder(node.left);
            visit(node);
            inOrder(node.right);
        }
    }
   
    public static void postOrder(Node node){
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            visit(node);
        }
    }
   
    public static void levelOrder(Node root) {
        Queue q = new Queue();
        q.enqueue(root);
        while (!q.isEmpty()) {
            Node node = q.dequeue();
            visit(node);
            if (node.left != null) {
                q.enqueue(node.left);
            }
            if (node.right != null) {
                q.enqueue(node.right);
            }
        }
    }

   public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Pre-order traversal");
        preOrder(root);
        System.out.println();

        System.out.println("In-order traversal");
        inOrder(root);
        System.out.println();

        System.out.println("Post-order traversal");
        postOrder(root);
        System.out.println();

        System.out.println("Level-order traversal");
        levelOrder(root);
        System.out.println();
   }
}
