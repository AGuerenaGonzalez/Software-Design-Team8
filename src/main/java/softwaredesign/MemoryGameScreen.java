package softwaredesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MemoryGameScreen extends MinigameScreen {
    private Animal pet;
    JButton button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9;

    public MemoryGameScreen(Animal pet) {
        this.pet = pet;
        this.setLayout(null);
        addBanner();
        addMinigameName();
        addMiniGamePanel();
    }

    void addMinigameName() {
        JLabel minigameName = new JLabel("MemoryGame");

        minigameName.setHorizontalAlignment(JLabel.CENTER);
        minigameName.setVerticalAlignment(JLabel.CENTER);

        JPanel minigameNamePanel = new JPanel();
        minigameNamePanel.setBounds(0, 100, AppConstants.WIDTH, 50);
        minigameNamePanel.add(minigameName);

        this.add(minigameNamePanel);
    }

    private void addMiniGamePanel() {
        JLabel description = new JLabel("Sequence to remember: ");
        description.setBounds(0, 0, AppConstants.WIDTH, 50);
        button_1 = new JButton("1");
        button_2 = new JButton("2");
        button_3 = new JButton("3");
        button_4 = new JButton("4");
        button_5 = new JButton("5");
        button_6 = new JButton("6");
        button_7 = new JButton("7");
        button_8 = new JButton("8");
        button_9 = new JButton("9");
        addButton(button_1, 100, 50, 100, 100, new Color(0xBEE0F8));
        addButton(button_2, 225, 50, 100, 100, new Color(0xBEE0F8));
        addButton(button_3, 350, 50, 100, 100, new Color(0xBEE0F8));
        addButton(button_4, 100, 175, 100, 100, new Color(0xBEE0F8));
        addButton(button_5, 225, 175, 100, 100, new Color(0xBEE0F8));
        addButton(button_6, 350, 175, 100, 100, new Color(0xBEE0F8));
        addButton(button_7, 100, 300, 100, 100, new Color(0xBEE0F8));
        addButton(button_8, 225, 300, 100, 100, new Color(0xBEE0F8));
        addButton(button_9, 350, 300, 100, 100, new Color(0xBEE0F8));
        JPanel miniGamePanel = new JPanel();
        miniGamePanel.setBounds(0, 150, AppConstants.WIDTH, 400);
        miniGamePanel.setLayout(null);
        miniGamePanel.add(description);
        miniGamePanel.add(button_1);
        miniGamePanel.add(button_2);
        miniGamePanel.add(button_3);
        miniGamePanel.add(button_4);
        miniGamePanel.add(button_5);
        miniGamePanel.add(button_6);
        miniGamePanel.add(button_7);
        miniGamePanel.add(button_8);
        miniGamePanel.add(button_9);
        this.add(miniGamePanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
