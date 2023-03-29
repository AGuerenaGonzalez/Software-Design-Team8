package softwaredesign;

import javax.swing.*;
import java.awt.*;

abstract class MinigameScreen extends Screen {
    protected JButton returnButton, playAgainButton;
    MinigameScreen() {
    }

    abstract void addMinigameName();

    protected void addBehaviorButtons() {
        playAgainButton = new JButton();
        addButton(playAgainButton, 160, 30, 100, 100, new Color(0xBEE0F8));
        playAgainButton.setName("playAgainButton");
        playAgainButton.setText("Play Again");
        playAgainButton.setEnabled(false);

        returnButton = new JButton();
        addButton(returnButton, 290, 30, 100, 100, new Color(0xBEE0F8));
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
