package org.asm;

import java.util.LinkedList;

public class MyStack<T> {

    LinkedList<T> list;

    MyStack() {
        list = null;
    }

    boolean isEmpty() {
        return list.isEmpty();
    }

    void push(T obj) {
        list.push(obj);
    }

    T pop() {
        if (!list.isEmpty()) {
            return list.pop();
        }
        return null;
    }
}
