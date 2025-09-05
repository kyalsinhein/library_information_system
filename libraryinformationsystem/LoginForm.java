package libraryinformationsystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class LoginForm extends JFrame {

    private JPanel contentPane;
    private JTextField txtUserName;
    private JPasswordField txtPassword;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LoginForm frame = new LoginForm();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LoginForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.YELLOW);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblLogin = new JLabel("Login Form");
        lblLogin.setFont(new Font("Tekton Pro Ext", Font.BOLD, 20));
        lblLogin.setBounds(142, 11, 135, 25);
        contentPane.add(lblLogin);

        JLabel lblUserName = new JLabel("Username:");
        lblUserName.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
        lblUserName.setBounds(118, 66, 83, 14);
        contentPane.add(lblUserName);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
        lblPassword.setBounds(118, 91, 83, 25);
        contentPane.add(lblPassword);

        txtUserName = new JTextField();
        txtUserName.setBounds(206, 65, 96, 20);
        contentPane.add(txtUserName);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(206, 95, 96, 20);
        contentPane.add(txtPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setBounds(118, 138, 89, 23);
        contentPane.add(btnLogin);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBackground(Color.WHITE);
        btnCancel.setBounds(213, 138, 89, 23);
        contentPane.add(btnCancel);

        // Login button action
        btnLogin.addActionListener(e -> {
            String username = txtUserName.getText();
            String password = new String(txtPassword.getPassword());

            if (username.equals("admin") && password.equals("123")) {
                JOptionPane.showMessageDialog(null, "Login successful!");
                MainForm main = new MainForm();
                main.setVisible(true);
                dispose();
            } else if (username.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter username and password!");
            } else if (username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter username!");
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter password!");
            } else {
                JOptionPane.showMessageDialog(null, "Login failed!");
            }
        });

        // Cancel button action
        btnCancel.addActionListener(e -> {
            txtUserName.setText("");
            txtPassword.setText("");
        });
    }
}
