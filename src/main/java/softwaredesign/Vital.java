package softwaredesign;

import javax.swing.*;

public class Vital extends JProgressBar {
    private final int MAXVAL = 100, MINVAL = 0;
    private final int INTERVALTIME = 9000;
    private final int CHANGEVAL;
    private boolean isEmpty = false;
    private Observer observer;

    public Vital(Observer obs, int changeVal) {
        observer = obs;
        this.CHANGEVAL = changeVal;
        this.setMaximum(MAXVAL);
        this.setValue(MAXVAL);
        this.setMinimum(MINVAL);
    }
    public void decrease(){
        int currVal = this.getValue();
        int newVal = currVal - CHANGEVAL;

        if (newVal <= MINVAL) {
            newVal = MINVAL;
            if (!isEmpty && observer != null)
                observer.notifyEmptyInc();
            isEmpty = true;
        }

        this.setValue(newVal);
    }

    public void constDecrease() {

        try {
            Thread.sleep(INTERVALTIME);

            while (true) {
                decrease();
                Thread.sleep(INTERVALTIME);
            }
        } catch (InterruptedException e) {
            System.out.println("Interupt exception");
        }

    }

    public int increase() {
        return increase(1);
    }

    public int increase(double ratio) {
        int currVal = this.getValue();
        int incVal = (int) (ratio * CHANGEVAL);
        int newVal = currVal + incVal;

        if (isEmpty) {
            isEmpty = false;
            observer.notifyEmptyDec();
        } else if (newVal > MAXVAL)
            newVal = MAXVAL;

        this.setValue(newVal);

        return incVal;
    }


}
