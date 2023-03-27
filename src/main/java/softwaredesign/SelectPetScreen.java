package softwaredesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SelectPetScreen extends Screen{
    private String currAnimal = null, currColor = null;
    private JTextField nameField;
    public SelectPetScreen(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addBanner();
        addTitle();
        addPetOptions();
        addNamePrompt();
        addConfirmButton();
    }

    private void addConfirmButton() {
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setName("confirmButton");
        addButton(confirmButton, 200,0,100,50, new Color(0xBEE0F8));

        JPanel confirmPanel = new JPanel();
        confirmPanel.setLayout(null);
        confirmPanel.add(confirmButton);

        this.add(confirmPanel);

    }

    private void addNamePrompt() {
        nameField = new JTextField(10);

        JLabel nameLabel = new JLabel("Enter name here:");

        JPanel namePanel = new JPanel();
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        this.add(namePanel);
    }

    private void addPetOptions() {
        JLabel animalLabel = new JLabel("Animal:");
        ButtonGroup petChoices = new ButtonGroup();
        JRadioButton dog = new JRadioButton("Dog"), cat = new JRadioButton("Cat"), hamster = new JRadioButton("Hamster");
        dog.addActionListener(this);
        dog.setName("dogButton");
        cat.addActionListener(this);
        cat.setName("catButton");
        hamster.addActionListener(this);
        hamster.setName("hamsterButton");
        petChoices.add(dog);
        petChoices.add(cat);
        petChoices.add(hamster);

        JLabel colorLabel = new JLabel("Color:");
        ButtonGroup colorChoices = new ButtonGroup();
        JRadioButton white = new JRadioButton("White"), black = new JRadioButton("Black"), brown = new JRadioButton("Brown");
        white.addActionListener(this);
        white.setName("whiteButton");
        black.addActionListener(this);
        black.setName("blackButton");
        brown.addActionListener(this);
        brown.setName("brownButton");
        colorChoices.add(white);
        colorChoices.add(black);
        colorChoices.add(brown);


        JPanel radioPanel = new JPanel();
        radioPanel.setBounds(0,200,AppConstants.WIDTH, 400);
        radioPanel.setLayout(new GridLayout(4,2));
        radioPanel.add(animalLabel);
        radioPanel.add(colorLabel);
        radioPanel.add(dog);
        radioPanel.add(white);
        radioPanel.add(cat);
        radioPanel.add(black);
        radioPanel.add(hamster);
        radioPanel.add(brown);

        this.add(radioPanel);
    }

    private void addTitle() {
        JLabel title = new JLabel("Create a pet!");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);

        JPanel tittlePanel = new JPanel();
        tittlePanel.setBounds(0,0,AppConstants.WIDTH, 100);
        tittlePanel.add(title);

        this.add(tittlePanel);

    }

    /*
    TODO:
    Add exceptions
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton button;
        String buttonName;
        if(e.getSource() instanceof JButton)
            button = (JButton) e.getSource();
        else if(e.getSource() instanceof JRadioButton)
            button = (JRadioButton) e.getSource();
        else{
            System.out.println("Action performed error.");
            return;
        }

        buttonName = button.getName();

        switch(buttonName){
            case "dogButton":
                currAnimal = "DOG";
                break;
            case "catButton":
                currAnimal = "CAT";
                break;
            case "hamsterButton":
                currAnimal = "HAMSTER";
                break;
            case "whiteButton":
                currColor = "WHITE";
                break;
            case "blackButton":
                currColor = "BLACK";
                break;
            case "brownButton":
                currColor = "BROWN";
                break;
            case "confirmButton":
                String currName = nameField.getText();
                boolean validSelection = !currName.isEmpty() && currAnimal != null && currColor != null;
                if(validSelection) {
                    Tamagotchi.setPet(createPet(currAnimal, currColor, currName));
                    Tamagotchi.switchScreen(buttonName);
                }
                break;
        }
    }

    /*
    TODO:
    Add exceptions
     */
    private Animal createPet(String animal, String color, String name) {
        AnimalFactory animalFactory = new AnimalFactory();
        return animalFactory.getAnimal(animal, name, color);
    }
}
