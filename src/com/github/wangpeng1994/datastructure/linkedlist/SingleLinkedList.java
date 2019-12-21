package com.github.wangpeng1994.datastructure.linkedlist;

// 定义 SingleLinkedList  管理水浒英雄
public class SingleLinkedList {
    // 先初始化一个头结点，保持不动，不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    // 添加节点到单向链表
    // 方式一
    // 固定添加到链接末尾，需要找到链表最后节点，将该节点 next 指向新的节点
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) { // 找到最后的节点就退出循环
                break;
            }
            temp = temp.next; // 没找到，则temp 指针继续移向下一个节点
        }
        temp.next = heroNode; // 令当前最后节点的 next 指向新添加的节点
    }

    // 添加节点到单向链表
    // 方式二
    // 根据排名插入到指定位置
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) { // 位置找到，挨着 temp 后面添加
                break;
            } else if (temp.next.no == heroNode.no) { // 将要被添加的 heroNode 编号已经存在
                flag = true;
                break;
            }
            temp = temp.next; // 继续后移指针，遍历链表
        }
        if (flag) {
            System.out.printf("准备插入的英雄已存在，其编号为 %d ，插入失败\n", heroNode.no);
        } else {
            // 插入到链表中 temp 的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 显示链表（遍历）
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next; // temp 后移以便继续遍历
        }
    }

}

// 定义 HeroNode，每个 HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; // 指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }


}

