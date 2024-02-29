package 学生信息管理系统;

import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        loop : while (true) {
            System.out.print("----------欢迎来到学生信息管理系统----------\n");
            System.out.print("1:添加学生\n");
            System.out.print("2:删除学生\n");
            System.out.print("3:修改学生\n");
            System.out.print("4:查询学生\n");
            System.out.print("5:退出\n");
            System.out.println("请输入你的选择: ");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();

            switch (choose) {
                case "1" -> addStudent();
                case "2" -> deleteStudent();
                case "3" -> updateStudent();
                case "4" -> querytudent();
                case "5" -> {
                    System.out.print("退出\n"); break loop;
                }
                default -> System.out.print("没有这个选项");
            }
        }
    }

    public static void addStudent() {
        System.out.print("添加学生\n");
    }

    public static void deleteStudent() {
        System.out.print("删除学生\n");
    }

    public static void updateStudent() {
        System.out.print("修改学生\n");
    }

    public static void querytudent() {
        System.out.print("查询学生\n");
    }

}


