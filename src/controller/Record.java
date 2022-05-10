//22.5.2 by Winnie 用于记录行棋
package controller;
import model.ChessColor;
import java.awt.*;
public class Record {
    private String name;
    private String out="None";
    private ChessColor chesscolor;
    private ChessColor outchesscolor=ChessColor.WHITE;
    private int x;
    private int y;
    private int fromx;
    private int fromy;
    public Record(int x, int y){
        if(x==1){name="Pawn";chesscolor=ChessColor.BLACK;this.x=x;this.y=y;}
        if(x==6){name="Pawn";chesscolor=ChessColor.WHITE;this.x=x;this.y=y;}
        if((x==0&&y==0)||(x==0&&y==7)){name="Rook";chesscolor=ChessColor.BLACK;this.x=x;this.y=y;}
        if((x==7&&y==0)||(x==7&&y==7)){name="Rook";chesscolor=ChessColor.WHITE;this.x=x;this.y=y;}
        if((x==0&&y==1)||(x==0&&y==6)){name="Knight";chesscolor=ChessColor.BLACK;this.x=x;this.y=y;}
        if((x==7&&y==1)||(x==7&&y==6)){name="Knight";chesscolor=ChessColor.WHITE;this.x=x;this.y=y;}
        if ((x == 0 && y == 2) || (x == 0 && y == 5)) {name="Bishop";chesscolor=ChessColor.BLACK;this.x=x;this.y=y;}
        if ((x == 7 && y == 2) || (x == 7 && y == 5)) {name="Bishop";chesscolor=ChessColor.WHITE;this.x=x;this.y=y;}
        if (x == 0 && y == 3){name="Queen";chesscolor=ChessColor.BLACK;this.x=x;this.y=y;}
        if (x == 7 && y == 3){name="Queen";chesscolor=ChessColor.WHITE;this.x=x;this.y=y;}
        if (x == 7 && y == 4){name="King";chesscolor=ChessColor.WHITE;this.x=x;this.y=y;}
        if(x>=2&&x<=5){name="None";chesscolor=ChessColor.WHITE;this.x=x;this.y=y;}
    }
    public void ChangeRecord(int fromx,int fromy,int x, int y,String name,ChessColor chesscolor,String out, ChessColor outchesscolor){
        this.fromx=fromx;
        this.fromy=fromy;
        this.x=x;
        this.y=y;
        this.name=name;
        this.chesscolor=chesscolor;
        this.out=out;
        this.outchesscolor=outchesscolor;
    }
    public int getRecordX() {
        return x;
    }

    public int getRecordY() {
        return y;
    }

    public String getRecordName(){
        return name;
    }
    public ChessColor getRecordChesscolor(){
        return chesscolor;
    }
    public String getOut(){
        return out;
    }
    public ChessColor getRecordoutChesscolor(){
        return outchesscolor;
    }
    public int getFromx(){
        return fromx;
    }
    public int getFromy(){
        return fromy;
    }
    public void restart(){

    }
}
