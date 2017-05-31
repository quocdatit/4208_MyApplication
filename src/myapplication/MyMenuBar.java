package myapplication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyMenuBar extends JMenuBar {
    
    public MyMenuBar() {
        
        setBackground(Color.WHITE);
        
        JMenu Menu_1 = new JMenu("Menu 1"); // 1
        
        //
        JMenu Menu_1_1 = new JMenu("Menu 1.1"); // 1.1
        
        JMenuItem Menu_1_1_1 = new JMenuItem("Menu 1.1.1"); // 1.1.1
        JMenuItem Menu_1_1_2 = new JMenuItem("Menu 1.1.2"); // 1.1.2
        
        Menu_1_1.add(Menu_1_1_1);
        Menu_1_1.add(Menu_1_1_2);
        
        //
        JMenu Menu_1_2 = new JMenu("Menu 1.2"); // 1.2
        
        JMenuItem Menu_1_2_1 = new JMenuItem("Menu 1.2.1"); // 1.2.1
        JMenuItem Menu_1_2_2 = new JMenuItem("Menu 1.2.2"); // 1.2.2
        
        Menu_1_2.add(Menu_1_2_1);
        Menu_1_2.add(Menu_1_2_2);
        
        //
        Menu_1.add(Menu_1_1);
        Menu_1.add(Menu_1_2);
        
        //
        add(Menu_1);
    }
}
