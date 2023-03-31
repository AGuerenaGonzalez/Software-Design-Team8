package softwaredesign;

import javax.swing.*;

public class Vital extends JProgressBar {
    private final int MAXVAL = 100, MINVAL = 0;
    private final int DECINTERVAL = 30000;
    private final int OFFSET;
    private boolean isEmpty = false;
    private Observer observer;

    public Vital(Observer obs, int offset) {
        observer = obs;
        this.OFFSET = offset;
        this.setMaximum(MAXVAL);
        this.setValue(MAXVAL);
        this.setMinimum(MINVAL);
    }
    public void decrease(){
        int currVal = this.getValue();
        int newVal = currVal - OFFSET;

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
            Thread.sleep(DECINTERVAL);

            while (true) {
                decrease();
                Thread.sleep(DECINTERVAL);
            }
        } catch (InterruptedException e) {
            //expected interupt on thread when Animal dies
        }

    }

    public int increase() {
        return increase(1);
    }

    public int increase(double ratio) {
        int currVal = this.getValue();
        int incVal = (int) (ratio * OFFSET);
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
