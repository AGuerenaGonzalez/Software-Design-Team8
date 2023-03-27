package softwaredesign;

import javax.swing.*;

abstract class Animal implements Observer {

    protected Vital hunger, energy, mood, clean;
    protected String name;
    private boolean isSleeping = false;
    private int numEmptyVitals = 0;
    private final int MAXEMPTYVITALS = 2;
    private ImageIcon animalImg;

    private final ThreadGroup VITALTHREADS = new ThreadGroup("vitalThreadGroup");

    public Animal(String animalType, String name, String color, int cleanDiffVal,
                           int hungerDiffVal, int moodDiffVal, int energyDiffVal) {
        this.name = name;
        this.hunger = new Vital(this, hungerDiffVal);
        this.energy = new Vital(this, energyDiffVal);
        this.mood = new Vital(this, moodDiffVal);
        this.clean = new Vital(this, cleanDiffVal);
        this.animalImg = new ImageIcon(String.format("src/main/java/softwaredesign/IMGs/animalsImgs/%s%s.png", color, animalType));

        decreaseAllVitals();
    }

    public ImageIcon getAnimalImg(){
        return animalImg;
    }


    public void notifyEmptyInc() {
        numEmptyVitals++;

        if (numEmptyVitals == MAXEMPTYVITALS) {
            VITALTHREADS.interrupt();

            System.out.println("DEAD");
        }
    }

    public void notifyEmptyDec() {

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

    public void play() {
//        moodLevel.increase();
        System.out.println("PLAYING");
    }

    public void clean() {
//        cleanLevel.increase();
        System.out.println("CLEANING");
    }

    public void feed() {
//        hungerLevel.increase();
        System.out.println("FEEDING");
    }

    public void sleep() {
//        sleepLevel.increase();
        System.out.println("SLEEPING");
    }

    public void decreaseAllVitals() {

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
