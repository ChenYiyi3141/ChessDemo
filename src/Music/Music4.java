package Music;

import javax.sound.sampled.*;
import java.io.*;

public class Music4 {



//    public static boolean flag = true;

    private static File file;
    public static boolean isLoop = true;
    private static boolean isPlaying;
    public PlayThread playThread = new PlayThread();



    public void play(){
        playThread.start();
    }
    public void over() {
        isPlaying = false;
        if (playThread != null) {
            playThread = new PlayThread();
        }
    }

    public class PlayThread extends Thread{
        @Override
        public void run(){
            do {
                isPlaying = true;
                File file=new File("\\src\\Music\\bgm2.wav");

                String path = String.valueOf(file.getAbsoluteFile());
                SourceDataLine sourceDataLine = null;
                BufferedInputStream bufIn = null;
                AudioInputStream audioIn = null;
                try {
                    bufIn = new BufferedInputStream(new FileInputStream("./src/Music/bgm2.wav"));
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
            }while (isPlaying);
        }
    }
}

//        catch (Exception e) {
//            e.printStackTrace();



