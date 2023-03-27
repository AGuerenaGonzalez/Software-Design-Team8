package softwaredesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class GuessNumberScreen extends MinigameScreen{

    private JTextField numberField;
    private Random random = new Random();
    private int correctNumber = random.nextInt(100);
    GuessNumberScreen(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addBanner();
        addMinigameName();
        addMinigamePanel();
        addBehaviorButtons();
    }

    void addMinigameName(){
        JLabel minigameName = new JLabel("GuessTheNumber");
//        ImageIcon titleImg = scaleImage(new ImageIcon("src/main/java/softwaredesign/tittleGroup8.png"), 400, 71);
//        title.setIcon(titleImg);
        minigameName.setHorizontalAlignment(JLabel.CENTER);
        minigameName.setVerticalAlignment(JLabel.CENTER);

        JPanel minigameNamePanel = new JPanel();
        minigameNamePanel.setBounds(0,100,AppConstants.WIDTH, 100);
        minigameNamePanel.add(minigameName);

        this.add(minigameNamePanel);
    }

    private void addMinigamePanel(){
        numberField = new JTextField(10);
        JLabel prompt = new JLabel("Enter number to guess here:");
        JButton guessButton = new JButton();
        addButton(guessButton,100, 300, 50, 50, new Color(0xBEE0F8));
        guessButton.setText("Guess!");
        guessButton.setName("guessName");

        JPanel minigamePanel = new JPanel();
        minigamePanel.setBounds(0,200,AppConstants.WIDTH, 100);
        minigamePanel.add(prompt);
        minigamePanel.add(numberField);
        minigamePanel.add(guessButton);

        this.add(minigamePanel);
    }

    private void addBehaviorButtons(){
        JButton playAgainButton, returnButton;

        playAgainButton = new JButton();
        addButton(playAgainButton, 160, 30, 100, 100, new Color(0xBEE0F8));
        playAgainButton.setName("playAgainButton");
        playAgainButton.setText("Play Again");

        returnButton = new JButton();
        addButton(returnButton, 290, 30, 100, 100, new Color(0xBEE0F8));
        returnButton.setName("returnButton");
        returnButton.setText("Main Screen");

        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(null);
        actionsPanel.setBounds(0,600,AppConstants.WIDTH, 200);
        actionsPanel.add(playAgainButton);
        actionsPanel.add(returnButton);

        this.add(actionsPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonName = button.getName();
        switch(buttonName){
            case "guessName":
                int guess = Integer.parseInt(numberField.getText());
                String answer;
                if(guess == correctNumber){
                    answer = "Correct!";
                }
                else if(guess > correctNumber) {
                    answer = "Lower";
                }
                else{
                    answer = "Higher";
                }
                JOptionPane.showMessageDialog(null, answer, "GuessTheNumber", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "returnButton":
                Tamagotchi.switchScreen("returnButton");
        }
    }
}
