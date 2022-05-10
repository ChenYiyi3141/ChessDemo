package controller;

import view.Chessboard;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GameController {
    private Chessboard chessboard;

    public GameController(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public List<String> loadGameFromFile(String path) {
//        try {
//            List<String> chessData = Files.readAllLines(Path.of(path));
//            chessboard.loadGame(chessData);
//            return chessData;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }
    public static void saveGameFromFile(String path) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(path));
            out.write("Happy Labor Day");
            out.close();
            System.out.println("success");
        } catch (IOException e) {
            System.out.println("fail");
        }
    }

}
