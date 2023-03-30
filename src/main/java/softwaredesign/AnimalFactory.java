package softwaredesign;

import javax.swing.*;

public class AnimalFactory {
    public static Animal getAnimal(String animalType, String name, ImageIcon img) {
        animalType.toLowerCase();
        switch (animalType) {
            case "Dog":
                return new Dog(name, img, 12, 16, 8, 16);
            case "Cat":
                return new Cat(name, img, 16, 8, 12, 20);
            case "Hamster":
                return new Hamster(name, img, 4, 12, 20, 4);
            default:
                return null;
        }
    }
}
