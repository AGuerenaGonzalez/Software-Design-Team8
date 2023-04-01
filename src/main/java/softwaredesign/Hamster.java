package softwaredesign;

import javax.swing.*;

public class Hamster extends Animal{
    public Hamster(String name, ImageIcon img, int cDV, int hDV, int mDV, int eDV){
        super(name, img, cDV, hDV, mDV, eDV);
    }
    public int feed(String food){
        if (food.equalsIgnoreCase("hamsterFood"))
            return hunger.increase();
        else
            return hunger.increase(0.5);
    }
}
