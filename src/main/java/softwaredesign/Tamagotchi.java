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

        switchScreen("selectpetscreen");

        this.add(PANELSWITCHER);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        System.out.println("Welcome to Software Design");

        new Tamagotchi();

    }

    public static void switchScreen(String screenName) {
        screenName = screenName.toLowerCase();
        switch (screenName) {
            case "selectpetscreen":
                PANELSWITCHER.add(SelectPetScreen.getInstance(), screenName);
                break;
            case "guessnumberscreen":
                PANELSWITCHER.add(new GuessNumberScreen(pet), screenName);
                break;
            case "memorygamescreen":
                PANELSWITCHER.add(new MemoryGameScreen(pet), screenName);
                break;
            case "petactionscreen":
                PANELSWITCHER.add(PetActionScreen.getInstance(pet), screenName);
                break;
            case "deathscreen":
                PANELSWITCHER.add(DeathScreen.getInstance(pet), screenName);
                break;
        }
        CL.show(PANELSWITCHER, screenName);
    }

    public static void setPet(Animal petInst) {
        pet = petInst;
    }
}
