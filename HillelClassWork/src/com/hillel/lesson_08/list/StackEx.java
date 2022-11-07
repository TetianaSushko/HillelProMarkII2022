package com.hillel.lesson_08.list;

import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(); // create

        stack.add("One"); //add
        stack.add("Two"); //add
        stack.add(0, "Three");   //add

        System.out.println(stack);

        // [ stack -> element]
        System.out.println(stack.peek()); // look
        System.out.println(stack);
        System.out.println(stack.pop());  // look + take
        System.out.println(stack);
//
        //  [element -> stack]
        stack.push("Four");
        stack.add("Five");
        System.out.println(stack);
        System.out.println(stack.peek());
    }
}
