package softwaredesign;

import javax.swing.*;
import java.awt.*;

abstract class MinigameScreen extends Screen {
    protected JButton returnButton, playAgainButton;

    protected void addMinigameName(String name){
        JLabel minigameName = new JLabel(name);
        minigameName.setHorizontalAlignment(JLabel.CENTER);
        minigameName.setVerticalAlignment(JLabel.CENTER);

        JPanel minigameNamePanel = new JPanel();
        minigameNamePanel.setBounds(0, 100, AppConstants.WIDTH, 50);
        minigameNamePanel.add(minigameName);

        this.add(minigameNamePanel);
    }

    protected abstract void addMinigamePanel();

    protected void addPlayReturnButtons() {
        playAgainButton = new JButton();
        addButton(playAgainButton, 160, 30, 110, 100, new Color(0xBEE0F8));
        playAgainButton.setName("playAgainButton");
        playAgainButton.setText("Play Again");
        playAgainButton.setEnabled(false);

        returnButton = new JButton();
        addButton(returnButton, 290, 30, 110, 100, new Color(0xBEE0F8));
        returnButton.setName("returnButton");
        returnButton.setText("Main Screen");

        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(null);
        actionsPanel.setBounds(0, 600, AppConstants.WIDTH, 200);
        actionsPanel.add(playAgainButton);
        actionsPanel.add(returnButton);

        this.add(actionsPanel);
    }

}
