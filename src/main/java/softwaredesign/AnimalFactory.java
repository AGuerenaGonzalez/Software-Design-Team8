package softwaredesign;

public class AnimalFactory {
    public Animal getAnimal(String animalType, String name, String color) {
        switch (animalType) {
            case "DOG":
                return new Dog(name, color, 12, 16, 8, 16);
            case "CAT":
                return new Cat(name, color, 16, 8, 12, 20);
            case "HAMSTER":
                return new Hamster(name, color, 4, 12, 20, 4);
            default:
                return null;
        }
    }
}
