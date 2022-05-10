package view;


import controller.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainFrame extends JFrame {

    JPanel rankpanel = new JPanel();
    JLabel user = new JLabel();
    private Player player;

    public static ArrayList<Player> playerList = new ArrayList<>();
    public static ArrayList<Player> ranking = new ArrayList<Player>();

    public MainFrame(int frameSize, Player pl){

        //read players & ranking
        try( Scanner sc = new Scanner(new FileReader("./src/controller/players.txt")) ){
            playerList = new ArrayList<>();
            ranking = new ArrayList<Player>();
            while(sc.hasNext()){
                String name = sc.next();
                int highscore = sc.nextInt();
                Player p =new Player(name, highscore);
                playerList.add(p);
                addrank(p);
            }
        } catch (IOException e) {}

        this.setTitle("Miserable ChenYiyi");
        this.setLayout(null);

        Insets inset = this.getInsets();
        this.setSize(frameSize + inset.left + inset.right, frameSize + inset.top + inset.bottom);
        this.setResizable(false);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    FileWriter fileWriter = new FileWriter("./src/controller/players.txt");
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    for(Player p : playerList){
                        bufferedWriter.write(p.getUserName() + " " + p.getHighestScore());
                        bufferedWriter.write("\r\n");
                    }
                    bufferedWriter.close();
                    fileWriter.close();
                } catch (IOException ex) {ex.printStackTrace();}
                System.out.println("主窗体关闭，Game over");
            }
        });

        player = pl;
        paintranking();
        paintuser();

        Button startBtn = new Button("start", 550, 250, 200, 50, 30);
        add(startBtn);
        startBtn.addActionListener(e -> {
            System.out.println("click start Btn");
            //start the game
            this.setVisible(false);
            ChessGameFrame mainFrame = new ChessGameFrame(1000, 760);

            mainFrame.setVisible(true);




        });

        Button LoginBtn = new Button("Login", 550, 250 + 100, 200, 50, 30);
        add(LoginBtn);
        LoginBtn.addActionListener(e -> {
            System.out.println("click Login Btn");
            //LoginBtn
            String username = JOptionPane.showInputDialog(this, "input the player's name here");
            boolean exist = false;
            for(Player p : playerList) if( p.getUserName().equals(username) ) {
                exist = true;
                player = p;
            }
            if(exist) {
                JOptionPane.showMessageDialog(this, "登录成功");
                paintuser();
            }
            else if(!username.equals(null)) JOptionPane.showMessageDialog(this, "该用户不存在");

        });

        Button RegisterBtn = new Button("Register", 550, 250 + 200, 200, 50, 30);
        add(RegisterBtn);
        RegisterBtn.addActionListener(e -> {
            System.out.println("click Register Btn");
            //RegisterBtn
            String username = JOptionPane.showInputDialog(this, "input the player's name here");
            if(username.isEmpty()) return;
            boolean exist = false;
            for(Player p : playerList) if( p.getUserName().equals(username) ) exist = true;
            if(!exist) {
                JOptionPane.showMessageDialog(this, "创建成功!");

                player = new Player(username, 0);

                playerList.add(player);

                addrank(player);
            }
            else JOptionPane.showMessageDialog(this, "该用户已存在");
        });

    }

    public void addrank(Player p){
        if(p.getUserName().equals("未登录")) return;
        for(Player pl : ranking)
            if(p.getUserName().equals(pl.getUserName())) ranking.remove(pl);
        ranking.add(p);
        Collections.sort(ranking);
        if(ranking.size() > 10) ranking.remove(10);
        paintranking();
    }

    public void paintranking(){
        this.remove(rankpanel);
        rankpanel = new JPanel();

        rankpanel.setBackground(Color.orange);
        rankpanel.setSize((int) (this.getWidth() * 0.55), (int) (this.getHeight() * 0.6));
        rankpanel.setLocation( 80, 150 );

        rankpanel.setLayout(new GridLayout(10, 1));
        String rank = new String();
        int loc = 1;
        for(Player p : ranking) {
            rank = " No." + loc + " " + p.getUserName() + " " + p.getHighestScore();
            JLabel ranklist = new JLabel(rank);
            ranklist.setFont(new Font("黑体", Font.BOLD, 30));
            ranklist.setLocation(20, 20 + loc * 10);
            ranklist.setSize(20, 20);
            rankpanel.add(ranklist);
            System.out.println(rank);
            loc ++;
        }
        rankpanel.setVisible(true);
        this.add(rankpanel);
        repaint();
        this.setVisible(true);
    }

    public void paintuser(){
        this.remove(user);
        user.setText("user: " + player.getUserName());
        user.setLocation( 80, 100);
        user.setFont(new Font("黑体", Font.BOLD, 30));
        user.setSize(250, 30);
        this.add(user);
        repaint();
        this.setVisible(true);
    }

    public Player getPlayer() {return player;}
}
