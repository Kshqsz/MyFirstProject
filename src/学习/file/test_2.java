package 学习.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

public class test_2 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("C:\\Users\\24564\\Desktop\\test.docx");
//        System.out.println(f1.isDirectory());
//        System.out.println(f1.isFile());
//        System.out.println(f1.exists());
//
//        //不能获取文件夹的大小
//        System.out.println(f1.length());
//
        //把时间毫秒值变成字符串的时间
//        long time = f1.lastModified();
//        SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd日 HH: mm : ss");
//        String s = sd.format(new Date(time));
//        System.out.println(s);


//        File f2 = new File("C:\\Users\\24564\\Desktop\\a.txt");
//        boolean b = f2.createNewFile();
//        System.out.println(b);
//        File f3 = new File("C:\\Users\\24564\\Desktop\\a");
//        boolean b = f3.mkdir();
//        System.out.println(b);

        //有内容的文件夹删除失败
//        File f4 = new File("C:\\Users\\24564\\Desktop\\a");
//        //f4.createNewFile();


//        File[] files = f4.listFiles();
//        for (File file : files) {
//            System.out.println(file.getName());
//        }
        //System.out.println(b);

//        File[] files = File.listRoots();
//        System.out.println(Arrays.toString(files));



        //list是获取文件名
//        File f5 = new File("C:\\Users\\24564\\Desktop");
//        String[] list = f5.list();
//        for (String s1 : list) {
//            System.out.println(s1);
//        }
    }
}
