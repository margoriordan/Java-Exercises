//Margaret (Margo) Riordan | 10.08.23 | CSCI-2467: Lab 6 - Water Tank//
public class WaterTank {
    private int current, maxCapacity;

    //constructors
    public WaterTank(int current, int maxCapacity){
        this.maxCapacity = maxCapacity;
        if (current > maxCapacity){
            this.current = maxCapacity;
        } else {
            this.current = current;
        }
    }

    //getters
    public int getCurrent(){return(current);}
    public int getMaxCapacity(){return(maxCapacity);}

    //methods
    public void add(int volume){
        this.current += volume;
        if (this.current > this.maxCapacity){
            this.current = this.maxCapacity;
        }
    }

    public void drain(int volume){
        this.current -= volume;
        if (this.current < 0){
            this.current = 0;
        }

    }

    public void print(){
        System.out.println("The tank volume is " + this.current + " gallons.");
    }

}
