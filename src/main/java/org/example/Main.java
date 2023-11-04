package org.example;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Mercedes", "G63", 2010, 100, 30, 15, TypeOfFuel.GASOLINE);
        Car car2 = new Car("MAN", "TGX", 2012, 800, 200, 35, TypeOfFuel.DIESEL);
        ElectricCar electricCar = new ElectricCar("Tesla", "S", 2020, 400, 100, 100);
        System.out.println(car1.getInfo());
        System.out.println(car2.getInfo());
        System.out.println(electricCar.getInfo());
        System.out.println(car1.fillFuelTank(50));
        System.out.println(car1.fillFuelTank(90));
        System.out.println(car1.drive(150));
        System.out.println(car1.startEngine());
        System.out.println(car1.drive(150));
        System.out.println(car1.drive(250));
        System.out.println(car1.drive(250));
        System.out.println("--------------------------------------------");
        System.out.println(electricCar.getInfo());
        System.out.println(electricCar.charge(2,4));
        System.out.println(electricCar.drive(600));
        System.out.println(electricCar.startEngine());
        System.out.println(electricCar.charge(40, 12));
        System.out.println(electricCar.drive(230));
    }
}