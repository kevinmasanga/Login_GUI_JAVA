
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    // Declare components
    JTextField username;
    JPasswordField password;

    JButton login;
    JButton register;

    MyFrame() {

        // Frame settings
        this.setTitle("Login Form");
        this.setSize(450, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username label
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Username:"), gbc);

        // Username field
        username = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(username, gbc);

        // Password label
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Password:"), gbc);

        // Password field
        password = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(password, gbc);

        // Login button
        login = new JButton("Login");
        login.addActionListener(this);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(login, gbc);

        // Register button
        register = new JButton("Register");
        register.addActionListener(this);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(register, gbc);

        // Add panel to frame
        this.add(panel);

        // Display frame
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {

            String user = username.getText().trim();
            String pass = new String(password.getPassword());

            if (user.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Username required",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

            } else if (pass.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Password required",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

            } else {

                UserDAO dao = new UserDAO();

                if (dao.login(user, pass)) {

                    JOptionPane.showMessageDialog(this,
                            "Login successful!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    this.dispose();
                    new NewWindow();

                } else {

                    JOptionPane.showMessageDialog(this,
                            "Invalid username or password!",
                            "Login Failed",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        } else if (e.getSource() == register) {

            String user = username.getText().trim();
            String pass = new String(password.getPassword());

            if (user.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Username required",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

            } else if (pass.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Password required",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

            } else {

                UserDAO dao = new UserDAO();

                if (dao.register(user, pass)) {

                    JOptionPane.showMessageDialog(this,
                            "Registration successful!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    username.setText("");
                    password.setText("");

                } else {

                    JOptionPane.showMessageDialog(this,
                            "Registration failed. Username may already exist.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

}