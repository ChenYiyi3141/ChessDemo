package Music;

import javax.sound.sampled.*;
import java.io.*;

public class Music3 {
    private static File file;
    public static boolean isLoop = true;
    private static boolean isPlaying;
    public Music3.PlayThread3 playThread3 = new Music3.PlayThread3();



    public void play(){
        playThread3.start();
    }
    public void over() {
        isPlaying = false;
        if (playThread3 != null) {
            playThread3 = new Music3.PlayThread3();
        }
    }

    public class PlayThread3 extends Thread{
        @Override
        public void run(){

            isPlaying = true;
            File file=new File("\\src\\Music\\down.wav");

            String path = String.valueOf(file.getAbsoluteFile());
            SourceDataLine sourceDataLine = null;
            BufferedInputStream bufIn = null;
            AudioInputStream audioIn = null;
            try {
                bufIn = new BufferedInputStream(new FileInputStream("./src/Music/down.wav"));
                audioIn = AudioSystem.getAudioInputStream(bufIn);
                AudioFormat format =audioIn.getFormat();
                sourceDataLine = AudioSystem.getSourceDataLine(format);

                sourceDataLine.open();

                sourceDataLine.start();
                byte[] buf = new byte[512];
                int len  = -1;
                while (isPlaying && (len = audioIn.read(buf)) != -1){
                    sourceDataLine.write(buf,0,len);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }finally {
                if(sourceDataLine !=null){
                    sourceDataLine.drain();
                    sourceDataLine.close();
                }try {
                    if(bufIn != null){
                        bufIn.close();
                    }if (audioIn != null){
                        audioIn.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

