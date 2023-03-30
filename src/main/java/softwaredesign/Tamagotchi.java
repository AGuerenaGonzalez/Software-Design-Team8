package softwaredesign;

import javax.swing.*;
import java.awt.*;

public class Tamagotchi extends JFrame {
    private static final CardLayout CL = new CardLayout();
    private static final JPanel PANELSWITCHER = new JPanel();
    private static Animal pet;

    private Tamagotchi() {
        this.setTitle("Tamagotchi");
        this.setSize(AppConstants.WIDTH, AppConstants.HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PANELSWITCHER.setLayout(CL);

        SelectPetScreen selectPet = new SelectPetScreen();
        PANELSWITCHER.add(selectPet, "selectPetScreen");
        CL.show(PANELSWITCHER, "selectPetScreen");

        this.add(PANELSWITCHER);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        System.out.println("Welcome to Software Design");

        new Tamagotchi();

    }

    public static void switchScreen(String screenName) {
        switch (screenName) {
            case "GuessNumberScreen":
                GuessNumberScreen guessNumber = new GuessNumberScreen(pet);
                PANELSWITCHER.add(guessNumber, "GuessNumberScreen");
                break;
            case "MemoryGameScreen":
                MemoryGameScreen memoryGame = new MemoryGameScreen(pet);
                PANELSWITCHER.add(memoryGame, "MemoryGameScreen");
                break;
            case "PetActionScreen":
                PetActionScreen petAction = new PetActionScreen(pet);
                PANELSWITCHER.add(petAction, "PetActionScreen");
                break;
            case "DeathScreen":
                DeathScreen deathScreen = new DeathScreen(pet);
                PANELSWITCHER.add(deathScreen, "DeathScreen");
                break;
        }
        CL.show(PANELSWITCHER, screenName);
    }

    public static void setPet(Animal petInst) {
        pet = petInst;
    }
}
