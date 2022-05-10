package view;

class Base {
    public void show() {

        System.out.println("Base::show() called");

    }
}
class Derived extends Base {
    public void show() {

        System.out.println("Derived::show() called");

    }
}
public class Quiz {
    public static void main(String[] args) {
        Base b = new Derived();
        b.show();
    }
}
