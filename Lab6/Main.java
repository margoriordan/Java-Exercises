//Margaret (Margo) Riordan | 10.08.23 | CSCI-2467: Lab 6 - Water Tank//
public class Main {
    public static void main(String[] args) {
        WaterTank waterTank = new WaterTank(350, 300);
        waterTank.print();
        waterTank.add(100);
        waterTank.drain(180);
        waterTank.print();
        waterTank.add(60);
        waterTank.drain(200);
        waterTank.print();
        waterTank.drain(50);
        waterTank.add(375);
        waterTank.drain(142);
        waterTank.print();
    }
}
