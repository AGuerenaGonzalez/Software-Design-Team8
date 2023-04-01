package softwaredesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MemoryGameScreen extends MinigameScreen {
    private Animal pet;
    private Integer[] randomArray = {1, 2, 3, 4, 5};
    private Integer[] guessedArray = {0, 0, 0, 0, 0};
    private int guessDigitCounter;
    private JButton[] buttons = new JButton[5];
    private JButton seqDisplay = new JButton("Click to show sequence");

    public MemoryGameScreen(Animal pet) {
        this.pet = pet;
        List<Integer> intList = Arrays.asList(randomArray);
        Collections.shuffle(intList);
        intList.toArray(randomArray);
        this.setLayout(null);
        addBanner();
        addMinigameName("MemoryGame");
        addMinigamePanel();
        addPlayReturnButtons();
    }

    protected void addMinigamePanel() {
        JPanel miniGamePanel = new JPanel();

        addButton(seqDisplay, 125,0,300,50, new Color(0xBEE0F8));
        seqDisplay.setName("sequenceButton");
        for(int i = 0; i < buttons.length; i ++){
            String num = Integer.toString(i + 1);

            buttons[i] = new JButton(num);
            buttons[i].setName(num);
            buttons[i].setEnabled(false);
            miniGamePanel.add(buttons[i]);
        }
        addButton(buttons[0], 100, 125, 100, 100, new Color(0xBEE0F8));
        addButton(buttons[1], 225, 125, 100, 100, new Color(0xBEE0F8));
        addButton(buttons[2], 350, 125, 100, 100, new Color(0xBEE0F8));
        addButton(buttons[3], 162, 250, 100, 100, new Color(0xBEE0F8));
        addButton(buttons[4], 287, 250, 100, 100, new Color(0xBEE0F8));
        miniGamePanel.setBounds(0, 150, AppConstants.WIDTH, 450);
        miniGamePanel.setLayout(null);
        miniGamePanel.add(seqDisplay);
//        miniGamePanel.add(button1);
//        miniGamePanel.add(button2);
//        miniGamePanel.add(button3);
//        miniGamePanel.add(button4);
//        miniGamePanel.add(button5);
        this.add(miniGamePanel);
    }
    private void displaySequence() {
        seqDisplay.setText(Arrays.toString(randomArray));
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        seqDisplay.setText("");
                        toggleButtons(true);
                        seqDisplay.setEnabled(false);
                    }
                },
                3000
        );
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
        toggleButtons(false);
        playAgainButton.setEnabled(true);
    }
    private void toggleButtons(boolean isClickable){
        for(int i = 0; i < buttons.length; i++){
            buttons[i].setEnabled(isClickable);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonName = button.getName();
        switch (buttonName) {
            case "sequenceButton":
                displaySequence();
                break;
            case "returnButton":
                Tamagotchi.switchScreen("PetActionScreen");
                break;
            case "playAgainButton":
                Tamagotchi.switchScreen("MemoryGameScreen");
                break;
            default:
                guessedArray[guessDigitCounter] = Integer.parseInt(buttonName);
                guessDigitCounter++;
                seqDisplay.setText(seqDisplay.getText() + " " + buttonName);
                if(guessDigitCounter == 5) compareArrays();
                break;
        }
    }
}
