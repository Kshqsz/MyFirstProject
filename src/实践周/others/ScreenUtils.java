package 实践周.others;

import java.awt.*;

public class ScreenUtils {

    public static int getScreenWidth()
    {
        return Toolkit.getDefaultToolkit().getScreenSize().width;
    }

    public static int getScreenHeight()
    {
        return Toolkit.getDefaultToolkit().getScreenSize().height;
    }

}
