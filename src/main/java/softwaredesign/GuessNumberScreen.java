package softwaredesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class GuessNumberScreen extends MinigameScreen {

    private JTextField numberField;
    private final Random random = new Random();
    private final int correctNumber = random.nextInt(100);
    private Animal pet = null;
    private JButton guessButton;

    GuessNumberScreen(Animal pet) {
        this.pet = pet;
        this.setLayout(null);
        addBanner();
        addMinigameName();
        addMinigamePanel();
        addBehaviorButtons();
        System.out.println(correctNumber);
    }

    void addMinigameName() {
        JLabel minigameName = new JLabel("GuessTheNumber");
        minigameName.setHorizontalAlignment(JLabel.CENTER);
        minigameName.setVerticalAlignment(JLabel.CENTER);

        JPanel minigameNamePanel = new JPanel();
        minigameNamePanel.setBounds(0, 100, AppConstants.WIDTH, 100);
        minigameNamePanel.add(minigameName);

        this.add(minigameNamePanel);
    }

    private void addMinigamePanel() {
        numberField = new JTextField(10);
        JLabel prompt = new JLabel("Enter number to guess here:");
        guessButton = new JButton();
        addButton(guessButton, 100, 300, 50, 50, new Color(0xBEE0F8));
        guessButton.setText("Guess!");
        guessButton.setName("guessName");

        JPanel minigamePanel = new JPanel();
        minigamePanel.setBounds(0, 200, AppConstants.WIDTH, 100);
        minigamePanel.add(prompt);
        minigamePanel.add(numberField);
        minigamePanel.add(guessButton);

        this.add(minigamePanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonName = button.getName();
        switch (buttonName) {
            case "guessName":
                int guess = Integer.parseInt(numberField.getText());
                String answer;
                if (guess == correctNumber) {
                    answer = "Correct!";
                    pet.played(true);
                    playAgainButton.setEnabled(true);
                    guessButton.setEnabled(false);

                } else if (guess > correctNumber) {
                    answer = "Lower";
                } else {
                    answer = "Higher";
                }
                JOptionPane.showMessageDialog(null, answer, "GuessTheNumber", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "returnButton":
                Tamagotchi.switchScreen("PetActionScreen");
                break;
            case "playAgainButton":
                Tamagotchi.switchScreen("GuessNumberScreen");
                break;
        }
    }
}
