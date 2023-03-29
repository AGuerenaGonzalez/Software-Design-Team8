package softwaredesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ref.PhantomReference;

public class PetActionScreen extends Screen {
    private Animal pet = null;
    private JButton playButton, feedButton, sleepButton, cleanButton;
    private JLabel hungerIncreasePrompt, energyIncreasePrompt, moodIncreasePrompt, cleanIncreasePrompt;

    PetActionScreen(Animal pet) {
        this.pet = pet;
        this.setLayout(null);
        addBanner();
        addVitals();
        addPetImg();
        addBehaviorButtons();
        addPetName();
    }
    private void addVitals() {
        JLabel hungerIcon = new JLabel(new ImageIcon("src/main/java/softwaredesign/IMGs/vitalIMG/hunger.png"));
        Vital hungerBar = pet.getHungerVital();
        hungerIncreasePrompt = new JLabel();

        JLabel energyIcon = new JLabel(new ImageIcon("src/main/java/softwaredesign/IMGs/vitalIMG/energy.png"));
        Vital energyBar = pet.getEnergyVital();
        energyIncreasePrompt = new JLabel();

        JLabel moodIcon = new JLabel(new ImageIcon("src/main/java/softwaredesign/IMGs/vitalIMG/mood.png"));
        Vital moodBar = pet.getMoodVital();
        moodIncreasePrompt = new JLabel();

        JLabel cleanIcon = new JLabel(new ImageIcon("src/main/java/softwaredesign/IMGs/vitalIMG/cleanliness.png"));
        Vital cleanBar = pet.getCleanVital();
        cleanIncreasePrompt = new JLabel();

        placeVital(30, 0, hungerBar, hungerIncreasePrompt, hungerIcon);
        placeVital(280, 0, energyBar, energyIncreasePrompt, energyIcon);
        placeVital(30, 40, moodBar, moodIncreasePrompt, moodIcon);
        placeVital(280, 40, cleanBar, cleanIncreasePrompt, cleanIcon);

        JPanel vitalsPanel = new JPanel();
        vitalsPanel.setBounds(0,135,AppConstants.WIDTH, 65);
        vitalsPanel.setLayout(null);
        vitalsPanel.add(hungerBar);
        vitalsPanel.add(hungerIcon);
        vitalsPanel.add(cleanBar);
        vitalsPanel.add(cleanIcon);
        vitalsPanel.add(moodBar);
        vitalsPanel.add(moodIcon);
        vitalsPanel.add(energyBar);
        vitalsPanel.add(energyIcon);
        vitalsPanel.add(hungerIncreasePrompt);
        vitalsPanel.add(energyIncreasePrompt);
        vitalsPanel.add(moodIncreasePrompt);
        vitalsPanel.add(cleanIncreasePrompt);

        this.add(vitalsPanel);
    }

    private void addPetName() {
        JLabel name = new JLabel(pet.getName());
        name.setFont(new Font("Calibri", Font.PLAIN, 30));
        JPanel petNamePanel = new JPanel();
        petNamePanel.setBounds(0,100, AppConstants.WIDTH, 35);
        petNamePanel.add(name);

        this.add(petNamePanel);
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

    private void promptIncreaseValue(JLabel vital, int value) {
        vital.setText("+" + value);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        vital.setText("");
                    }
                },
                2000
        );
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
                    System.out.println("test");
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
                promptIncreaseValue(hungerIncreasePrompt, 10);
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
                promptIncreaseValue(energyIncreasePrompt, 10);
                break;
            case "cleanButton":
                System.out.println("Cleaning");
                pet.clean();
                promptIncreaseValue(cleanIncreasePrompt, 10);
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
        cleanButton.setEnabled(isClickable);
    }
}
