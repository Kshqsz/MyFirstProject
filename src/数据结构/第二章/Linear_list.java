package 数据结构.第二章;

import java.util.Scanner;

public class Linear_list {
    interface list {
        boolean empty();
        void clear();
        int size();
        Object get(int i);
        void insert(int idx, Object x);
        void erase(int idx);
        int find(Object x);
        void print();
        void reverse();
    }

    public static void main(String[] args) {
        vector v = new vector(20);
        Scanner cin = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int x = cin.nextInt();
            v.insert(i, x);
        }

        System.out.print(v.empty() + "\n");
        System.out.print("在索引7处插入2" + "\n");
        v.insert(7, 2);
        v.print();

        System.out.print("线性表倒置" + "\n");
        v.reverse();
        v.print();

        System.out.print("删除索引3处的数" + "\n");
        v.erase(3);
        v.print();

        System.out.print("索引2的数 : " + v.get(2) + "\n");
        System.out.print("线性表大小 :" +  v.size() + "\n");
        System.out.print("10的索引:" + v.find(10) + "\n");
    }
}

class vector implements Linear_list.list {
    public Object [] a;

    public int n = 0;

    public vector(int sz) {
        a = new Object[sz];
    }

    public boolean empty() {
        return n == 0;
    }

    public void clear() {
        n = 0;
    }

    public int size() {
        return n;
    }

    public Object get(int i) {
        return a[i];
    }

    public void insert(int idx, Object x) {
        for (int i = n; i > idx; i--) {
            a[i] = a[i - 1];
        }
        a[idx] = x;
        n++;
    }

    public void erase(int idx) {
        for (int i = idx; i < n - 1; i++) {
            a[i] = a[i + 1];
        }
        n--;
    }

    public int find(Object x) {
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print("\n");
    }
    public void reverse() {
        for (int i = 0; i < n / 2; i++) {
            Object temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }
    }
}