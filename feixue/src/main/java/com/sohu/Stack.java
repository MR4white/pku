package com.sohu;

public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    public void push(Object e) {
        elements[size++] = e;
    }
    public Object pop() throws Exception {
        if(size == 0) {
            throw new Exception();
        }
        return elements[--size];
    }

    public int get() {
        return size;
    }

    public static void main(String[] arg) throws Exception {
        Stack stack = new Stack();
        stack.push(123);
        System.out.println(stack.get());
        stack.pop();
        System.out.println(stack.get());
    }
}
