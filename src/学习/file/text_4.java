package 学习.file;

import java.io.File;

public class text_4 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\24564\\Desktop\\main");
        System.out.println(GetLen(file));
    }
    public static long GetLen(File file) {
        File[] files = file.listFiles();
        long cnt = 0;
        for (File f : files) {
            if (f.isFile()) {
                cnt += f.length();
            } else {
                cnt += GetLen(f);
            }
        }
        return cnt;
    }
}
