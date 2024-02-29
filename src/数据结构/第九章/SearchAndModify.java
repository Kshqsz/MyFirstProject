package 数据结构.第九章;

public class SearchAndModify {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        // 查找并修改或插入元素
        System.out.println("删除2:");
        list.searchAndModify(2); // 删除2
        list.printList();

        System.out.println("插入5:");
        list.searchAndModify(5); // 插入5
        list.printList();
    }
}
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class LinkedList {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // 顺序查找并删除或插入元素
    public void searchAndModify(int key) {
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            if (temp.data == key) {
                if (prev != null) {
                    prev.next = temp.next; // 删除元素
                } else {
                    head = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        }

        // 如果未找到，插入元素到链表结尾
        insert(key);
    }
    // 打印链表
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}