package org.example;

public class ElectricCar extends Car {
    public ElectricCar(String make, String model, int year, int batteryCapacity, int batteryBound, int energyConsumption) {
        super(make, model, year, 0, 0, 0, TypeOfFuel.ELECTRIC);
        this.batteryBound = batteryBound;
        this.batteryCapacity = batteryCapacity;
        this.energyConsumption = energyConsumption;
    }

    private float batteryCapacity; // ёмкость батареи в кв/ч
    private float batteryBound; // заряд батареи в кв/ч
    private float energyConsumption; // потребление энергии на 100 км в кв/ч

    public float getEnergyConsumption() {
        return energyConsumption;
    }

    public float getBatteryBound() {
        return batteryBound;
    }

    public float getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public String startEngine() {
        return "The electric vehicle engine does not need to be started";
    }

    @Override
    public String  stopEngine() {
        return "The electric vehicle engine does not need to be stopped";
    }

    @Override
    public String fillFuelTank(int fuel) {
        return "Impossible to refuel an electric car";
    }

    @Override
    public String drive(int distance) {
        if (batteryBound >= energyConsumption / 100f * distance) {
            batteryBound -= energyConsumption / 100f * distance;
            return "The car traveled 100 km and consumed " + energyConsumption / 100f * distance +
                    " kW of energy. There are " + batteryBound + " kW/h left in the battery.";
        } else {
            return "Not enough energy for the trip " + distance + " km, needed " + energyConsumption / 100f * distance +
                    " and in batteries only " + batteryBound + "kw";
        }
    }

    public String charge(int powerOfCharger, int time) {
        if (powerOfCharger * time > batteryCapacity) {
            batteryBound = batteryCapacity;
            return "The battery was fully charged with a charge of " + powerOfCharger + " kw for " +
                    time + " hours";
        } else {
            batteryBound += powerOfCharger * time;
            return "The battery was charged at " + powerOfCharger * time + " kw with charging " + powerOfCharger +
                    " kw for " + time + " hours, now it has " + batteryBound + " kw";
        }
    }

    @Override
    public String getInfo() {
        return "Make: " + getMake() + "\n" +
                "Model: " + getModel() + "\n" +
                "Year: " + getYear() + "\n" +
                "Battery capacity: " + batteryCapacity + "kw/h\n" +
                "Battery level: " + batteryBound + "kw/h\n" +
                "Energy consumption: " + energyConsumption + "kw/100km\n";
    }
}
