package softwaredesign;

import javax.swing.*;
import java.awt.Color;

public class Dog extends Animal {
    public Dog(String name, ImageIcon img, int cDV, int hDV, int mDV, int eDV) {
        super(name, img, cDV, hDV, mDV, eDV);
    }

    public int feed(String food) {
        if (food.equalsIgnoreCase("dogFood"))
            return hunger.increase();
        else
            return hunger.increase(0.5);
    }
}
