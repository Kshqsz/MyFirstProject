package 数据结构.第三章;

public class The_Stack {
    interface IStack {
        public void clear();
        public boolean empty();
        public int size();
        public int top();
        public void push(int x);
        public void pop();
        public void display();
    }
    public static void main(String[] args) {
        stack st = new stack(10);
        for (int i = 0; i < 9; i++) {
            st.push(i);
        }
        System.out.print("栈展示：");
        st.display();
        System.out.print("栈的大小:" + st.size() + "\n");
        System.out.print("栈顶元素:"  + st.top() + "\n");
        System.out.print("弹出栈顶" + "\n");
        st.pop();
        System.out.print("当前栈顶元素:" + st.top() + "\n");
    }
}
class stack implements The_Stack.IStack {
    int[] st;
    int top;
    public stack(int maxsz) {
        top = 0;
        st = new int[maxsz];
    }
    public void clear() {
        top = 0;
    }
    public boolean empty() {
        return top == 0;
    }
    public int size() {
        return top;
    }
    public int top() {
        if (!empty()) {
            return st[top - 1];
        }
        return -1;
    }
    public void push(int x) {
        st[top++] = x;
    }
    public void pop() {
        top--;
    }
    public void display() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.print(st[i] + " ");
        }
        System.out.print("\n");
    }
}


