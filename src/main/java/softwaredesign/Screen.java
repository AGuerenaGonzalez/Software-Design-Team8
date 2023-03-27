package softwaredesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

abstract class Screen extends JPanel implements ActionListener {
     protected ImageIcon scaleImage(ImageIcon icon, int width, int height){
         Image img = icon.getImage();
         return new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_SMOOTH));
     }

     /*
     TODO:
     remove this method or change it to set or something
      */
    protected void addButton(JButton button, int xPos, int yPos, int width, int height, Color backgroundColor){
        button.setBounds(xPos,yPos,width,height);
        button.addActionListener(this);
        button.setFocusable(false);
        button.setBackground(backgroundColor);
        button.setBorder(BorderFactory.createCompoundBorder());
        button.setFont(new Font("Calibri", Font.PLAIN, 20));
        button.setVerticalAlignment(JLabel.CENTER);
        button.setHorizontalAlignment(JLabel.CENTER);
    }
}
