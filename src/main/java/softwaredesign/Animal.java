package softwaredesign;

abstract class Animal {

    protected int cleanDiffVal, hungerDiffVal, moodDiffVal, energyDiffVal;
    protected Vital hunger, energy, mood, clean;
    protected String name, color;
    private boolean isAlive = true;

    protected void setVitals(){
        this.hunger = new Vital(hungerDiffVal);
        this.energy = new Vital(energyDiffVal);
        this.mood = new Vital(moodDiffVal);
        this.clean = new Vital(cleanDiffVal);
    }
    protected void setVals(String name, String color, int cleanDiffVal,
                           int hungerDiffVal, int moodDiffVal, int energyDiffVal){
        this.name = name;
        this.color = color;
        this.cleanDiffVal = cleanDiffVal;
        this.hungerDiffVal = hungerDiffVal;
        this.moodDiffVal = moodDiffVal;
        this.energyDiffVal = energyDiffVal;
    }

    public Vital getHungerVital(){
        return hunger;
    }
    public Vital getEnergyVital(){
        return energy;
    }
    public Vital getMoodVital(){
        return mood;
    }
    public Vital getCleanVital(){
        return clean;
    }

    public void play(){
//        moodLevel.increase();
        System.out.println("PLAYING");
    }
    public void clean(){
//        cleanLevel.increase();
        System.out.println("CLEANING");
    }
    public void feed(){
//        hungerLevel.increase();
        System.out.println("FEEDING");
    }
    public void sleep(){
//        sleepLevel.increase();
        System.out.println("SLEEPING");
    }

    public void decreaseAllVitals(){
//        hungerLevel.decrease();
//        cleanLevel.decrease();
//        sleepLevel.decrease();
//        moodLevel.decrease();
    }
}
