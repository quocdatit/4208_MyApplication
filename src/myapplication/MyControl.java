package myapplication;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import static myapplication.MyControl.txt_PathToFile;

public class MyControl extends JFrame {
    
    static JTextField txt_PathToFile;
            
    public MyControl() {
        
        MyMenuBar menuBar = new MyMenuBar();
        setJMenuBar(menuBar);
        
        //
        this.setLayout(new GridLayout(2,1));
        JPanel pn_PathToFile = new JPanel();
        JLabel lb_PathToFile = new JLabel("Đường dẫn file: ");
        txt_PathToFile = new JTextField();
        txt_PathToFile.setPreferredSize(new Dimension(750, 24));
        txt_PathToFile.setEnabled(false);
        pn_PathToFile.add(lb_PathToFile);
        pn_PathToFile.add(txt_PathToFile);
        
        this.add(pn_PathToFile);
        
        //
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Chương trình chính");
        setExtendedState(MyControl.this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setVisible(true);
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
        }
    }
 }
