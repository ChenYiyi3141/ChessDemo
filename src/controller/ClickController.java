package controller;


import Music.Music;
import model.ChessColor;
import model.ChessComponent;
import model.KingChessComponent;
import view.ChessGameFrame;
import view.Chessboard;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static javax.swing.text.StyleConstants.Alignment;
import static view.ChessGameFrame.statusLabel;

import Music.*;

import view.*;


public class ClickController {
    private final Chessboard chessboard;
    private ChessComponent first;
public static ChessColor realFirst;

    public ClickController(Chessboard chessboard) {
        this.chessboard = chessboard;

//        i=t;
    }

    //    public void roundLabel(){
//
//
//        i.addLabel(chessboard.getCurrentColor());
//
//    }
    public void onClick(ChessComponent chessComponent) {


        if (first == null) {

            if (handleFirst(chessComponent)) {

                chessComponent.setSelected(true);
                first = chessComponent;
                first.repaint();
                realFirst=chessComponent.getChessColor();

            }
        } else {
            if (first == chessComponent) { // 再次点击取消选取

                chessComponent.setSelected(false);
                ChessComponent recordFirst = first;
                first = null;
                recordFirst.repaint();
            } else if (handleSecond(chessComponent)) {
                if (Chessboard.currentColor.equals(chessComponent.getChessColor())||!Chessboard.currentColor.equals(realFirst)) {
                    first.setSelected(false);
                    first = null;
                    return;
                }else {
                //repaint in swap chess method.
                chessboard.swapChessComponents(first, chessComponent);

                chessboard.swapColor();

                first.setSelected(false);
                first = null;}
            }
        }

    }

    /**
     * @param chessComponent 目标选取的棋子
     * @return 目标选取的棋子是否与棋盘记录的当前行棋方颜色相同
     */

    private boolean handleFirst(ChessComponent chessComponent) {
        if (chessComponent.getChessColor().equals(chessboard.getCurrentColorPlus())) {
            Music2 musicPlayer2 = new Music2();
            musicPlayer2.play();
        }
        return chessComponent.getChessColor() == chessboard.getCurrentColorPlus();

    }

    /**
     * @param chessComponent first棋子目标移动到的棋子second
     * @return first棋子是否能够移动到second棋子位置
     */

    private boolean handleSecond(ChessComponent chessComponent) {

        return chessComponent.getChessColor() != chessboard.getCurrentColorPlus() &&
                first.canMoveTo(chessboard.getChessComponents(), chessComponent.getChessboardPoint());
    }
//    public void addLabel(ChessColor i) {
//        if(i.equals(ChessColor.WHITE)){
//            JLabel statusLabel = new JLabel("The white round");
//            statusLabel.setLocation(ChessGameFrame.HEIGHT, ChessGameFrame.HEIGHT / 10);
//            statusLabel.setSize(200, 60);
//            statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
//            Cadd(statusLabel);}
//        if(i.equals(ChessColor.BLACK)){
//            JLabel statusLabel = new JLabel("The black round");
//            statusLabel.setLocation(HEIGTH, HEIGTH / 10);
//            statusLabel.setSize(200, 60);
//            statusLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
//            add(statusLabel);}
//    }
}
