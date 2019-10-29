package com.github.wangpeng1994.datastructure.queue;

import java.util.Scanner;

public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头部前一个位置
        rear = -1; // 指向对列尾
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public boolean add(int e) {
        if (isFull()) {
            throw new RuntimeException("队列已满，添加失败");
        }
        arr[++rear] = e; // rear后移，并从尾部添加数据
        return true;
    }

    // 获取队列数据，出队列
    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[++front]; // front后移，并从头部取出数据
    }

    // 显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示队列头部数据，但不取出
    public int element() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front + 1];
    }
}


class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; // 从接受用户输入
        Scanner scanner = new Scanner(System.in); // 扫描标准输入
        boolean loop = true;
        // 创建菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("q(quit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("r(remove): 从队列取出数据");
            System.out.println("e(element): 查看队列头部数据");
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
            }

        }
    }
}