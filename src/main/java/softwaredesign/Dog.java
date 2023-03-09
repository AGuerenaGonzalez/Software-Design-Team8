package softwaredesign;
import java.awt.Color;

public class Dog extends Animal{
    public Dog(String name, String color){
        this.setVals(name, color, 12, 16, 8, 16);
        this.setVitals();
    }
}
