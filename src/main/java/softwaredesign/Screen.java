package softwaredesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

abstract class Screen extends JPanel implements ActionListener {
    protected ImageIcon scaleImage(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        return new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    protected void addBanner() {
        JLabel title = new JLabel();
        title.setBounds(0,0,AppConstants.WIDTH, 100);
        ImageIcon titleImg = scaleImage(new ImageIcon("src/main/java/softwaredesign/IMGs/tittleGroup8.png"), 400, 71);
        title.setIcon(titleImg);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);

        JPanel tittlePanel = new JPanel();
        tittlePanel.setBounds(0, 0, AppConstants.WIDTH, 100);
        tittlePanel.setLayout(null);
        tittlePanel.add(title);

        this.add(tittlePanel);
    }

    protected void addButton(JButton button, int xPos, int yPos, int width, int height, Color backgroundColor) {
        button.setBounds(xPos, yPos, width, height);
        button.addActionListener(this);
        button.setFocusable(false);
        button.setBackground(backgroundColor);
        button.setBorder(BorderFactory.createCompoundBorder());
        button.setFont(new Font("Calibri", Font.PLAIN, 20));
        button.setVerticalAlignment(JLabel.CENTER);
        button.setHorizontalAlignment(JLabel.CENTER);
    }

}
