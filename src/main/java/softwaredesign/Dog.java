package softwaredesign;

import javax.swing.*;
import java.awt.Color;

public class Dog extends Animal {
    public Dog(String name, String color, int cDV, int hDV, int mDV, int eDV) {
        super("Dog", name, color, cDV, hDV, mDV, eDV);
    }

    public int feed(String food) {
        if (food.equals("dogFood"))
            return hunger.increase();
        else
            return hunger.increase(0.5);
    }
}
