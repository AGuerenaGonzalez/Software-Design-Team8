package softwaredesign;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Tamagotchi extends JFrame {
    private static final CardLayout CL = new CardLayout();
    private static final JPanel PANELSWITCHER = new JPanel();
    private static Animal pet = null;

    public Tamagotchi(){
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

    public static void main (String[] args) throws IOException {
        System.out.println("Welcome to Software Design");

        Tamagotchi appFrame = new Tamagotchi();

    }
    /*
    TODO:
    Change buttonName to screenName
     */

    public static void switchScreen(String buttonName) {
        switch(buttonName){
            case "playButton":
                break;
        }
    }
    public static void switchScreen(String buttonName, Animal p){
        switch(buttonName){
            case "confirmButton":
                pet = p;
                PetActionScreen petAction = new PetActionScreen();
                PANELSWITCHER.add(petAction, "petActionScreen");
                CL.show(PANELSWITCHER, "petActionScreen");

                break;
        }
    }
    public static Animal getPet(){
        return pet;
    }
}
