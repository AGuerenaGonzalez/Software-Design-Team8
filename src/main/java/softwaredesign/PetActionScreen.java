package softwaredesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetActionScreen extends Screen {
    private Animal pet = null;

    PetActionScreen(Animal pet) {
        this.pet = pet;
        this.setLayout(null);
        addBanner();
        addVitals();
        addPetImg();
        addBehaviorButtons();
    }

    private void addVitals() {

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
                String[] gameOptions = {"GuessTheNumber", "MemoryGame", "Cancel"};
                int gameChoice = JOptionPane.showOptionDialog(null, "Choose a minigame", "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, gameOptions, 0);
                if (gameChoice == 0) {
                    Tamagotchi.switchScreen("GuessNumberScreen");
                }
                if (gameChoice == 1) {
                    Tamagotchi.switchScreen("MemoryGameScreen");
                }
                break;
            case "feedButton":
                System.out.println("Feeding");
                ImageIcon dogFood = scaleImage(new ImageIcon("src/main/java/softwaredesign/IMGs/foodImgs/dogFood.png"), 45, 45);
                ImageIcon catFood = scaleImage(new ImageIcon("src/main/java/softwaredesign/IMGs/foodImgs/catFood.png"), 45, 45);
                ImageIcon hamsterFood = scaleImage(new ImageIcon("src/main/java/softwaredesign/IMGs/foodImgs/hamsterFood.png"), 45, 45);

                ImageIcon[] foodOptions = {dogFood, catFood, hamsterFood};
                int foodChoice = JOptionPane.showOptionDialog(null, "Choose a food to feed " + pet.getName(), "", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, foodOptions, 0);
                switch (foodChoice) {
                    case 0:
                        pet.feed("dogFood");
                        break;
                    case 1:
                        pet.feed("catFood");
                        break;
                    case 2:
                        pet.feed("hamsterFood");
                        break;
                }
                break;
            case "sleepButton":
                System.out.println("Sleeping");
                pet.sleep();
                break;
            case "cleanButton":
                System.out.println("Cleaning");
                pet.clean();
                break;
        }
    }
}
