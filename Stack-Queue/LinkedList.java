/*
 * Author:  Daniella Seum, dseum2023@my.fit.edu
 * Course:  CSE 2010, Summer 2024
 * Project: Linked List
 */
import java.io.*;

public class LinkedList {

    Node head; // head of list
    Node tail; // tail of list

    // Linked list Node.
    static class Node {
        int data;
        Node next;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Method to insert a new node at the head
    public void add2head(int data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
        if (tail == null) { // if the list was empty, set tail to new node
            tail = new_node;
        }
    }

    // Method to insert a new node at the tail
    public void add2tail(int data) {
        Node new_node = new Node(data);
        if (tail != null) {
            tail.next = new_node;
        }
        tail = new_node;
        if (head == null) { // if the list was empty, set head to new node
            head = new_node;
        }
    }

    // Method to delete the head node
    public int deleteHead() {
        if (head != null) {
            int data = head.data;
            head = head.next;
            if (head == null) { // if the list is now empty, reset tail
                tail = null;
            }
            return data;
        }
        throw new IllegalStateException("List is empty");
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Prints the entire list starting from the head
    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println(); // Add newline for clarity
    }

    // Method to find the position of a node containing a given value
    public int findNode(int data) {
        Node currNode = head;
        int position = 0;
        while (currNode != null) {
            if (currNode.data == data) {
                return position;
            }
            currNode = currNode.next;
            position++;
        }
        return -1; // return -1 if the node is not found
    }

    // Method to insert a node after a node containing a given value
    public void insertAfter(int after, int data) {
        Node currNode = head;
        while (currNode != null && currNode.data != after) {
            currNode = currNode.next;
        }
        if (currNode != null) {
            Node new_node = new Node(data);
            new_node.next = currNode.next;
            currNode.next = new_node;
            if (new_node.next == null) { // if new node is the last node, update tail
                tail = new_node;
            }
        }
    }

    // Method to delete a node after a node containing a given value
    public void deleteAfter(int after) {
        Node currNode = head;
        while (currNode != null && currNode.data != after) {
            currNode = currNode.next;
        }
        if (currNode != null && currNode.next != null) {
            currNode.next = currNode.next.next;
            if (currNode.next == null) { // if we deleted the last node, update tail
                tail = currNode;
            }
        }
    }

    // Method to merge two lists
    public static LinkedList mergeLists(LinkedList list1, LinkedList list2) {
        LinkedList mergedList = new LinkedList();
        Node curr1 = list1.head;
        Node curr2 = list2.head;

        while (curr1 != null || curr2 != null) {
            if (curr1 != null) {
                mergedList.add2tail(curr1.data);
                curr1 = curr1.next;
            }
            if (curr2 != null) {
                mergedList.add2tail(curr2.data);
                curr2 = curr2.next;
            }
        }
        return mergedList;
    }

    // method to create a Singly linked list with n nodes
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insert the values
        list.add2tail(1);
        list.add2tail(2);
        list.add2tail(3);
        list.add2tail(4);
        list.add2tail(5);
        list.add2tail(6);
        list.add2tail(7);
        list.add2tail(8);

        // Print the LinkedList
        list.printList();

        // Add node to head
        list.add2head(0);
        list.printList();

        // Add node to tail
        list.add2tail(9);
        list.printList();

        // Find node containing value 5
        int foundPosition = list.findNode(5);
        System.out.println(foundPosition != -1 ? "Node with value 5 found at position " + foundPosition : "Node with value 5 not found");

        // Insert node after node containing value 3
        list.insertAfter(3, 10);
        list.printList();

        // Delete node after node containing value 3
        list.deleteAfter(3);
        list.printList();

        // Delete head node
        list.deleteHead();
        list.printList();

        // Merge two lists
        LinkedList list2 = new LinkedList();
        list2.add2tail(11);
        list2.add2tail(12);
        list2.add2tail(13);

        LinkedList mergedList = mergeLists(list, list2);
        mergedList.printList();
    }
}
