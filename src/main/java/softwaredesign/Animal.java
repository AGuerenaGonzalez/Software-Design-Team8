package softwaredesign;

abstract class Animal implements Observer {

    protected Vital hunger, energy, mood, clean;
    protected String name, color;
    private boolean isAlive = true;
    private int numEmptyVitals = 0;
    private final int MAXEMPTYVITALS = 2;

    private final ThreadGroup VITALTHREADS = new ThreadGroup("vitalThreadGroup");

    public Animal(String name, String color, int cleanDiffVal,
                           int hungerDiffVal, int moodDiffVal, int energyDiffVal) {
        this.name = name;
        this.color = color;
        this.hunger = new Vital(hungerDiffVal);
        this.energy = new Vital(energyDiffVal);
        this.mood = new Vital(moodDiffVal);
        this.clean = new Vital(cleanDiffVal);

        hunger.setObserver(this);
        clean.setObserver(this);
        energy.setObserver(this);
        mood.setObserver(this);

        decreaseAllVitals();
    }

    public void notifyEmpty() {
        numEmptyVitals++;

        if (numEmptyVitals == MAXEMPTYVITALS) {
            VITALTHREADS.interrupt();

            System.out.println("DEAD");
        }
    }

    public void notifyNotEmpty() {

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
