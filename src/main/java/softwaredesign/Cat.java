package softwaredesign;

import javax.swing.*;
import java.awt.Color;

public class Cat extends Animal {
    public Cat(String name, ImageIcon img, int cDV, int hDV, int mDV, int eDV) {
        super(name, img, cDV, hDV, mDV, eDV);
    }

    public int feed(String food) {
        if (food.equalsIgnoreCase("catFood"))
            return hunger.increase();
        else
            return hunger.increase(0.5);
    }
}