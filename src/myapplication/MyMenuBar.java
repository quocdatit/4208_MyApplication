package myapplication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javazoom.jl.player.*;
import java.io.*;
import static myapplication.MyControl.txt_PathToFile;

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

class MenuItemListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {            
        switch (e.getActionCommand()) {
            case "Open_Music":
                showChooser();
                break;
            case "Open_Excel":
                showChooser();
                break;
        }
    }
    
    void showChooser() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            txt_PathToFile.setText(selectedFile.getAbsolutePath());
            if(this.getExtension(selectedFile.getAbsolutePath()).equals("xls")){
                try{
                    new ReadExcel(selectedFile.getAbsolutePath());
                } catch (Exception e) {
                    System.out.print(e);
                }
            }
            if(this.getExtension(selectedFile.getAbsolutePath()).equals("mp3")){
                try{
//                    JOptionPane.showMessageDialog(null, "Chức năng nghe mp3 chưa hoàn thiện. Hãy chọn file .wav để chạy tình nghe nhạc!", "Lỗi khởi chạy MP3", JOptionPane.INFORMATION_MESSAGE);
//                    return;
                    new MyPlayer(selectedFile.getAbsolutePath());
                } catch (Exception e) {
                    System.out.print(e);
                }
            }
            if(this.getExtension(selectedFile.getAbsolutePath()).equals("wav")){
                try{
                    new MusicPlayer(selectedFile.getAbsolutePath());
                } catch (Exception e) {
                    System.out.print(e);
                }
            }
        }
    }
    
    String getExtension(String fileName){
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i+1);
        }
        return extension;
    }
 }