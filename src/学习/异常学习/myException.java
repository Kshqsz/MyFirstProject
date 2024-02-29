package 学习.异常学习;

public class myException extends RuntimeException {
    public myException() {
    }

    public myException(String message) {
        super(message);
    }
}
