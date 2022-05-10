package view;

import Music.*;
import controller.ClickController;
import controller.GameController;
import model.ChessColor;
import model.ChessComponent;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 这个类表示游戏过程中的整个游戏界面，是一切的载体
 */
public class ChessGameFrame extends JFrame {

    //    public final Dimension FRAME_SIZE ;
    public final int WIDTH;
    public final int HEIGTH;
    public final int CHESSBOARD_SIZE;
    private GameController gameController;
    public static JLabel statusLabel;
    private int clickNumberForStyleChanger = 0;
    private Chessboard chessboard1;

    public static int time2 = 20;

    public ChessGameFrame(int width, int height) {
        setTitle("2022 CS102A Project Demo "); //设置标题
        this.WIDTH = width;
        this.HEIGTH = height;
        this.CHESSBOARD_SIZE = HEIGTH * 4 / 5;

        setSize(WIDTH, HEIGTH);
        setLocationRelativeTo(null); // Center the window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);

        statusLabel = new JLabel("WHITE's round");
        statusLabel.setLocation(HEIGTH, HEIGTH / 10);
        statusLabel.setSize(200, 60);
        statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(statusLabel);
        Music musicPlayer = new Music();
        Music4 musicPlayer4 = new Music4();
        JButton sound1 = new JButton("Open music");
        sound1.setFont(new Font("Rockwell", Font.BOLD, 20));
        sound1.setSize(200, 30);
        sound1.setLocation(HEIGTH, HEIGTH * 15 / 20);
        add(sound1);
        sound1.addActionListener(e -> {
            if (clickNumberForStyleChanger % 2 == 1) {
                musicPlayer4.play();

            } else {

                musicPlayer.play();


            }
        });
        JButton buttonStyleChanger = new JButton("Change Style");

        buttonStyleChanger.setLocation(HEIGTH, HEIGTH / 5 + 240);
        buttonStyleChanger.setSize(200, 30);
        buttonStyleChanger.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(buttonStyleChanger);


        chessboard1 = new Chessboard(CHESSBOARD_SIZE, CHESSBOARD_SIZE);
        gameController = new GameController(chessboard1);
        chessboard1.setLocation(HEIGTH / 10, HEIGTH / 10);
        add(chessboard1);
        addLoadButton();
        addSaveButton();
        JLabel Timer1 = new JLabel();
        Timer1.setLocation(HEIGTH, HEIGTH / 20);
        Timer1.setSize(200, 60);
        Timer1.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(Timer1);
        setVisible(true);

        java.util.Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {


            public void run() {

                Timer1.setText("Time left: " + time2);
                time2--;

                if (time2 < 0) {

                    Timer1.setText("Time Over");
                    chessboard1.swapColor();
                    time2=20;
                }
            }
        }, 0, 1000);
        JButton sound2 = new JButton("Close music");
        sound2.setFont(new Font("Rockwell", Font.BOLD, 20));
        sound2.setSize(200, 30);
        sound2.setLocation(HEIGTH, HEIGTH * 16 / 20);
        add(sound2);
        JButton buttonRestart = new JButton("Restart");

        buttonRestart.setLocation(HEIGTH, HEIGTH / 10 + 120);
        buttonRestart.setSize(200, 60);
        buttonRestart.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(buttonRestart);
        BackgroundPanel bgp = new BackgroundPanel((new ImageIcon("./src/controller/img_2.png")).getImage());
        bgp.setBounds(0, 0, width, height);
        add(bgp);
        BackgroundPanel bgp2 = new BackgroundPanel((new ImageIcon("./src/controller/img_6.png")).getImage());
        bgp2.setBounds(0, 0, 760, 750);

        buttonStyleChanger.addActionListener((e) -> {
            clickNumberForStyleChanger++;
            if (clickNumberForStyleChanger % 2 == 1) {
                remove(bgp);
                add(bgp2);
                musicPlayer4.play();
                musicPlayer.over();
                ChessComponent.BACKGROUND_COLORS = ChessComponent.BACKGROUND_COLORS_PLUS;
                //chessboard1.ResetChessboard();
            } else {
                add(bgp);
                remove(bgp2);
                musicPlayer4.over();
                musicPlayer.play();
                ChessComponent.BACKGROUND_COLORS = ChessComponent.BACKGROUND_COLORS_ORIGIN;
                //chessboard1.ResetChessboard();
            }
        });

        sound2.addActionListener(e -> {
            musicPlayer.over();
            musicPlayer4.over();

        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    File wavFile = new File("./src/Music/按键点击.wav");
                    AudioInputStream ais = AudioSystem.getAudioInputStream(wavFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(ais);
                    clip.start();
                    System.out.println("mouseEntered" + " " + "./src/Music/按键点击.wav");
                } catch (Exception ex) {
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setACTIVE();
                try {
                    File wavFile = new File("./src/sound/按键选中.wav");
                    AudioInputStream ais = AudioSystem.getAudioInputStream(wavFile);
                    Clip clip = AudioSystem.getClip();
                    clip.open(ais);
                    clip.start();
                    System.out.println("mouseEntered" + " " + "./src/sound/按键选中.wav");
                } catch (Exception ex) {
                }

            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExit" + " " + "./src/sound/按键选中.wav");
                super.mouseExited(e);
                setUNACTIVE();
            }
        });


        buttonRestart.addActionListener((e) -> {
            chessboard1.setCurrentColor(ChessColor.WHITE);
            statusLabel.setText("WHITE's round");

            time2 = 20;
            chessboard1.ResetChessboard();
            ClickController.realFirst=ChessColor.BLACK;
        });

    }


    private void setACTIVE() {
        setBackground(new Color(255, 255, 0));
        setLocation(getX(), getY());
        setForeground(Color.BLACK);
        repaint();
    }

    private void setUNACTIVE() {
        setBackground(Color.GRAY);
        setLocation(getX(), getY());
        setForeground(Color.WHITE);
        repaint();
    }


    /**
     * 在游戏面板中添加棋盘
     */
    private void addChessboard() {

    }

    /**
     * 在游戏面板中添加标签
     */
    public void addLabel(ChessColor i) {
        if (i.equals(ChessColor.WHITE)) {
            JLabel statusLabel = new JLabel("The white round");
            statusLabel.setLocation(HEIGTH, HEIGTH / 10);
            statusLabel.setSize(200, 60);
            statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
            add(statusLabel);
        }
        if (i.equals(ChessColor.BLACK)) {
            JLabel statusLabel = new JLabel("The black round");
            statusLabel.setLocation(HEIGTH, HEIGTH / 10);
            statusLabel.setSize(200, 60);
            statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
            add(statusLabel);
        }
    }

    /**
     * 在游戏面板中增加一个按钮，如果按下的话就会显示Hello, world!
     */

    private void addHelloButton() {
        JButton button = new JButton("Show Hello Here");
        button.addActionListener((e) -> JOptionPane.showMessageDialog(this, "Hello, world!"));
        button.setLocation(HEIGTH, HEIGTH / 10 + 120);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);
    }

    private void addLoadButton() {
        JButton button = new JButton("Load");
        button.setLocation(HEIGTH, HEIGTH / 10 + 240);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click load");
            JFileChooser jfc = new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            jfc.showDialog(new JLabel(), "选择");
            File file = jfc.getSelectedFile();
            if (file.isDirectory()) {
                System.out.println("文件夹:" + file.getAbsolutePath());
            } else if (file.isFile()) {
                System.out.println("文件:" + file.getAbsolutePath());
            }
            System.out.println(jfc.getSelectedFile().getName());
            String path = file.getAbsolutePath();
            gameController.loadGameFromFile(path);
        });
    }

    public void setTime2(int i) {
        time2 = i;

    }

    private void addSaveButton() {// 保存键 2022.4.30 by Winnie//updated by Wang
        JButton button = new JButton("Save");
        button.setLocation(HEIGTH, HEIGTH / 10 + 360);
        button.setSize(200, 60);
        button.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button);

        button.addActionListener(e -> {
            System.out.println("Click save");
            JFileChooser jfc = new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            jfc.showDialog(new JLabel(), "选择");
            File file = jfc.getSelectedFile();
            if (file.isDirectory()) {
                System.out.println("文件夹:" + file.getAbsolutePath());
            } else if (file.isFile()) {
                System.out.println("文件:" + file.getAbsolutePath());
            }
            System.out.println(jfc.getSelectedFile().getName());
            //后缀名过滤器
            FileNameExtensionFilter filter = new FileNameExtensionFilter("标签文件(*.txt)", "txt");
            jfc.setFileFilter(filter);
// 在容器上打开文件选择器

            File f = jfc.getSelectedFile();
//字节输出流
            FileOutputStream fos = null;
            try {
                String fname = f.getName();//从文件名输入框中获取文件名
                //创建文件
                File file1 = new File(jfc.getCurrentDirectory() + "/" + fname);
                fos = new FileOutputStream(file1);
                //写入文件操作
                gameController.saveGameFromFile(file1.getAbsolutePath());

            } catch (IOException e1) {
                System.err.println("IO异常");
                e1.printStackTrace();
            }


        });


    }

    class BackgroundPanel extends JPanel {
        Image im;

        public BackgroundPanel(Image im) {
            this.im = im;
            this.setOpaque(true);
        }

        //Draw the back ground.
        public void paintComponent(Graphics g) {
            super.paintComponents(g);
            g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), chessboard1.Bishop1);

        }
    }


}
