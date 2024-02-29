package 学习.file;

import javax.imageio.plugins.tiff.ExifGPSTagSet;
import java.io.File;
import java.io.IOException;

public class test_3 {
    public static void main(String[] args) throws IOException {
//        File file = new File("C:\\Users\\24564\\Desktop\\a\\a.txt");
//        file.createNewFile();

//        File[] files = File.listRoots();
//        for (File f : files) {
//            GetAvi(f);
//        }
        File file = new File("C:\\Users\\24564\\Desktop\\a");
        DeletFiles(file);

    }
    public static boolean HaveAvi(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(".avi")) {
                return true;
            }
        }
        return false;
    }
    public static void GetAvi(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile() && f.getName().endsWith(".txt")) {
                    System.out.println(f.getName());
                } else {
                    GetAvi(f);
                }
            }
        }
    }

    public static void DeletFiles(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                f.delete();
            } else {
                DeletFiles(f);
            }
        }
        file.delete();
    }
}
