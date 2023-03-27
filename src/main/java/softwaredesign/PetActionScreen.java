package softwaredesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class PetActionScreen extends Screen {
    int CHANGETHISSSSSS = 4;

    PetActionScreen() {
        this.setLayout(null);
        addBanner();
        addVitals();
        addPetImg();
        addBehaviorButtons();
    }

    private void addVitals() {
        Animal pet = Tamagotchi.getPet();

        Vital hungerBar = pet.getHungerVital();
        hungerBar.setBounds(85, 0, 180, 20);
        hungerBar.setStringPainted(true);

        Vital energyBar = pet.getEnergyVital();
        energyBar.setBounds(285, 0, 180, 20);
        energyBar.setStringPainted(true);

        Vital moodBar = pet.getMoodVital();
        moodBar.setBounds(85, 40, 180, 20);
        moodBar.setStringPainted(true);

        Vital cleanBar = pet.getCleanVital();
        cleanBar.setBounds(285, 40, 180, 20);
        cleanBar.setStringPainted(true);

        JPanel vitalsPanel = new JPanel();
        vitalsPanel.setBounds(0, 100, AppConstants.WIDTH, 100);
        vitalsPanel.setLayout(null);
        vitalsPanel.add(hungerBar);
        vitalsPanel.add(cleanBar);
        vitalsPanel.add(moodBar);
        vitalsPanel.add(energyBar);

        this.add(vitalsPanel);
    }

    private void addPetImg() {
        Animal pet = Tamagotchi.getPet();
        JLabel petLabel = new JLabel();
        ImageIcon petIMG = scaleImage(pet.getAnimalImg(), 450, 450);
        petLabel.setIcon(petIMG);

        JPanel petPanel = new JPanel();
        petPanel.setBounds(0, 200, AppConstants.WIDTH, 400);
        petPanel.add(petLabel);

        this.add(petPanel);
    }

    private void addBehaviorButtons() {
        JButton playButton, feedButton, sleepButton, cleanButton;

        playButton = new JButton();
        addButton(playButton, 30, 30, 100, 100, new Color(0xBEE0F8));
        playButton.setName("playButton");
        playButton.setText("Play");

        feedButton = new JButton();
        addButton(feedButton, 160, 30, 100, 100, new Color(0xBEE0F8));
        feedButton.setName("feedButton");
        feedButton.setText("Feed");

        sleepButton = new JButton();
        addButton(sleepButton, 290, 30, 100, 100, new Color(0xBEE0F8));
        sleepButton.setName("sleepButton");
        sleepButton.setText("Sleep");

        cleanButton = new JButton();
        addButton(cleanButton, 420, 30, 100, 100, new Color(0xBEE0F8));
        cleanButton.setName("cleanButton");
        cleanButton.setText("Clean");

        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(null);
        actionsPanel.setBounds(0, 600, AppConstants.WIDTH, 200);
        actionsPanel.add(playButton);
        actionsPanel.add(feedButton);
        actionsPanel.add(sleepButton);
        actionsPanel.add(cleanButton);

        this.add(actionsPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonName = button.getName();
        switch (buttonName) {
            case "playButton":

                System.out.println("Playing");
                String[] responses = {"GuessTheNumber", "MemoryGame", "Cancel"};
                int answer = JOptionPane.showOptionDialog(null, "Choose a minigame", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, responses, 0);
                if (answer == 0) {
                    Tamagotchi.switchScreen("guessNumberButton");
                }
                if (answer == 1) {
                    Tamagotchi.switchScreen("memoryGameButton");
                }
                break;
            case "feedButton":
                System.out.println("Feeding");
                break;
            case "sleepButton":
                System.out.println("Sleeping");
                break;
            case "cleanButton":
                System.out.println("Cleaning");
                break;
        }
    }
}
