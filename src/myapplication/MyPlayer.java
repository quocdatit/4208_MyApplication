package myapplication;

import jaco.mp3.player.MP3Player;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class MyPlayer extends JFrame{
    
    final JButton btn_Play = new JButton("Play");
    final JButton btn_Stop = new JButton("Stop");
    MP3Player player;
    
    public MyPlayer(String pathFileMp3){
        this.setLayout(new GridLayout(1,2));
        this.setSize(300,120);
        
        btn_Stop.setEnabled(false);
        btn_Play.setEnabled(true);
        this.player = new MP3Player(new File(pathFileMp3));
        
        this.add(btn_Play);
        this.add(btn_Stop);
        this.setTitle("Nghe nhạc");
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    
        setListener();
    }
    
    private void setListener() {
        btn_Play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_Stop.setEnabled(true);
                btn_Play.setEnabled(false);
                playAudio();
            }
        });
        
        btn_Stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_Stop.setEnabled(false);
                btn_Play.setEnabled(true);
                stopAudio();
            }
        });
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                stopAudio();
            }
        });
    }
    
    private void playAudio(){
        this.player.play();
    }
    
    private void stopAudio(){
        this.player.stop();
    }
}
