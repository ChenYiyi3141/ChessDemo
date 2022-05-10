
import Music.Music;
import controller.Player;
import view.ChessGameFrame;
import view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main  {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame(800, new Player("未登录", 0));
            mainFrame.setVisible(true);
        });


}}

