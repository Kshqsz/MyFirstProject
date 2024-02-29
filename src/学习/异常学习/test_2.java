package 学习.异常学习;

public class test_2 {
    public static void main(String[] args) {
        int [] arr = {1, 2};

        try {
            System.out.print(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
//            String message = e.getMessage();
//            System.out.print(message + "\n");
//
//            String str = e.toString();
//            System.out.print(str + "\n");
//
            e.printStackTrace();
        }


        System.out.print(10);
    }
}
