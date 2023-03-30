package softwaredesign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SelectPetScreen extends Screen {
    private String currAnimal, currColor;
    private ImageIcon currPetImg;
    private JLabel currPetLabel;
    private JTextField nameField;
    public SelectPetScreen(){
        this.setLayout(null);
        addBanner();
        addPetOptions();
        addNamePrompt();
        addConfirmButton();
        addPetImgPanel();
    }
    private void addPetOptions() {
        JLabel prompt = new JLabel("Create a pet!");
        prompt.setHorizontalAlignment(JLabel.CENTER);
        prompt.setVerticalAlignment(JLabel.CENTER);
        prompt.setFont(new Font("Calibri", Font.BOLD, 40));
        prompt.setBounds(0,0,AppConstants.WIDTH, 100);

        JPanel promptPanel = new JPanel();
        promptPanel.setBounds(0,100,AppConstants.WIDTH, 100);
        promptPanel.setLayout(null);
        promptPanel.add(prompt);
        this.add(promptPanel);

        JLabel animalLabel = new JLabel("Animal:");
        animalLabel.setBounds(0,0,AppConstants.WIDTH/2, 50);
        animalLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
        animalLabel.setHorizontalAlignment(JLabel.CENTER);
        animalLabel.setVerticalAlignment(JLabel.CENTER);
        ButtonGroup petChoices = new ButtonGroup();
        JRadioButton dog = new JRadioButton("Dog"), cat = new JRadioButton("Cat"), hamster = new JRadioButton("Hamster");
        dog.addActionListener(this);
        dog.setName("dogButton");
        cat.addActionListener(this);
        cat.setName("catButton");
        hamster.addActionListener(this);
        hamster.setName("hamsterButton");
        dog.setBounds(100,50,100,30);
        cat.setBounds(100,80,100,30);
        hamster.setBounds(100,110,100,30);
        petChoices.add(dog);
        petChoices.add(cat);
        petChoices.add(hamster);

        JLabel colorLabel = new JLabel("Color:");
        colorLabel.setBounds(AppConstants.WIDTH/2,0,AppConstants.WIDTH/2, 50);
        colorLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
        colorLabel.setHorizontalAlignment(JLabel.CENTER);
        colorLabel.setVerticalAlignment(JLabel.CENTER);
        ButtonGroup colorChoices = new ButtonGroup();
        JRadioButton white = new JRadioButton("White"), black = new JRadioButton("Black"), brown = new JRadioButton("Brown");
        white.addActionListener(this);
        white.setName("whiteButton");
        black.addActionListener(this);
        black.setName("blackButton");
        brown.addActionListener(this);
        brown.setName("brownButton");
        white.setBounds(385,50,100,30);
        black.setBounds(385,80,100,30);
        brown.setBounds(385,110,100,30);
        colorChoices.add(white);
        colorChoices.add(black);
        colorChoices.add(brown);

        JPanel radioPanel = new JPanel();
        radioPanel.setBounds(0,200,AppConstants.WIDTH, 140);
        radioPanel.setLayout(null);
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
    private void addNamePrompt() {
        nameField = new JTextField(10);

        JLabel nameLabel = new JLabel("Name:");

        JPanel namePanel = new JPanel();
        namePanel.setBounds(0, 340, AppConstants.WIDTH, 50);
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        this.add(namePanel);
    }
    private void addConfirmButton() {
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setName("confirmButton");
        addButton(confirmButton, AppConstants.WIDTH/2 - 100,0,200,50, new Color(0xBEE0F8));
        JPanel confirmPanel = new JPanel();
        confirmPanel.setBounds(0, 700, AppConstants.WIDTH, 100);
        confirmPanel.setLayout(null);
        confirmPanel.add(confirmButton);

        this.add(confirmPanel);
    }

    private void addPetImgPanel() {
        JLabel petLabel = new JLabel();

        JPanel petPanel = new JPanel();
        petPanel.setBounds(0,390,AppConstants.WIDTH, 310);
        petPanel.add(petLabel);
        currPetLabel = petLabel;
        this.add(petPanel);
    }

    private void displayPetImg() {
        if(currAnimal != null && currColor != null)
        {
            currPetImg = new ImageIcon(String.format("src/main/java/softwaredesign/IMGs/animalsImgs/%s%s.png", currColor, currAnimal));
            ImageIcon tempPetImg = scaleImage(currPetImg, 300, 300);;

            currPetLabel.setIcon(tempPetImg);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton button = (AbstractButton) e.getSource();
        String buttonName = button.getName();

        switch (buttonName) {
            case "dogButton":
                currAnimal = "Dog";
                break;
            case "catButton":
                currAnimal = "Cat";
                break;
            case "hamsterButton":
                currAnimal = "Hamster";
                break;
            case "whiteButton":
                currColor = "white";
                break;
            case "blackButton":
                currColor = "black";
                break;
            case "brownButton":
                currColor = "brown";
                break;
            case "confirmButton":
                String currName = nameField.getText();
                boolean validSelection = !currName.isEmpty() && currAnimal != null && currColor != null;
                if (validSelection) {
                    Tamagotchi.setPet(createPet(currAnimal, currName, currPetImg));
                    Tamagotchi.switchScreen("PetActionScreen");
                }
                break;
        }
        displayPetImg();
    }
    private Animal createPet(String animal, String name, ImageIcon img) {
        AnimalFactory animalFactory = new AnimalFactory();
        return animalFactory.getAnimal(animal, name, img);
    }
}
