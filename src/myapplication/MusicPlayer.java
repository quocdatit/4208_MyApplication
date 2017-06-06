package myapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.media.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MusicPlayer extends JFrame{
    
    String fileMp3;
    Player p;
    final JButton btn_Play = new JButton("Play");
    final JButton btn_Stop = new JButton("Stop");
    
    public MusicPlayer(String pathFileMp3){
        this.setLayout(new GridLayout(1,2));
        this.setSize(300,120);
        this.fileMp3 = pathFileMp3;
        
        btn_Stop.setEnabled(false);
        btn_Play.setEnabled(true);
    
        this.add(btn_Play);
        this.add(btn_Stop);
        this.setTitle("Nghe nhạc");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setListener();
    }
    
    private void setListener() {
        btn_Play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_Stop.setEnabled(true);
                btn_Play.setEnabled(false);
                try {
                    playAudio();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Chức năng nghe mp3 chưa hoàn thiện. Hãy chọn file .wav để chạy tình nghe nhạc!", "Lỗi khởi chạy MP3", JOptionPane.INFORMATION_MESSAGE);
                    return;
                } catch (NoPlayerException ex) {
                    JOptionPane.showMessageDialog(null, "Chức năng nghe mp3 chưa hoàn thiện. Hãy chọn file .wav để chạy tình nghe nhạc!", "Lỗi khởi chạy MP3", JOptionPane.INFORMATION_MESSAGE);
                    return;
                } catch (CannotRealizeException ex) {
                    JOptionPane.showMessageDialog(null, "Chức năng nghe mp3 chưa hoàn thiện. Hãy chọn file .wav để chạy tình nghe nhạc!", "Lỗi khởi chạy MP3", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
        });
        
        btn_Stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_Stop.setEnabled(false);
                btn_Play.setEnabled(true);
                try {
                    stopAudio();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Chức năng nghe mp3 chưa hoàn thiện. Hãy chọn file .wav để chạy tình nghe nhạc!", "Lỗi khởi chạy MP3", JOptionPane.INFORMATION_MESSAGE);
                    return;
                } catch (NoPlayerException ex) {
                    JOptionPane.showMessageDialog(null, "Chức năng nghe mp3 chưa hoàn thiện. Hãy chọn file .wav để chạy tình nghe nhạc!", "Lỗi khởi chạy MP3", JOptionPane.INFORMATION_MESSAGE);
                    return;
                } catch (CannotRealizeException ex) {
                    JOptionPane.showMessageDialog(null, "Chức năng nghe mp3 chưa hoàn thiện. Hãy chọn file .wav để chạy tình nghe nhạc!", "Lỗi khởi chạy MP3", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
        });
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    stopAudio();
                } catch (IOException ex) {
                    Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoPlayerException ex) {
                    Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (CannotRealizeException ex) {
                    Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void playAudio() throws MalformedURLException, IOException, NoPlayerException, CannotRealizeException {
        File f = new File(this.fileMp3);
        this.p = Manager.createRealizedPlayer(f.toURI().toURL());
        this.p.start();
    }
    
    private void stopAudio() throws MalformedURLException, IOException, NoPlayerException, CannotRealizeException {
        this.p.stop();
    }
}
