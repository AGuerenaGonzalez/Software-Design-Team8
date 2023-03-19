package softwaredesign;

import javax.swing.*;

abstract class MinigameScreen extends Screen{
    MinigameScreen() {
        this.setLayout(null);
        addTitle();
    }

    public void addTitle(){
        JLabel title = new JLabel();
        ImageIcon titleImg = scaleImage(new ImageIcon("src/main/java/softwaredesign/tittleGroup8.png"), 400, 71);
        title.setIcon(titleImg);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);

        JPanel tittlePanel = new JPanel();
        tittlePanel.setBounds(0,0,AppConstants.WIDTH, 100);
        tittlePanel.add(title);

        this.add(tittlePanel);
    }
}
