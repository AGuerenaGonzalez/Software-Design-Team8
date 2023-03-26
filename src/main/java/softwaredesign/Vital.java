package softwaredesign;

import javax.swing.*;
import javax.swing.plaf.InternalFrameUI;

public class Vital extends JProgressBar {
    private final int MAXVAL = 100, MINVAL = 0;
    private final int WAITMILSEC = 2000;
    private int currVal = 100, changeVal;
    private boolean isEmpty = false;
    private Observer observer = null;

    public Vital(Observer obs, int changeVal) {
        observer = obs;
        this.changeVal = changeVal;
        this.setMaximum(MAXVAL);
        this.setValue(MAXVAL);
        this.setMinimum(MINVAL);
    }

    public int getVal() {
        return currVal;
    }

    public void constDecrease() {
        try {
            Thread.sleep(WAITMILSEC);

            while (true) {
                int newVal = currVal - changeVal;

                if (newVal <= MINVAL) {
                    currVal = MINVAL;
                    if (!isEmpty && observer != null)
                        observer.notifyEmpty();
                    isEmpty = true;
                } else {
                    currVal = newVal;
                }
                setValue(currVal);
                Thread.sleep(WAITMILSEC);
            }
        }catch(InterruptedException e){
            System.out.println("Interupt exception");
        }

    }

    public void increase() {
        int newVal = currVal + changeVal;

        if (isEmpty) {
            isEmpty = false;
            currVal = newVal;
        }
        if (newVal >= MAXVAL)
            currVal = MAXVAL;
        else {
            if (isEmpty)
                isEmpty = false;
            currVal = newVal;
        }
    }

}
