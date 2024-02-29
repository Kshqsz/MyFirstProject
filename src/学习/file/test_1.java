package 学习.file;

import java.io.File;

public class test_1 {
    public static void main(String[] args) {
        String str = "C:\\Users\\24564\\Desktop\\test.docx";
        File f1 = new File(str);
        //System.out.print(f1);

        String parent = "C:\\Users\\24564\\Desktop";
        String child = "a.docx";
        File f2 = new File(parent, child);
        System.out.print(f2 + "\n");

        File parent2 = new File("C:\\Users\\24564\\Desktop");
        String child2 = "b.docx";
        File f3 = new File(parent2, child2);
        System.out.print(f3);
    }
}
