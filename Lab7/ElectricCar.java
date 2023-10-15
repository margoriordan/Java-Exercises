package edu.cscc;

// Margaret Riordan | 12 Oct 2023 | Lab 7: Inheritance and Polymorphism using Cars
public class ElectricCar extends Car{
    int batterySize;

    ElectricCar(String make, String model, int year, int batterySize){
        super(make, model, year);
        this.batterySize = batterySize;
    }
    public void setBatterySize(){this.batterySize = batterySize;}
    public int getBatterySize(){return batterySize;}

    public void describe(){
        System.out.println("Make: "+getMake()+
                "\nModel: "+getModel()+
                "\nYear: "+getYear()+
                "\nBattery Size: "+ getBatterySize());
    }

}
