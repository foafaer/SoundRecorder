import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        String ACCESS_TOKEN = "PZ1e8g-cFIAAAAAAAAAAAQE332n0566eL_i2ctbMdaMmmZLAkDmp7XCsF0nAV9ao";

        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        while (true) {
            MyThread thread = new MyThread(client);
            thread.start();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
