package myapplication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javazoom.jl.player.*;
import java.io.*;

public class MyMenuBar extends JMenuBar {
    
    public MyMenuBar() {
        
        setBackground(Color.WHITE);
        
        JMenu mn_File = new JMenu("File");
        
        JMenu mn_Open = new JMenu("Open");
        JMenuItem mn_Open_Music = new JMenuItem("Music");
        mn_Open_Music.setActionCommand("Open_Music");
        JMenuItem mn_Open_Excel = new JMenuItem("Excel");
        mn_Open_Excel.setActionCommand("Open_Excel");
        
        mn_Open.add(mn_Open_Music);
        mn_Open.add(mn_Open_Excel);
        
        mn_File.add(mn_Open);
        
        MenuItemListener menuItemListener = new MenuItemListener();
        
        mn_Open_Music.addActionListener(menuItemListener);
        mn_Open_Excel.addActionListener(menuItemListener);
        
        add(mn_File);
    }
}
