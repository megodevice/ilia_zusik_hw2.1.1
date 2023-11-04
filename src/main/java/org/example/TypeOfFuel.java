package org.example;

public enum TypeOfFuel {
    GASOLINE("Gasoline"),
    DIESEL("Diesel"),
    ELECTRIC("Electric");
    private String fuel;
    TypeOfFuel(String fuel) {
        this.fuel = fuel;
    }
    public String getFuelName() {
        return fuel;
    }
}
