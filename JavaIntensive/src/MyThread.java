import com.dropbox.core.v2.DbxClientV2;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {
    private final DbxClientV2 client;
    public MyThread (DbxClientV2 clientV2) {
        this.client = clientV2;
    }
    @Override
    public void run() {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage image = null;
        try {
            image = new Robot().createScreenCapture(screenRect);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String date = formatter.format(new Date());

        try {
            InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            client.files().uploadBuilder("/" + date + ".png")
                    .uploadAndFinish(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
