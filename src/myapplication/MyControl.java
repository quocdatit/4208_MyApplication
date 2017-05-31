package myapplication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyControl extends JFrame {
    
    public MyControl() {
        
        MyMenuBar menuBar = new MyMenuBar();
        setJMenuBar(menuBar);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Chương trình chính");
        setExtendedState(MyControl.this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
}
