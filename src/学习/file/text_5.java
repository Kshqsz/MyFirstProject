package 学习.file;

import java.io.File;
import java.util.HashMap;

public class text_5 {
    static HashMap<String, Integer> mp = new HashMap<>();
    public static void main(String[] args) {
        File file = new File("C:\\Users\\24564\\Desktop\\main");
        CntFile(file);
        System.out.println(mp);
    }
    public static void CntFile(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                String s = f.getName();
                String[] split = f.getName().split("\\.");
                if (split.length >= 2) {
                    String suf = split[split.length - 1];
                    if (mp.containsKey(suf)) {
                        int cnt = mp.get(suf);
                        mp.put(suf, cnt + 1);
                    } else {
                        mp.put(suf, 1);
                    }
                }
            } else {
                CntFile(f);
            }
        }
    }
}
