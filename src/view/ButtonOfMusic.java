package view;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;


public class ButtonOfMusic extends JButton {

    private int floatd = 8;
    private int x, y;

    public ButtonOfMusic(String text, int x, int y, int width, int height, int fontSize){
        super(text);
        this.x = x;
        this.y = y;
        this.setSize(width, height);
        setUNACTIVE();
        setFont(new Font("宋体", Font.BOLD, fontSize));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try{
                    File wavFile = new File("./src/sound/按键点击.wav");
                    AudioInputStream ais = AudioSystem.getAudioInputStream(wavFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(ais);
                    clip.start();
                    System.out.println("mouseEntered" + " " + text);
                }catch (Exception ex){}
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setACTIVE();
                try{
                    File wavFile = new File("./src/sound/按键选中.wav");
                    AudioInputStream ais = AudioSystem.getAudioInputStream(wavFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(ais);
                    clip.start();
                    System.out.println("mouseEntered" + " " + text);
                }catch (Exception ex){}

            }
            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExit" + " " + text);
                super.mouseExited(e);
                setUNACTIVE();
            }
        });
    }

    private void setACTIVE(){
        setBackground(new Color(255,255,0));
        setLocation(x, y - floatd);
        setForeground(Color.BLACK);
        repaint();
    }

    private void setUNACTIVE(){
        setBackground(Color.GRAY);
        setLocation(x, y);
        setForeground(Color.WHITE);
        repaint();
    }
}
