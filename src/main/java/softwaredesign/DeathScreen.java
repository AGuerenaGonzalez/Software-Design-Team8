package softwaredesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DeathScreen extends Screen {
    private static DeathScreen instance;
    private Animal pet;
    private JButton quitButton;

    public DeathScreen(Animal pet) {
        this.pet = pet;
        this.setLayout(null);
        addBanner();
        addDeathScreenPanel();
    }

    public static DeathScreen getInstance(Animal pet) {
        if (instance == null)
            instance = new DeathScreen(pet);
        return instance;
    }

    private void addDeathScreenPanel() {
        JLabel youLostPrompt = new JLabel("You lost!");
        youLostPrompt.setFont(new Font("Calibri", Font.BOLD, 50));
        youLostPrompt.setBounds(125, 0, 300, 70);
        youLostPrompt.setHorizontalAlignment(JLabel.CENTER);
        youLostPrompt.setVerticalAlignment(JLabel.CENTER);

        JLabel petLabel = new JLabel();
        ImageIcon petIMG = scaleImage(pet.getAnimalImg(), 250, 250);
        petLabel.setIcon(petIMG);
        petLabel.setBounds(0, 70, AppConstants.WIDTH, 250);
        petLabel.setHorizontalAlignment(JLabel.CENTER);
        petLabel.setVerticalAlignment(JLabel.CENTER);

        long secondsLifetime = pet.getTimeAlive() / 1000000000;
        JLabel lifeTimePrompt = new JLabel(pet.getName() + " survived for " + Math.round(secondsLifetime / 60) + " minutes");
        lifeTimePrompt.setFont(new Font("Calibri", Font.PLAIN, 32));
        lifeTimePrompt.setBounds(0, 320, AppConstants.WIDTH, 45);
        lifeTimePrompt.setHorizontalAlignment(JLabel.CENTER);
        lifeTimePrompt.setVerticalAlignment(JLabel.CENTER);

        JLabel message = new JLabel("Don't worry, losing is a part of the game! Remember, your Tamagotchi needs your love and attention no matter what. " +
                "Take some time to reflect on what went wrong and how you can improve for next time. With practice and care, you'll be able to raise a happy and " +
                "healthy Tamagotchi in no time. Keep trying and don't give up!");
        message.setFont(new Font("Calibri", Font.PLAIN, 18));
        message.setBounds(50, 365, 450, 155);
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setVerticalAlignment(JLabel.TOP);

        quitButton = new JButton();
        addButton(quitButton, 175, 550, 200, 100, new Color(0xBEE0F8));
        quitButton.setName("quitButton");
        quitButton.setText("Quit");

        JPanel deathScreenPanel = new JPanel();
        deathScreenPanel.setLayout(null);
        deathScreenPanel.setBounds(0, 100, AppConstants.WIDTH, 700);
        deathScreenPanel.add(youLostPrompt);
        deathScreenPanel.add(petLabel);
        deathScreenPanel.add(lifeTimePrompt);
        deathScreenPanel.add(message);
        deathScreenPanel.add(quitButton);

        this.add(deathScreenPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonName = button.getName();

        switch (buttonName) {
            case "quitButton":
                System.exit(0);
                break;
        }
    }
}
