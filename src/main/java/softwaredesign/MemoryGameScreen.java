package softwaredesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MemoryGameScreen extends MinigameScreen {
    private Animal pet;
    private Integer[] randomArray = {1, 2, 3, 4, 5, 6};
    private Integer[] guessedArray = {0, 0, 0, 0, 0, 0};
    private int counter = 0;
    JButton button_1, button_2, button_3, button_4, button_5, button_6;
    JButton description;

    public MemoryGameScreen(Animal pet) {
        this.pet = pet;
        List<Integer> intList = Arrays.asList(randomArray);
        Collections.shuffle(intList);
        intList.toArray(randomArray);
        counter = 0;
        this.setLayout(null);
        addBanner();
        addMinigameName();
        addMiniGamePanel();
        addBehaviorButtons();
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
        description = new JButton("Display sequence to remember");
        addButton(description, 125,0,300,50, new Color(0xBEE0F8));
        description.setName("sequenceButton");
        button_1 = new JButton("1");
        button_2 = new JButton("2");
        button_3 = new JButton("3");
        button_4 = new JButton("4");
        button_5 = new JButton("5");
        button_6 = new JButton("6");
        button_1.setName("1");
        button_2.setName("2");
        button_3.setName("3");
        button_4.setName("4");
        button_5.setName("5");
        button_6.setName("6");
        button_1.setEnabled(false);
        button_2.setEnabled(false);
        button_3.setEnabled(false);
        button_4.setEnabled(false);
        button_5.setEnabled(false);
        button_6.setEnabled(false);
        addButton(button_1, 100, 125, 100, 100, new Color(0xBEE0F8));
        addButton(button_2, 225, 125, 100, 100, new Color(0xBEE0F8));
        addButton(button_3, 350, 125, 100, 100, new Color(0xBEE0F8));
        addButton(button_4, 100, 250, 100, 100, new Color(0xBEE0F8));
        addButton(button_5, 225, 250, 100, 100, new Color(0xBEE0F8));
        addButton(button_6, 350, 250, 100, 100, new Color(0xBEE0F8));
        JPanel miniGamePanel = new JPanel();
        miniGamePanel.setBounds(0, 150, AppConstants.WIDTH, 450);
        miniGamePanel.setLayout(null);
        miniGamePanel.add(description);
        miniGamePanel.add(button_1);
        miniGamePanel.add(button_2);
        miniGamePanel.add(button_3);
        miniGamePanel.add(button_4);
        miniGamePanel.add(button_5);
        miniGamePanel.add(button_6);
        this.add(miniGamePanel);
    }
    private void displaySequence() {
        description.setText(Arrays.toString(randomArray));
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        description.setText("");
                        button_1.setEnabled(true);
                        button_2.setEnabled(true);
                        button_3.setEnabled(true);
                        button_4.setEnabled(true);
                        button_5.setEnabled(true);
                        button_6.setEnabled(true);
                        description.setEnabled(false);
                    }
                },
                3000
        );
    }
    private void handleNumberButton(int number) {
        guessedArray[counter] = number;
        counter++;
        if(counter == 6) compareArrays();
    }
    private void compareArrays() {
        if(Arrays.equals(guessedArray, randomArray)) {
            pet.played(true);
            JOptionPane.showMessageDialog(null, "Correct!", "GuessTheNumber", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            pet.played(false);
            JOptionPane.showMessageDialog(null, "Incorrect - correct sequence: " + Arrays.toString(randomArray), "GuessTheNumber", JOptionPane.INFORMATION_MESSAGE);
        }
        button_1.setEnabled(false);
        button_2.setEnabled(false);
        button_3.setEnabled(false);
        button_4.setEnabled(false);
        button_5.setEnabled(false);
        button_6.setEnabled(false);
        playAgainButton.setEnabled(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonName = button.getName();
        switch (buttonName) {
            case "sequenceButton":
                displaySequence();
                break;
            case "1":
                handleNumberButton(1);
                break;
            case "2":
                handleNumberButton(2);
                break;
            case "3":
                handleNumberButton(3);
                break;
            case "4":
                handleNumberButton(4);
                break;
            case "5":
                handleNumberButton(5);
                break;
            case "6":
                handleNumberButton(6);
                break;
            case "returnButton":
                Tamagotchi.switchScreen("PetActionScreen");
                break;
            case "playAgainButton":
                Tamagotchi.switchScreen("MemoryGameScreen");
                break;
        }
    }
}
