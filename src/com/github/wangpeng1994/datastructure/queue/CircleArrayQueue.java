package com.github.wangpeng1994.datastructure.queue;

public class CircleArrayQueue {
    private int maxSize; // 表示数组最大容量，实际有效数据容量为 maxSize - 1，预留一个空位方便计算
    private int front; // front 指向队列的第一个元素，初始值为 0
    private int rear; // rear 指向队列最后一个元素的后一个位置，初始值为 0
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public boolean addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，添加失败");
            return false;
        }
        // 直接将数据加入
        arr[rear] = n;
        // 将 rear 后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
        return true;
    }

    // 获取队列数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        // 直接从 front 取出头部数据
        int value = arr[front];
        // 将 front 后移，
        front = (front + 1) % maxSize;
        return value;
    }

    // 显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        // 思路：从 front 开始遍历有效的元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 求出当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列头部数据，但不取出
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }

}
