import javax.swing.*;
import java.awt.*;

public class NewWindow extends JFrame {

    NewWindow() {

        this.setTitle("Dashboard");
        this.setSize(450, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JLabel label = new JLabel("Welcome to your Dashboard");
        label.setHorizontalAlignment(JLabel.CENTER);

        this.add(label);

        this.setVisible(true);
    }
}
