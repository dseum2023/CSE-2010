/*
 * Author:  Daniella Seum, dseum2023@my.fit.edu
 * Course:  CSE 2010, Summer 2024
 * Project: Stacks and Queues
 */
import java.io.*;

public class StackQueue {

    // Stack class
    static class Stack extends LinkedList {
        public void push(int item) {
            add2head(item);
        }

        public int pop() {
            return deleteHead();
        }

        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return head.data;
        }

        public void printList() {
            System.out.print("Stack from top to bottom: ");
            super.printList();
        }
    }

    // Queue class
    static class Queue extends LinkedList {
        public void enqueue(int item) {
            add2tail(item);
        }

        public int dequeue() {
            return deleteHead();
        }

        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return head.data;
        }

        public void printList() {
            System.out.print("Queue from front to rear: ");
            super.printList();
        }
    }

    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.push(31);
        myStack.push(17);
        myStack.push(93);
        myStack.push(26);
        myStack.printList();
        System.out.println("Popped item: " + myStack.pop());
        myStack.printList();

        Queue myQueue = new Queue();
        myQueue.enqueue(31);
        myQueue.enqueue(17);
        myQueue.enqueue(93);
        myQueue.enqueue(26);
        myQueue.printList();
        System.out.println("Dequeued item: " + myQueue.dequeue());
        myQueue.printList();
        
        // Additional test case: Reverse a string using stack
        String inputString = "Hello";
        String reversedStringUsingStack = reverseStringUsingStack(inputString);
        System.out.println("Reversed string using stack: " + reversedStringUsingStack);

        // Additional test case: Reverse a string using queue
        String reversedStringUsingQueue = reverseStringUsingQueue(inputString);
        System.out.println("Reversed string using queue: " + reversedStringUsingQueue);
    }

    // Method to reverse a string using stack
    public static String reverseStringUsingStack(String str) {
        Stack stack = new Stack();
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append((char) stack.pop());
        }
        return reversed.toString();
    }

    // Method to reverse a string using queue
    public static String reverseStringUsingQueue(String str) {
        Queue queue = new Queue();
        for (char ch : str.toCharArray()) {
            queue.enqueue(ch);
        }
        StringBuilder reversed = new StringBuilder();
        while (!queue.isEmpty()) {
            reversed.insert(0, (char) queue.dequeue());
        }
        return reversed.toString();
    }
}
