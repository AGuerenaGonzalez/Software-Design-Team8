package softwaredesign;

import javax.swing.*;

abstract class Animal implements Observer {

    protected final Vital hunger, energy, mood, clean;
    private final String name;
    private int numEmptyVitals = 0;
    private final int MAXEMPTYVITALS = 2;
    private final ImageIcon animalImg;
    private final long startTime;

    private final ThreadGroup VITALTHREADS = new ThreadGroup("vitalThreadGroup");

    public Animal(String name, ImageIcon img, int cleanDiffVal,
                  int hungerDiffVal, int moodDiffVal, int energyDiffVal) {
        this.name = name;
        this.animalImg = img;
        this.hunger = new Vital(this, hungerDiffVal);
        this.energy = new Vital(this, energyDiffVal);
        this.mood = new Vital(this, moodDiffVal);
        this.clean = new Vital(this, cleanDiffVal);
        startTime = System.nanoTime();

        decreaseAllVitals();
    }


    public ImageIcon getAnimalImg() {
        return animalImg;
    }

    public void notifyEmptyInc() {
        numEmptyVitals++;

        if (numEmptyVitals == MAXEMPTYVITALS) {
            Tamagotchi.switchScreen("DeathScreen");
            VITALTHREADS.interrupt();
        }
    }

    public void notifyEmptyDec() {
        numEmptyVitals--;
    }

    public Vital getHungerVital() {
        return hunger;
    }

    public Vital getEnergyVital() {
        return energy;
    }

    public Vital getMoodVital() {
        return mood;
    }

    public Vital getCleanVital() {
        return clean;
    }

    public int played(boolean isGameWon) {
        energy.decrease();

        if (isGameWon) {
            return mood.increase();
        }

        return 0;
    }

    public int clean() {
        return clean.increase();
    }

    public abstract int feed(String food);

    public int sleep() {
        return energy.increase();
    }

    public String getName() {
        return name;
    }

    public long getTimeAlive() {
        return System.nanoTime() - startTime;
    }

    private void decreaseAllVitals() {

        Thread hungerThread = new Thread(VITALTHREADS, new Runnable() {
            public void run() {
                hunger.constDecrease();
            }
        });

        Thread cleanThread = new Thread(VITALTHREADS, new Runnable() {
            public void run() {
                clean.constDecrease();
            }
        });

        Thread energyThread = new Thread(VITALTHREADS, new Runnable() {
            public void run() {
                energy.constDecrease();
            }
        });

        Thread moodThread = new Thread(VITALTHREADS, new Runnable() {
            public void run() {
                mood.constDecrease();
            }
        });

        hungerThread.setDaemon(true);
        hungerThread.start();

        cleanThread.setDaemon(true);
        cleanThread.start();

        energyThread.setDaemon(true);
        energyThread.start();

        moodThread.setDaemon(true);
        moodThread.start();

    }
}
