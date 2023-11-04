package org.example;

public class Car {
    private String make; // (марка автомобиля)
    private String model; // (модель автомобиля)
    private int year; // (год выпуска)
    private float fuelCapacity; // (емкость топливного бака в л)
    private float fuelLevel; // (уровень топлива в л)
    private boolean isEngineRunning; // (запущен ли двигатель)
    private float consumption; // (расход на 100 км в л)
    private TypeOfFuel typeOfFuel; // (тип топлива)

    public Car(String make, String model, int year, int fuelCapacity, int fuelLevel, int consumption, TypeOfFuel typeOfFuel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelCapacity = fuelCapacity;
        this.fuelLevel = fuelLevel;
        this.isEngineRunning = false;
        this.consumption = consumption;
        this.typeOfFuel = typeOfFuel;
    }

    public TypeOfFuel getTypeOfFuel() {
        return typeOfFuel;
    }

    public float getConsumption() {
        return consumption;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public float getFuelLevel() {
        return fuelLevel;
    }

    public boolean isEngineRunning() {
        return isEngineRunning;
    }

    public String startEngine() {
        if (fuelLevel - 1 > 0) {
            fuelLevel -= 1;
            isEngineRunning = true;
            return "Engine was started";
        } else {
            return "Not enough fuel to start the engine";
        }
    }

    public String stopEngine() {
        if (isEngineRunning) {
            isEngineRunning = false;
            return "Engine was stopped";
        } else {
            return "The engine has not been started before";
        }
    }

    public String fillFuelTank(int fuel) {
        if (fuelLevel + fuel <= fuelCapacity) {
            fuelLevel += fuel;
            return "The tank was filled with " + fuel + " liters, now it contains " + fuelLevel + " liters";
        } else {
            return "It is impossible to fill " + fuel + " liters, the tank will be overfilled";
        }
    }

    public String drive(int distance) {
        if (isEngineRunning && (fuelLevel >= consumption / 100f * distance)) {
            fuelLevel -= consumption / 100f * distance;
            return "The car traveled " + distance + " km and consumed " + (consumption / 100f * distance) +
                    " liters of fuel. There are " + fuelLevel + " liters left in the tank.";
        } else if (!isEngineRunning) {
            return "The engine is stopped";
        } else {
            return "There is not enough fuel to travel " + distance + " km, you need " + consumption / 100f * distance +
                    " and there is only " + fuelLevel + " in the tank";
        }
    }

    public String getInfo() {
        return "Make: " + make + "\n" +
                "Model: " + model + "\n" +
                "Year: " + year + "\n" +
                "Fuel capacity: " + fuelCapacity + "l\n" +
                "Fuel level: " + fuelLevel + "l\n" +
                "Fuel consumption: " + consumption + "l/100km\n" +
                "Type of fuel: " + typeOfFuel.getFuelName() + "\n" +
                "Engine is " + (isEngineRunning ? "" : "not ") + "running\n";
    }
}
