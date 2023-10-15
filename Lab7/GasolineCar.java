package edu.cscc;

// Margaret Riordan | 12 Oct 2023 | Lab 7: Inheritance and Polymorphism using Cars
public class GasolineCar extends Car {
    private int cylinders;
    private double tankCapacity;

    GasolineCar(String make, String model, int year ,int cylinders, double tankCapacity){
        super(make, model, year);
        this.cylinders = cylinders;
        this.tankCapacity = tankCapacity;
    }

    public int getCylinders() {return cylinders;}
    public double getTankCapacity(){return tankCapacity;}

    public void setCylinders(){this.cylinders = cylinders;}

    public void  setTankCapacity(){this.tankCapacity = tankCapacity;}

    public void describe(){
        System.out.println("Make: "+getMake()+
                "\nModel: "+getModel()+
                "\nYear: "+getYear()+
                "\nCylinders: "+getCylinders()+
                "\nTank Capacity: "+getTankCapacity());

    }

}
