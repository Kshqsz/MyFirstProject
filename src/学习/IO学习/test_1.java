package 学习.IO学习;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class test_1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\24564\\Desktop\\main\\数电\\计数器\\计数器.mp4");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\24564\\Desktop\\main\\Java");

        int len;
        byte[] bytes = new byte[1024 * 1024 * 5];
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        fos.close();
        fis.close();
    }
}
