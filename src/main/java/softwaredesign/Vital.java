package softwaredesign;

import javax.swing.*;

public class Vital extends JProgressBar {
    private final int MAXVAL = 100, MINVAL = 0;
    private final int WAITMILSEC = 5000;
    private final int changeVal;
    private boolean isEmpty = false;
    private Observer observer = null;

    public Vital(Observer obs, int changeVal) {
        observer = obs;
        this.changeVal = changeVal;
        this.setMaximum(MAXVAL);
        this.setValue(MAXVAL);
        this.setMinimum(MINVAL);
    }

    public void constDecrease() {

        try {
            Thread.sleep(WAITMILSEC);

            while (true) {
                int currVal = this.getValue();
                int newVal = currVal - changeVal;

                if (newVal <= MINVAL) {
                    newVal = MINVAL;
                    if (!isEmpty && observer != null)
                        observer.notifyEmptyInc();
                    isEmpty = true;
                }

                this.setValue(newVal);
                Thread.sleep(WAITMILSEC);
            }
        } catch (InterruptedException e) {
            System.out.println("Interupt exception");
        }

    }

    public void increase() {
        increase(1);
    }

    public void increase(double ratio) {
        int currVal = this.getValue();
        System.out.println("Currval was: " + currVal);
        int incVal = (int) (ratio * changeVal);
        int newVal = currVal + incVal;

        if (isEmpty) {
            isEmpty = false;
        } else if (newVal > MAXVAL)
            newVal = MAXVAL;

        System.out.println("    Currval is: " + newVal);
        this.setValue(newVal);
    }


}
