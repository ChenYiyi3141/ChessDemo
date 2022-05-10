package controller;

public class Player implements Comparable<Player>{
    private String userName;
    //    private String password;
    private int highestScore;

    public Player(String name, int highestScore){
        this.highestScore = highestScore;
        this.userName = name;
    }

    public void setHighestScore(int score){
        highestScore = Math.max(highestScore, score);
    }

    public int getHighestScore(){ return highestScore; }
    public String getUserName(){
        return userName;
    }

    @Override
    public int compareTo(Player p) {
        return p.getHighestScore() - this.getHighestScore();
    }

}