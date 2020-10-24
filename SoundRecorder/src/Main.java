import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

public class Main {
    public static void main(String[] args) {

        String ACCESS_TOKEN = "sl.AkNyc4AEYA_oj6VUmiX9XlaDiD5Oz6a85dUJ4HMk1s2YALwQWWYb2LQ9NVS2r18kB_acWVDstk9O3AQRDjfDq00x9Ijojy_B9UMUXKlCShWj_83D5ntKGI7_sR7-xk4lQbR4noE";


        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);


        JavaSoundRecorder soundRecorder = new JavaSoundRecorder(client);
        soundRecorder.recordAudio(30000);
    }
}
