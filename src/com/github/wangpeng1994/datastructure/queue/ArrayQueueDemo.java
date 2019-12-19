package com.github.wangpeng1994.datastructure.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        // ArrayQueue queue = new ArrayQueue(3);
        // 测试数组模拟环形队列
        CircleArrayQueue queue = new CircleArrayQueue(4);
        char key = ' '; // 接受用户输入
        Scanner scanner = new Scanner(System.in); // 扫描标准输入
        boolean loop = true;
        // 创建菜单
        while (loop) {
            System.out.println("\ns(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头部数据\n");
            key = scanner.next().charAt(0); // 等待输入一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt(); // 等待输入一个数字
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }

        System.out.println("程序退出");
    }
}
