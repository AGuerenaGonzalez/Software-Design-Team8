package softwaredesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetActionScreen extends Screen {
    private Animal pet = null;
    private JButton playButton, feedButton, sleepButton, cleanButton;

    PetActionScreen(Animal pet) {
        this.pet = pet;
        this.setLayout(null);
        addTitle();
        addVitals();
        addPetImg();
        addBehaviorButtons();
        addPetName();
    }

    private void addVitals() {

        JLabel hungerIcon = new JLabel();
        ImageIcon hungerIconImg = scaleImage(new ImageIcon("src/main/java/softwaredesign/IMGs/vitalIMG/hunger.png"), 24, 24);
        hungerIcon.setIcon(hungerIconImg);
        hungerIcon.setBounds(30, 0,24, 24);
        Vital hungerBar = pet.getHungerVital();
        hungerBar.setBounds(60,0,180,25);
        hungerBar.setStringPainted(true);

        JLabel energyIcon = new JLabel();
        ImageIcon energyIconImg = scaleImage(new ImageIcon("src/main/java/softwaredesign/IMGs/vitalIMG/energy.png"), 24, 24);
        energyIcon.setIcon(energyIconImg);
        energyIcon.setBounds(280, 0,24, 24);
        Vital energyBar = pet.getEnergyVital();
        energyBar.setBounds(310,0,180,25);
        energyBar.setStringPainted(true);

        JLabel moodIcon = new JLabel();
        ImageIcon moodIconImg = scaleImage(new ImageIcon("src/main/java/softwaredesign/IMGs/vitalIMG/mood.png"), 24, 24);
        moodIcon.setIcon(moodIconImg);
        moodIcon.setBounds(30, 40,24, 24);
        Vital moodBar = pet.getMoodVital();
        moodBar.setBounds(85,40,180,20);
        moodBar.setStringPainted(true);

        JLabel cleanIcon = new JLabel();
        ImageIcon cleanIconImg = scaleImage(new ImageIcon("src/main/java/softwaredesign/IMGs/vitalIMG/cleanliness.png"), 24, 24);
        cleanIcon.setIcon(cleanIconImg);
        cleanIcon.setBounds(280, 40,24, 24);
        Vital cleanBar = pet.getCleanVital();
        cleanBar.setBounds(310,40,180,25);
        cleanBar.setStringPainted(true);

        JPanel vitalsPanel = new JPanel();
        vitalsPanel.setBounds(0,100,AppConstants.WIDTH, 65);
        vitalsPanel.setLayout(null);
        vitalsPanel.add(hungerBar);
        vitalsPanel.add(hungerIcon);
        vitalsPanel.add(cleanBar);
        vitalsPanel.add(cleanIcon);
        vitalsPanel.add(moodBar);
        vitalsPanel.add(moodIcon);
        vitalsPanel.add(energyBar);
        vitalsPanel.add(energyIcon);

        this.add(vitalsPanel);
    }

    private void addPetName() {
        JLabel name = new JLabel(Tamagotchi.getPet().name);
        name.setFont(new Font("Calibri", Font.PLAIN, 30));
        JPanel petNamePanel = new JPanel();
        petNamePanel.setBounds(0,165, AppConstants.WIDTH, 35);
        petNamePanel.add(name);

        this.add(petNamePanel);
    }

    private void addTitle(){
        JLabel title = new JLabel();
        ImageIcon titleImg = scaleImage(new ImageIcon("src/main/java/softwaredesign/IMGs/tittleGroup8.png"), 400, 71);
        title.setIcon(titleImg);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);

        JPanel tittlePanel = new JPanel();
        tittlePanel.setBounds(0,0,AppConstants.WIDTH, 100);
        tittlePanel.add(title);

        this.add(tittlePanel);
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

                Thread sleepingThread = new Thread( new Runnable() {
                    public void run() {
                        toggleBehaviors(false, Color.lightGray);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex) {

                        }
                        toggleBehaviors(true, new Color(0xBEE0F8));
                    }
                });

                sleepingThread.start();

                break;
            case "cleanButton":
                System.out.println("Cleaning");
                pet.clean();
                break;
        }
    }

    private void toggleBehaviors(boolean isClickable, Color color) {
        playButton.setBackground(color);
        feedButton.setBackground(color);
        sleepButton.setBackground(color);
        cleanButton.setBackground(color);
        this.repaint();

        playButton.setEnabled(isClickable);
        feedButton.setEnabled(isClickable);
        sleepButton.setEnabled(isClickable);
        cleanButton.setEnabled(isClickable);
    }
}
