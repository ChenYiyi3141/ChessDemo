package Music;

import javax.sound.sampled.*;
import java.io.*;

public class Music2 {
    private static File file;
    public static boolean isLoop = true;
    private static boolean isPlaying;
    public Music2.PlayThread2 playThread2 = new Music2.PlayThread2();



    public void play(){
        playThread2.start();
    }
    public void over() {
        isPlaying = false;

        if (playThread2 != null) {
            playThread2 = new Music2.PlayThread2();
        }
    }

    public class PlayThread2 extends Thread{
        @Override
        public void run(){

                isPlaying = true;
                File file=new File("\\src\\Music\\按键点击.wav");

                String path = String.valueOf(file.getAbsoluteFile());
                SourceDataLine sourceDataLine = null;
                BufferedInputStream bufIn = null;
                AudioInputStream audioIn = null;
                try {
                    bufIn = new BufferedInputStream(new FileInputStream("./src/Music/按键点击.wav"));
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

