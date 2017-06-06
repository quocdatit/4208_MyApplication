package myapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.MalformedURLException;
import javax.sound.sampled.*;
import javax.media.Manager;
import javax.media.Player;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.CannotRealizeException;
import javax.media.NoPlayerException;

public class MusicPlayer extends JFrame{
    
    String fileMp3;
    File soundFile;
    AudioFormat audioFormat;
    AudioInputStream audioInputStream;
    SourceDataLine sourceDataLine;
    boolean stopPlayback = false;
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
        this.setVisible(true);
        
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
                    Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoPlayerException ex) {
                    Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (CannotRealizeException ex) {
                    Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btn_Stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopPlayback = true;
            }
        });
    }
    
    private void playAudio() throws MalformedURLException, IOException, NoPlayerException, CannotRealizeException {
        URL media = new URL(this.fileMp3);
        Player mediaPlayer = Manager.createRealizedPlayer(media);
        mediaPlayer.start();
    }
}
