package org.asm;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyQueue {
    LinkedList<Object> list = new LinkedList<>();

    public void enqueue(Object obj) {
        list.addLast(obj);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return list.removeFirst();
    }

    public Object front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return list.getFirst();
    }
}
