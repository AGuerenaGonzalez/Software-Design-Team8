package softwaredesign;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MemoryGameScreen extends MinigameScreen{

    public MemoryGameScreen(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addTitle();
        addMinigameName();
    }
    void addMinigameName(){
        JLabel minigameName = new JLabel("MemoryGame");
//        ImageIcon titleImg = scaleImage(new ImageIcon("src/main/java/softwaredesign/tittleGroup8.png"), 400, 71);
//        title.setIcon(titleImg);
        minigameName.setHorizontalAlignment(JLabel.CENTER);
        minigameName.setVerticalAlignment(JLabel.CENTER);

        JPanel minigameNamePanel = new JPanel();
        minigameNamePanel.setBounds(0,100,AppConstants.WIDTH, 100);
        minigameNamePanel.add(minigameName);

        this.add(minigameNamePanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
