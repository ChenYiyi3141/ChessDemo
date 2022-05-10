package view;

class One{
    int x;
    public One(int x){
        this.x = x;
    }
}
public class Test{
    public static void main(String[] args){
        One one = new One(1);
        System.out.println(one.x);
    }
}
