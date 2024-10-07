package com.study;
import java.util.*;
public class Test3 {
public static void main(String[] args) {
	Queue<String> queue = new LinkedList<>();
    
    
    queue.offer("A");
    queue.offer("B");
    queue.offer("C");
    System.out.println("Queue: " + queue);
    String head = queue.peek();
    System.out.println("Head of the queue: " + head);
    String removedLetter = queue.poll();
    System.out.println("Removed element: " + removedLetter);
    System.out.println("Queue after poll: " + queue);
    if (queue.isEmpty()) {
        System.out.println("The queue is empty.");
    } else {
        System.out.println("The queue is not empty.");
    }
}
}
