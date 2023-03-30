package softwaredesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class GuessNumberScreen extends MinigameScreen {

    private JTextField numberField;
    private final int CORRECTNUM = new Random().nextInt(10);
    private Animal pet;
    private JButton guessButton;

    GuessNumberScreen(Animal pet) {
        this.pet = pet;
        this.setLayout(null);
        addBanner();
        addMinigameName("GuessTheNumber");
        addMinigamePanel();
        addPlayReturnButtons();
    }

    protected void addMinigamePanel() {
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
                if (guess == CORRECTNUM) {
                    answer = "Correct!";
                    pet.played(true);
                    playAgainButton.setEnabled(true);
                    guessButton.setEnabled(false);

                } else if (guess > CORRECTNUM) {
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
