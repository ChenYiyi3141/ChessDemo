package view;


import com.sun.source.tree.NewArrayTree;
import controller.Record;
import model.*;
import controller.ClickController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static view.ChessGameFrame.statusLabel;

/**
 * 这个类表示面板上的棋盘组件对象
 */
public class Chessboard extends JComponent {
    /**
     * CHESSBOARD_SIZE： 棋盘是8 * 8的
     * <br>
     * BACKGROUND_COLORS: 棋盘的两种背景颜色
     * <br>
     * chessListener：棋盘监听棋子的行动
     * <br>
     * chessboard: 表示8 * 8的棋盘
     * <br>
     * currentColor: 当前行棋方
     */
    private static final int CHESSBOARD_SIZE = 8;


  private ChessComponent[][] chessComponents = new ChessComponent[CHESSBOARD_SIZE][CHESSBOARD_SIZE];
    public static ChessColor currentColor = ChessColor.WHITE;
    public static int cnt = 0;
    //all chessComponents in this chessboard are shared only one model controller

    private final int CHESS_SIZE;

    private ClickController clickController = new ClickController(this);
    private Record[][] ChessboardRecord = new Record[8][8];//22.5.2 by Winnie 记录当前棋盘的样子，包括当前棋子是谁，被吃的棋子是谁，当前棋子来自哪里
    private ArrayList<Record> go = new ArrayList<>();//22.5.2 by Winnie 记录整个行棋过程
    private int width;
    private int height;
    public ChessComponent Rook1;
    public ChessComponent Rook2;
    public ChessComponent Rook3;
    public ChessComponent Rook4;
    public ChessComponent Pawn1;
    public ChessComponent Pawn2;
    public ChessComponent Pawn3;
    public ChessComponent Pawn4;
    public ChessComponent Pawn5;
    public ChessComponent Pawn6;
    public ChessComponent Pawn7;
    public ChessComponent Pawn8;

    public ChessComponent Pawn9;
    public ChessComponent Pawn10;
    public ChessComponent Pawn11;
    public ChessComponent Pawn12;
    public ChessComponent Pawn13;
    public ChessComponent Pawn14;
    public ChessComponent Pawn15;
    public ChessComponent Pawn16;

    public ChessComponent Queen1;
    public ChessComponent Queen2;
    public ChessComponent King1;
    public ChessComponent King2;
    public ChessComponent Knight1;
    public ChessComponent Knight2;
    public ChessComponent Knight3;
    public ChessComponent Knight4;
    public ChessComponent Bishop1;
    public ChessComponent Bishop2;
    public ChessComponent Bishop3;
    public ChessComponent Bishop4;

    public Chessboard(int width, int height) {
        this.width = width;
        this.height = height;
        setLayout(null); // Use absolute layout.
        setSize(width, height);
        CHESS_SIZE = width / 8;
        System.out.printf("chessboard size = %d, chess size = %d\n", width, CHESS_SIZE);

        initiateEmptyChessboard();

        //initialization();
        Rook1 = new RookChessComponent(new ChessboardPoint(0, 0), calculatePoint(0, 0), ChessColor.BLACK, clickController, CHESS_SIZE);
        Rook1.setVisible(true);
        putChessOnBoard(Rook1);
        Rook2 = new RookChessComponent(new ChessboardPoint(0, 7), calculatePoint(0, 7), ChessColor.BLACK, clickController, CHESS_SIZE);
        Rook2.setVisible(true);
        putChessOnBoard(Rook2);
        Rook3 = new RookChessComponent(new ChessboardPoint(7, 0), calculatePoint(7, 0), ChessColor.WHITE, clickController, CHESS_SIZE);
        Rook3.setVisible(true);
        putChessOnBoard(Rook3);
        Rook4 = new RookChessComponent(new ChessboardPoint(7, 7), calculatePoint(7, 7), ChessColor.WHITE, clickController, CHESS_SIZE);
        Rook4.setVisible(true);
        putChessOnBoard(Rook4);

        Pawn1 = new PawnChessComponent(new ChessboardPoint(1, 0), calculatePoint(1, 0), ChessColor.BLACK, clickController, CHESS_SIZE);
        Pawn1.setVisible(true);
        putChessOnBoard(Pawn1);
        Pawn2 = new PawnChessComponent(new ChessboardPoint(1, 1), calculatePoint(1, 1), ChessColor.BLACK, clickController, CHESS_SIZE);
        Pawn2.setVisible(true);
        putChessOnBoard(Pawn2);
        Pawn3 = new PawnChessComponent(new ChessboardPoint(1, 2), calculatePoint(1, 2), ChessColor.BLACK, clickController, CHESS_SIZE);
        Pawn3.setVisible(true);
        putChessOnBoard(Pawn3);
        Pawn4 = new PawnChessComponent(new ChessboardPoint(1, 3), calculatePoint(1, 3), ChessColor.BLACK, clickController, CHESS_SIZE);
        Pawn4.setVisible(true);
        putChessOnBoard(Pawn4);
        Pawn5 = new PawnChessComponent(new ChessboardPoint(1, 4), calculatePoint(1, 4), ChessColor.BLACK, clickController, CHESS_SIZE);
        Pawn5.setVisible(true);
        putChessOnBoard(Pawn5);
        Pawn6 = new PawnChessComponent(new ChessboardPoint(1, 5), calculatePoint(1, 5), ChessColor.BLACK, clickController, CHESS_SIZE);
        Pawn6.setVisible(true);
        putChessOnBoard(Pawn6);
        Pawn7 = new PawnChessComponent(new ChessboardPoint(1, 6), calculatePoint(1, 6), ChessColor.BLACK, clickController, CHESS_SIZE);
        Pawn7.setVisible(true);
        putChessOnBoard(Pawn7);
        Pawn8 = new PawnChessComponent(new ChessboardPoint(1, 7), calculatePoint(1, 7), ChessColor.BLACK, clickController, CHESS_SIZE);
        Pawn8.setVisible(true);
        putChessOnBoard(Pawn8);

        Pawn9 = new PawnChessComponent(new ChessboardPoint(6, 0), calculatePoint(6, 0), ChessColor.WHITE, clickController, CHESS_SIZE);
        Pawn9.setVisible(true);
        putChessOnBoard(Pawn9);
        Pawn10 = new PawnChessComponent(new ChessboardPoint(6, 1), calculatePoint(6, 1), ChessColor.WHITE, clickController, CHESS_SIZE);
        Pawn10.setVisible(true);
        putChessOnBoard(Pawn10);
        Pawn11 = new PawnChessComponent(new ChessboardPoint(6, 2), calculatePoint(6, 2), ChessColor.WHITE, clickController, CHESS_SIZE);
        Pawn11.setVisible(true);
        putChessOnBoard(Pawn11);
        Pawn12 = new PawnChessComponent(new ChessboardPoint(6, 3), calculatePoint(6, 3), ChessColor.WHITE, clickController, CHESS_SIZE);
        Pawn12.setVisible(true);
        putChessOnBoard(Pawn12);
        Pawn13 = new PawnChessComponent(new ChessboardPoint(6, 4), calculatePoint(6, 4), ChessColor.WHITE, clickController, CHESS_SIZE);
        Pawn13.setVisible(true);
        putChessOnBoard(Pawn13);
        Pawn14 = new PawnChessComponent(new ChessboardPoint(6, 5), calculatePoint(6, 5), ChessColor.WHITE, clickController, CHESS_SIZE);
        Pawn14.setVisible(true);
        putChessOnBoard(Pawn14);
        Pawn15 = new PawnChessComponent(new ChessboardPoint(6, 6), calculatePoint(6, 6), ChessColor.WHITE, clickController, CHESS_SIZE);
        Pawn15.setVisible(true);
        putChessOnBoard(Pawn15);
        Pawn16 = new PawnChessComponent(new ChessboardPoint(6, 7), calculatePoint(6, 7), ChessColor.WHITE, clickController, CHESS_SIZE);
        Pawn16.setVisible(true);
        putChessOnBoard(Pawn16);

        Queen1 = new QueenChessComponent(new ChessboardPoint(0, 3), calculatePoint(0, 3), ChessColor.BLACK, clickController, CHESS_SIZE);
        Queen1.setVisible(true);
        putChessOnBoard(Queen1);
        Queen2 = new QueenChessComponent(new ChessboardPoint(7, 3), calculatePoint(7, 3), ChessColor.WHITE, clickController, CHESS_SIZE);
        Queen2.setVisible(true);
        putChessOnBoard(Queen2);

        King1 = new KingChessComponent(new ChessboardPoint(0, 4), calculatePoint(0, 4), ChessColor.BLACK, clickController, CHESS_SIZE);
        King1.setVisible(true);
        putChessOnBoard(King1);
        King2 = new KingChessComponent(new ChessboardPoint(7, 4), calculatePoint(7, 4), ChessColor.WHITE, clickController, CHESS_SIZE);
        King2.setVisible(true);
        putChessOnBoard(King2);

        Bishop1 = new BishopChessComponent(new ChessboardPoint(7, 2), calculatePoint(7, 2), ChessColor.WHITE, clickController, CHESS_SIZE);
        Bishop1.setVisible(true);
        putChessOnBoard(Bishop1);
        Bishop2 = new BishopChessComponent(new ChessboardPoint(7, 5), calculatePoint(7, 5), ChessColor.WHITE, clickController, CHESS_SIZE);
        Bishop2.setVisible(true);
        putChessOnBoard(Bishop2);
        Bishop3 = new BishopChessComponent(new ChessboardPoint(0, 2), calculatePoint(0, 2), ChessColor.BLACK, clickController, CHESS_SIZE);
        Bishop3.setVisible(true);
        putChessOnBoard(Bishop3);
        Bishop4 = new BishopChessComponent(new ChessboardPoint(0, 5), calculatePoint(0, 5), ChessColor.BLACK, clickController, CHESS_SIZE);
        Bishop4.setVisible(true);
        putChessOnBoard(Bishop4);

        Knight1 = new KnightChessComponent(new ChessboardPoint(7, 1), calculatePoint(7, 1), ChessColor.WHITE, clickController, CHESS_SIZE);
        Knight1.setVisible(true);
        putChessOnBoard(Knight1);
        Knight2 = new KnightChessComponent(new ChessboardPoint(7, 6), calculatePoint(7, 6), ChessColor.WHITE, clickController, CHESS_SIZE);
        Knight2.setVisible(true);
        putChessOnBoard(Knight2);
        Knight3 = new KnightChessComponent(new ChessboardPoint(0, 1), calculatePoint(0, 1), ChessColor.BLACK, clickController, CHESS_SIZE);
        Knight3.setVisible(true);
        putChessOnBoard(Knight3);
        Knight4 = new KnightChessComponent(new ChessboardPoint(0, 6), calculatePoint(0, 6), ChessColor.BLACK, clickController, CHESS_SIZE);
        Knight4.setVisible(true);
        putChessOnBoard(Knight4);

        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 8; k++) {
                ChessboardRecord[j][k] = new Record(j, k);
            }
        }

        // FIXME: Initialize chessboard for testing only.

    }

    public void ResetChessboard() {
        remove(Rook1);
        remove(Rook2);
        remove(Rook3);
        remove(Rook4);
        remove(Pawn1);
        remove(Pawn2);
        remove(Pawn3);
        remove(Pawn4);
        remove(Pawn5);
        remove(Pawn6);
        remove(Pawn7);
        remove(Pawn8);
        remove(Pawn9);
        remove(Pawn10);
        remove(Pawn11);
        remove(Pawn12);
        remove(Pawn13);
        remove(Pawn14);
        remove(Pawn15);
        remove(Pawn16);
        remove(Queen1);
        remove(Queen2);
        remove(King1);
        remove(King2);
        remove(Knight1);
        remove(Knight2);
        remove(Knight3);
        remove(Knight4);
        initiateEmptyChessboard();

        Rook1 = new RookChessComponent(new ChessboardPoint(0, 0), calculatePoint(0, 0), ChessColor.BLACK, clickController, CHESS_SIZE);
        Rook1.setVisible(true);
        putChessOnBoard(Rook1);
        Rook2 = new RookChessComponent(new ChessboardPoint(0, 7), calculatePoint(0, 7), ChessColor.BLACK, clickController, CHESS_SIZE);
        Rook2.setVisible(true);
        putChessOnBoard(Rook2);
        Rook3 = new RookChessComponent(new ChessboardPoint(7, 0), calculatePoint(7, 0), ChessColor.WHITE, clickController, CHESS_SIZE);
        Rook3.setVisible(true);
        putChessOnBoard(Rook3);
        Rook4 = new RookChessComponent(new ChessboardPoint(7, 7), calculatePoint(7, 7), ChessColor.WHITE, clickController, CHESS_SIZE);
        Rook4.setVisible(true);
        putChessOnBoard(Rook4);

        Pawn1 = new PawnChessComponent(new ChessboardPoint(1, 0), calculatePoint(1, 0), ChessColor.BLACK, clickController, CHESS_SIZE);
        Pawn1.setVisible(true);
        putChessOnBoard(Pawn1);
        Pawn2 = new PawnChessComponent(new ChessboardPoint(1, 1), calculatePoint(1, 1), ChessColor.BLACK, clickController, CHESS_SIZE);
        Pawn2.setVisible(true);
        putChessOnBoard(Pawn2);
        Pawn3 = new PawnChessComponent(new ChessboardPoint(1, 2), calculatePoint(1, 2), ChessColor.BLACK, clickController, CHESS_SIZE);
        Pawn3.setVisible(true);
        putChessOnBoard(Pawn3);
        Pawn4 = new PawnChessComponent(new ChessboardPoint(1, 3), calculatePoint(1, 3), ChessColor.BLACK, clickController, CHESS_SIZE);
        Pawn4.setVisible(true);
        putChessOnBoard(Pawn4);
        Pawn5 = new PawnChessComponent(new ChessboardPoint(1, 4), calculatePoint(1, 4), ChessColor.BLACK, clickController, CHESS_SIZE);
        Pawn5.setVisible(true);
        putChessOnBoard(Pawn5);
        Pawn6 = new PawnChessComponent(new ChessboardPoint(1, 5), calculatePoint(1, 5), ChessColor.BLACK, clickController, CHESS_SIZE);
        Pawn6.setVisible(true);
        putChessOnBoard(Pawn6);
        Pawn7 = new PawnChessComponent(new ChessboardPoint(1, 6), calculatePoint(1, 6), ChessColor.BLACK, clickController, CHESS_SIZE);
        Pawn7.setVisible(true);
        putChessOnBoard(Pawn7);
        Pawn8 = new PawnChessComponent(new ChessboardPoint(1, 7), calculatePoint(1, 7), ChessColor.BLACK, clickController, CHESS_SIZE);
        Pawn8.setVisible(true);
        putChessOnBoard(Pawn8);

        Pawn9 = new PawnChessComponent(new ChessboardPoint(6, 0), calculatePoint(6, 0), ChessColor.WHITE, clickController, CHESS_SIZE);
        Pawn9.setVisible(true);
        putChessOnBoard(Pawn9);
        Pawn10 = new PawnChessComponent(new ChessboardPoint(6, 1), calculatePoint(6, 1), ChessColor.WHITE, clickController, CHESS_SIZE);
        Pawn10.setVisible(true);
        putChessOnBoard(Pawn10);
        Pawn11 = new PawnChessComponent(new ChessboardPoint(6, 2), calculatePoint(6, 2), ChessColor.WHITE, clickController, CHESS_SIZE);
        Pawn11.setVisible(true);
        putChessOnBoard(Pawn11);
        Pawn12 = new PawnChessComponent(new ChessboardPoint(6, 3), calculatePoint(6, 3), ChessColor.WHITE, clickController, CHESS_SIZE);
        Pawn12.setVisible(true);
        putChessOnBoard(Pawn12);
        Pawn13 = new PawnChessComponent(new ChessboardPoint(6, 4), calculatePoint(6, 4), ChessColor.WHITE, clickController, CHESS_SIZE);
        Pawn13.setVisible(true);
        putChessOnBoard(Pawn13);
        Pawn14 = new PawnChessComponent(new ChessboardPoint(6, 5), calculatePoint(6, 5), ChessColor.WHITE, clickController, CHESS_SIZE);
        Pawn14.setVisible(true);
        putChessOnBoard(Pawn14);
        Pawn15 = new PawnChessComponent(new ChessboardPoint(6, 6), calculatePoint(6, 6), ChessColor.WHITE, clickController, CHESS_SIZE);
        Pawn15.setVisible(true);
        putChessOnBoard(Pawn15);
        Pawn16 = new PawnChessComponent(new ChessboardPoint(6, 7), calculatePoint(6, 7), ChessColor.WHITE, clickController, CHESS_SIZE);
        Pawn16.setVisible(true);
        putChessOnBoard(Pawn16);

        Queen1 = new QueenChessComponent(new ChessboardPoint(0, 3), calculatePoint(0, 3), ChessColor.BLACK, clickController, CHESS_SIZE);
        Queen1.setVisible(true);
        putChessOnBoard(Queen1);
        Queen2 = new QueenChessComponent(new ChessboardPoint(7, 3), calculatePoint(7, 3), ChessColor.WHITE, clickController, CHESS_SIZE);
        Queen2.setVisible(true);
        putChessOnBoard(Queen2);

        King1 = new KingChessComponent(new ChessboardPoint(0, 4), calculatePoint(0, 4), ChessColor.BLACK, clickController, CHESS_SIZE);
        King1.setVisible(true);
        putChessOnBoard(King1);
        King2 = new KingChessComponent(new ChessboardPoint(7, 4), calculatePoint(7, 4), ChessColor.WHITE, clickController, CHESS_SIZE);
        King2.setVisible(true);
        putChessOnBoard(King2);

        Bishop1 = new BishopChessComponent(new ChessboardPoint(7, 2), calculatePoint(7, 2), ChessColor.WHITE, clickController, CHESS_SIZE);
        Bishop1.setVisible(true);
        putChessOnBoard(Bishop1);
        Bishop2 = new BishopChessComponent(new ChessboardPoint(7, 5), calculatePoint(7, 5), ChessColor.WHITE, clickController, CHESS_SIZE);
        Bishop2.setVisible(true);
        putChessOnBoard(Bishop2);
        Bishop3 = new BishopChessComponent(new ChessboardPoint(0, 2), calculatePoint(0, 2), ChessColor.BLACK, clickController, CHESS_SIZE);
        Bishop3.setVisible(true);
        putChessOnBoard(Bishop3);
        Bishop4 = new BishopChessComponent(new ChessboardPoint(0, 5), calculatePoint(0, 5), ChessColor.BLACK, clickController, CHESS_SIZE);
        Bishop4.setVisible(true);
        putChessOnBoard(Bishop4);

        Knight1 = new KnightChessComponent(new ChessboardPoint(7, 1), calculatePoint(7, 1), ChessColor.WHITE, clickController, CHESS_SIZE);
        Knight1.setVisible(true);
        putChessOnBoard(Knight1);
        Knight2 = new KnightChessComponent(new ChessboardPoint(7, 6), calculatePoint(7, 6), ChessColor.WHITE, clickController, CHESS_SIZE);
        Knight2.setVisible(true);
        putChessOnBoard(Knight2);
        Knight3 = new KnightChessComponent(new ChessboardPoint(0, 1), calculatePoint(0, 1), ChessColor.BLACK, clickController, CHESS_SIZE);
        Knight3.setVisible(true);
        putChessOnBoard(Knight3);
        Knight4 = new KnightChessComponent(new ChessboardPoint(0, 6), calculatePoint(0, 6), ChessColor.BLACK, clickController, CHESS_SIZE);
        Knight4.setVisible(true);
        putChessOnBoard(Knight4);
        for (int j = 0; j < 8; j++) {
            for (int k = 0; k < 8; k++) {
                ChessboardRecord[j][k] = new Record(j, k);
            }
        }
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ChessColor getCurrentColor() {
        statusLabel.setText(Chessboard.currentColor.toString() + "'s round");
        return currentColor;
    }
    public ChessColor getCurrentColorPlus() {

        return currentColor;
    }

    public void setCurrentColor(ChessColor i) {
        currentColor = i;

    }

    public void putChessOnBoard(ChessComponent chessComponent) {
        int row = chessComponent.getChessboardPoint().getX(), col = chessComponent.getChessboardPoint().getY();

        if (chessComponents[row][col] != null) {
            remove(chessComponents[row][col]);
        }
        add(chessComponents[row][col] = chessComponent);
    }



    public void swapChessComponents(ChessComponent chess1, ChessComponent chess2) {
        if(!chess1.getChessColor().equals(currentColor)){return;}
        statusLabel.setText(Chessboard.currentColor.toString() + "'s round");
        // Note that chess1 has higher priority, 'destroys' chess2 if exists.
        int row1 = chess1.getChessboardPoint().getX(), col1 = chess1.getChessboardPoint().getY();
        int row2 = chess2.getChessboardPoint().getX(), col2 = chess2.getChessboardPoint().getY();
        Record ch1 = ChessboardRecord[row1][col1], ch2 = ChessboardRecord[row2][col2];
        ChessboardRecord[row2][col2].ChangeRecord(row1, col1, row2, col2, ch1.getRecordName(), ch1.getRecordChesscolor(), ch2.getRecordName(), ch2.getRecordChesscolor());
        ChessboardRecord[row1][col1].ChangeRecord(row1, col1, row1, col1, "None", ChessColor.WHITE, "None", ChessColor.WHITE);
        //22.5.2 by Winnie 记录棋盘
        Record ch = ChessboardRecord[row2][col2];
        go.add(ch);
        System.out.println("The " + ch.getRecordChesscolor() + " " + ch.getRecordName() + " at [" + ch.getFromx() + ", " + ch.getFromy() + "] is moved to [" + ch.getRecordX() + ", "
                + ch.getRecordY() + "] , eat " + ch.getRecordoutChesscolor() + " " + ch.getOut());
        //22.5.2 by Winnie 记录走棋

        if (!(chess2 instanceof EmptySlotComponent)) {
            remove(chess2);
            add(chess2 = new EmptySlotComponent(chess2.getChessboardPoint(), chess2.getLocation(), clickController, CHESS_SIZE));
        }
        chess1.swapLocation(chess2);
        row1 = chess1.getChessboardPoint().getX();
        col1 = chess1.getChessboardPoint().getY();
        chessComponents[row1][col1] = chess1;
        row2 = chess2.getChessboardPoint().getX();
        col2 = chess2.getChessboardPoint().getY();
        chessComponents[row2][col2] = chess2;
        int cnt = 0;
        chess1.repaint();
        chess2.repaint();


    }

    public void initiateEmptyChessboard() {
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                putChessOnBoard(new EmptySlotComponent(new ChessboardPoint(i, j), calculatePoint(i, j), clickController, CHESS_SIZE));
            }
        }
    }

    public void swapColor() {
        currentColor = currentColor == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
        statusLabel.setText(Chessboard.currentColor.toString() + "'s round");

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    }


    private Point calculatePoint(int row, int col) {
        return new Point(col * CHESS_SIZE, row * CHESS_SIZE);
    }

    public void loadGame(List<String> chessData) {
        chessData.forEach(System.out::println);
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
            g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);

        }
    }


}
