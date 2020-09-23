package com.github.wangpeng1994.algs4.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public int size() { return N; }

    public boolean isEmpty() { return N == 0; }

    public void push(String item) { a[N++] = item; }

    public String pop() { return a[--N]; }

    /**
     *  javac -cp /Library/Java/myStudyJavaLibs/algs4.jar com/github/wangpeng1994/algs4/stack/FixedCapacityStackOfStrings.java
     *  java -cp /Library/Java/myStudyJavaLibs/algs4.jar:. com.github.wangpeng1994.algs4.stack.FixedCapacityStackOfStrings < com/github/wangpeng1994/algs4/stack/tobe.txt
     *
     * @param args
     */
    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");

        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
