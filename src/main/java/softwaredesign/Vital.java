package softwaredesign;

import javax.swing.*;

public class Vital extends JProgressBar {
    private final int MAXVAL = 100, MINVAL = 0;
    private int currVal = 100, changeVal;
    private boolean isEmpty = false;

    public Vital(int changeVal){
        this.changeVal = changeVal;
        this.setMaximum(MAXVAL);
        this.setValue(MAXVAL);
        this.setMinimum(MINVAL);
    }

    public int getVal(){
        return currVal;
    }

    public void decrease(){
        int newVal = currVal - changeVal;

        if(newVal <= MINVAL){
            currVal = MINVAL;
            isEmpty = true;
        }
        else{
            currVal = newVal;
        }
    }

    public void increase(){
        int newVal = currVal + changeVal;

        if(isEmpty){
            isEmpty = false;
            currVal = newVal;
        }
        if(newVal >= MAXVAL)
            currVal = MAXVAL;
        else{
            if(isEmpty)
                isEmpty = false;
            currVal = newVal;
        }
    }

}
