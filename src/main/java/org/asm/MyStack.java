package org.asm;

import java.util.LinkedList;

public class MyStack<T> {

    LinkedList<T> list;

    MyStack() {
        list = new LinkedList<>();
    }

    boolean isEmpty() {
        return list.isEmpty();
    }

    void push(T obj) {
        list.push(obj);
    }

    // remove first element
    T pop() {
        if (!list.isEmpty()) {
            return list.pop();
        }
        return null;
    }
}
