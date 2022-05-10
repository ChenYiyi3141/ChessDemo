package controller;

import java.awt.*;

import java.applet.*;

public class MouseEnterExit extends Applet {

    public boolean mouseEnter(Event evt, int x, int y)
    {
        System.out.println("mouseEnter");
        return(true);
    }

    public boolean mouseExit(Event evt, int x, int y)
    {
        System.out.println("mouseExit");
        return(true);
    }
}
