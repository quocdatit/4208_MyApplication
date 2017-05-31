package myapplication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyLogin extends JFrame {

    JLabel lb_Title;
    JLabel lb_Username;
    JLabel lb_Password;
    JTextField txt_Username;
    JPasswordField pwd_Password;
    JButton btn_Login;
    JButton btn_Cancel;
    
    String correct_username = "admin";
    String correct_password = "admin";
    
    public MyLogin() {
        // Panel: Title
        lb_Title = new JLabel("ĐĂNG NHẬP VÀO HỆ THỐNG");
        
        JPanel pn_Title = new JPanel();
        pn_Title.add(lb_Title);
        
        // Panel: Username
        lb_Username = new JLabel("Tài khoản");
        txt_Username = new JTextField();
        txt_Username.setPreferredSize(new Dimension(220, 24));
        
        JPanel pn_Username = new JPanel();
        pn_Username.add(lb_Username);
        pn_Username.add(txt_Username);
        
        // Panel: Password
        lb_Password = new JLabel("Mật  khẩu");
        pwd_Password = new JPasswordField();
        pwd_Password.setPreferredSize(new Dimension(220, 24));
        
        JPanel pn_Password = new JPanel();
        pn_Password.add(lb_Password);
        pn_Password.add(pwd_Password);
        
        // Panel: Button
        btn_Login = new JButton("Đăng nhập");
        btn_Cancel = new JButton("Hủy bỏ");
        
        JPanel pn_Button = new JPanel();
        pn_Button.add(btn_Login);
        pn_Button.add(btn_Cancel);
        
        // Main Panel
        JPanel mainPn = new JPanel();
        mainPn.setLayout(new GridLayout(4,1));
        mainPn.setSize(320, 180);
        
        mainPn.add(pn_Title);
        mainPn.add(pn_Username);
        mainPn.add(pn_Password);
        mainPn.add(pn_Button);
        
        // My Frame
        add(mainPn);
        setMinimumSize(mainPn.getSize());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(523, 270);
        setTitle("Đăng nhập");
        
        // Event
        setListener();
        setVisible(true);
    }
    
    private void setListener() {
        btn_Login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txt_Username.getText().equals("") || new String(pwd_Password.getPassword()).equals("")) {
                    // Tạo 1 Dialog báo lỗi
                    JOptionPane.showMessageDialog(MyLogin.this, "Tài khoản và Mật khẩu không được để trống.", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (txt_Username.getText().equals(correct_username) && new String(pwd_Password.getPassword()).equals(correct_password)) {
                    // Tạo 1 Dialog báo thành công
                    JOptionPane.showMessageDialog(MyLogin.this, "Đăng nhập thành công.", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                    // Do something
                    new MyControl(); // Chạy frame Chương trình chính
                    MyLogin.this.dispose(); // Destroy frame Đăng nhập
                } else {
                    // Tạo 1 Dialog báo lỗi
                    JOptionPane.showMessageDialog(MyLogin.this, "Tài khoản hoặc Mật khẩu không đúng.", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        });
        
        btn_Cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}