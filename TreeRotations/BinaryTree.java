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
    
    // Node class representing a single node in the binary tree
    static class Node {
        char data;
        Node left;
        Node right;

        // Constructor
        Node(char d) {
            data = d;
            left = null;
            right = null;
        }
    }
    
    // Method to visit a node (for printing purposes)
    public static void visit(Node node) {
        System.out.print(node.data + " ");
    }
   
    // Pre-order traversal (Root, Left, Right)
    public static void preOrder(Node node) {
        if (node != null) {            
            visit(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
   
    // In-order traversal (Left, Root, Right)
    public static void inOrder(Node node) {
        if (node != null) {     
            inOrder(node.left);
            visit(node);
            inOrder(node.right);
        }
    }
   
    // Post-order traversal (Left, Right, Root)
    public static void postOrder(Node node){
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            visit(node);
        }
    }
   
    // Level-order traversal (Breadth-first)
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
   
    // Right rotation of a subtree
    public static Node rightRotate(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;
        return temp;
    }
   
    // Left rotation of a subtree
    public static Node leftRotate(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;
        return temp;
    }
   
    // Left-right rotation of a subtree
    public static Node leftRightRotate(Node root) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }
   
    // Right-left rotation of a subtree
    public static Node rightLeftRotate(Node root) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }

   public static void main(String[] args) {
      // Testing single right rotation
      System.out.println("Before right rotation:");
      Node rootR = new Node('A');
      rootR.left = new Node('B');
      rootR.right = new Node('Y');
      rootR.left.left = new Node('N');
      rootR.left.right = new Node('X');
      inOrder(rootR);
      System.out.println();

      rootR = rightRotate(rootR);
      System.out.println("After right rotation:");
      inOrder(rootR);
      System.out.println();
      
      // Testing single left rotation
      System.out.println("Before left rotation:");
      Node rootL = new Node('A');
      rootL.right = new Node('B');
      rootL.left = new Node('Y');
      rootL.right.right = new Node('N');
      rootL.right.left = new Node('X');
      inOrder(rootL);
      System.out.println();

      rootL = leftRotate(rootL);
      System.out.println("After left rotation:");
      inOrder(rootL);
      System.out.println();
      
      // Testing left-right rotation
      System.out.println("Before left-right rotation:");
      Node rootLR = new Node('A');
      rootLR.left = new Node('B');
      rootLR.right = new Node('Y');
      rootLR.left.right = new Node('N');
      rootLR.left.left = new Node('X');
      inOrder(rootLR);
      System.out.println();

      rootLR = leftRightRotate(rootLR);
      System.out.println("After left-right rotation:");
      inOrder(rootLR);
      System.out.println();
      
      // Testing right-left rotation
      System.out.println("Before right-left rotation:");
      Node rootRL = new Node('A');
      rootRL.right = new Node('B');
      rootRL.left = new Node('Y');
      rootRL.right.left = new Node('N');
      rootRL.right.right = new Node('X');
      inOrder(rootRL);
      System.out.println();

      rootRL = rightLeftRotate(rootRL);
      System.out.println("After right-left rotation:");
      inOrder(rootRL);
      System.out.println();
   }
}
