package 数据结构.第三章;

public class The_link_queue {
    interface Ilink_queue {
        public void clear();
        public boolean empty();
        public int size();
        public Object front();
        public void push(Object x);
        public void pop();
        public void display();
    }
    public static void main(String[] args) {
        link_queue q = new link_queue();
        for (int i = 0; i < 10; i++) {
            q.push(i);
        }
        System.out.print("链队列展示" + "\n");
        q.display();
        System.out.print("链队列大小:" + q.size() + "\n");
        System.out.print("队首元素:" + q.front() + "\n");
        System.out.print("弹出队首:");
        q.pop();
        System.out.print("\n" + "当前队首元素:" + q.front());
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

class link_queue implements The_link_queue.Ilink_queue {
    Node hh, tt;
    public link_queue() {
        hh = tt = null;
    }
    public void clear() {
        hh = tt = null;
    }
    public boolean empty() {
        return hh == tt;
    }
    public int size() {
        Node p = hh;
        int sz = 0;
        while (p != null) {
            p = p.next;
            sz++;
        }
        return sz;
    }
    public Object front() {
        return hh.val;
    }
    public void push(Object x) {
        Node p = new Node(x);
        if (hh != null) {
            tt.next = p;
            tt = p;
        } else {
            hh = tt = p;
        }
    }
    public void pop() {
        if (hh != null) {
            Node p = hh;
            hh = hh.next;
            if (p == tt)  {
                tt = null;
            }
        }
    }
    public void display() {
        Node p = hh;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.print("\n");
    }
}