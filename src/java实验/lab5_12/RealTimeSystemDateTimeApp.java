package java实验.lab5_12;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RealTimeSystemDateTimeApp extends JFrame {

    private JLabel dateTimeLabel;

    public RealTimeSystemDateTimeApp() {
        setTitle("实时显示系统日期和时间");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dateTimeLabel = new JLabel();
        dateTimeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        add(dateTimeLabel);

        setVisible(true);

        updateDateTime();
    }

    private void updateDateTime() {
        Thread updateDateTimeThread = new Thread(() -> {
            while (true) {
                Date currentDateTime = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateTimeString = sdf.format(currentDateTime);

                dateTimeLabel.setText(dateTimeString);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        updateDateTimeThread.start();
    }

    public static void main(String[] args) {
        new RealTimeSystemDateTimeApp();
    }
}
