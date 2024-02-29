package 数据结构.第三章;

public class The_queue {
    interface Iqueue {
        public void clear();
        public boolean empty();
        public int size();
        public int front();
        public void push(int x);
        public void pop();
        public void display();
    }
    public static void main(String[] args) {
        queue q = new queue(10);
        for (int i = 0; i < 9; i++) {
            q.push(i);
        }
        System.out.print("循环队列展示:" + "\n");
        q.display();
        System.out.print("队列长度:" + q.size() + "\n");
        System.out.print("队首元素:" + q.front() + "\n");
        System.out.print("弹出队首元素:" + "\n");
        q.pop();
        System.out.print("当前队首元素:" + q.front() + "\n");
        System.out.print("循环队列展示:" + "\n");
        q.display();
    }
}

class queue implements The_queue.Iqueue {
    int []q;
    int hh, tt;
    public queue(int maxsz) {
        hh = tt = 0;
        q = new int[maxsz];
    }
    public void clear() {
        hh = tt = 0;
    }
    public boolean empty() {
        return hh == tt;
    }
    public int size() {
        return (tt - hh + q.length) % q.length;
    }
    public int front() {
        return q[hh];
    }
    public void push(int x) {
        q[tt] = x;
        tt = (tt + 1) % q.length;
    }
    public void pop() {
        int x = q[hh];
        hh = (hh + 1) % q.length;
    }
    public void display() {
        for (int i = hh; i != tt; i = (i + 1) % q.length) {
            System.out.print(q[i] + " ");
        }
        System.out.print("\n");
    }
}