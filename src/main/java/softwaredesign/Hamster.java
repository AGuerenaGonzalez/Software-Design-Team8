package softwaredesign;

public class Hamster extends Animal{
    public Hamster(String name, String color, int cDV, int hDV, int mDV, int eDV){
        super("Hamster", name, color, cDV, hDV, mDV, eDV);
    }
    public void feed(String food){
        if (food.equals("hamsterFood"))
            hunger.increase();
        else
            hunger.increase(0.5);
    }
}
