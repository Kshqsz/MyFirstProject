package 数据结构.第二章;

public class Linked_list {
    public static void main(String[] args) {
        linklist ls = new linklist();
        for (int i = 0; i < 10; i++) {
            ls.insert(i, i);
        }
        System.out.print("执行删除前的数据:");
        ls.print();
        System.out.print("删除链表中大于0小于3的数据:");
        ls.erase(0,3);
        ls.print();
    }
}

class Node {
    public Object val;
    public Node next;
    public Node() {
        this(null, null);
    }
    public Node (Object val, Node next) {
        this.val = val;
        this.next = next;
    }
    public Node(Object val) {
        this(val, null);
    }
}

interface list {
    boolean empty();
    //void clear();
    int size();
    //Object get(int i);
    void insert(int idx, Object x);
    //void erase(int idx);
    //int find(Object x);
    void print();
    //void reverse();
}
class linklist implements list {
    public Node head;
    public linklist() {
        head = new Node();
    }
    public boolean empty() {
        return head.next == null;
    }
    public int size() {
        Node cur = head.next;
        int sz = 0;
        while (cur != null) {
            cur = cur.next;
            sz++;
        }
        return sz;
    }
    public void insert(int i, Object x) {
        Node cur = head;
        int j = -1;
        while (cur != null && j < i - 1) {
            cur = cur.next;
            j++;
        }
        if (j > i - 1 && cur != null) {
            System.out.print("插入位置不合法" + "\n");
            return;
        }
        Node s = new Node(x);
        s.next = cur.next;
        cur.next = s;
    }
//    public void insert(Object x) {
//        Node cur = head;
//        while (cur != null && (int)cur.val <= (int)x) {
//            cur = cur.next;
//        }
//        if (cur == null) {
//            cur = new Node(x);
//        } else {
//            Node s = new Node(x);
//            s = cur.next;
//            cur.next = s;
//        }
//    }
    public void print() {
        Node cur = head.next;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.print("\n");
    }
//    public void reverse(Node cur) {
//        Node pre = null;
//        while (cur != null) {
//            Node next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//    }
//    public void erase(int i) {
//        Node cur = head;
//        int j = -1;
//        while (cur.next != null && j + 1 < i) {
//            cur = cur.next;
//            j++;
//        }
//        if (j > i - 1 || cur.next == null) {
//            System.out.print("删除位置不合法" + "\n");
//        }
//        cur.next = cur.next.next;
//    }
    public void erase(int mink, int maxk) {
        Node cur = head.next;
        Node pre = head;
        while (cur != null) {
            if ((int)cur.val > mink && (int)cur.val < maxk) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
    }
//    public int erase_cnt(Object x) {
//        int cnt = 0;
//        Node cur = head;
//        int i = 0;
//        while(cur != null) {
//            if (cur.val.equals(x)) {
//                erase(i);
//                cnt++;
//            }
//            cur = cur.next;
//            i++;
//        }
//        return cnt;
//    }
}


