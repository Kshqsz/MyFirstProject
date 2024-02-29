package 数据结构.第三章;

import java.util.Scanner;

class CustomerQueue {

    private String[] queue;
    private int front;
    private int rear;
    private int size;

    public CustomerQueue(int capacity) {
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(String customerName) {
        if (isFull()) {
            System.out.println("队列已满，无法添加新顾客。");
        } else {
            rear = (rear + 1) % queue.length;
            queue[rear] = customerName;
            size++;
            System.out.println("顾客 " + customerName + " 已添加到队列。");
        }
    }

    public String queue() {
        if (isEmpty()) {
            System.out.println("队列为空，无顾客可理发。");
            return null;
        } else {
            String customerName = queue[front];
            front = (front + 1) % queue.length;
            size--;
            return customerName;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("当前等待的顾客列表为空。");
        } else {
            System.out.print("当前等待的顾客列表: ");
            int current = front;
            for (int i = 0; i < size; i++) {
                System.out.print(queue[current] + " ");
                current = (current + 1) % queue.length;
            }
            System.out.println();
        }
    }
}

public class BarberShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入队列容量: ");
        int capacity = scanner.nextInt();

        CustomerQueue customerQueue = new CustomerQueue(capacity);

        while (true) {
            System.out.println("前海理发店管理系统");
            System.out.println("1. 新增顾客");
            System.out.println("2. 理发");
            System.out.println("3. 显示顾客列表");
            System.out.println("4. 退出");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("请输入顾客姓名: ");
                    String customerName = scanner.nextLine();
                    customerQueue.enqueue(customerName);
                    break;
                case 2:
                    String nextCustomer = customerQueue.queue();
                    if (nextCustomer != null) {
                        System.out.println("正在为顾客 " + nextCustomer + " 理发。");
                    }
                    break;
                case 3:
                    customerQueue.display();
                    break;
                case 4:
                    System.out.println("谢谢使用前海理发店管理系统，再见！");
                    System.exit(0);
                default:
                    System.out.println("无效的选择，请重新输入。");
            }
        }
    }
}


