package 学习.异常学习;

public class test_1 {
    public static void main(String[] args) {
        int [] arr = {1, 2};
        try {
            System.out.print(arr[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("索引越界了");
        }
    }
}
