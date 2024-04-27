package pkg15;

public class Ship {
    private String type;
    private int carryingCapacity;
    private double dailyMaintenanceCost;
    private int navigationDuration;

    public Ship(String type, int carryingCapacity, double dailyMaintenanceCost, int navigationDuration) {
        this.type = type;
        this.carryingCapacity = carryingCapacity;
        this.dailyMaintenanceCost = dailyMaintenanceCost;
        this.navigationDuration = navigationDuration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public double getDailyMaintenanceCost() {
        return dailyMaintenanceCost;
    }

    public void setDailyMaintenanceCost(double dailyMaintenanceCost) {
        this.dailyMaintenanceCost = dailyMaintenanceCost;
    }

    public int getNavigationDuration() {
        return navigationDuration;
    }

    public void setNavigationDuration(int navigationDuration) {
        this.navigationDuration = navigationDuration;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "type='" + type + '\'' +
                ", carryingCapacity=" + carryingCapacity +
                ", dailyMaintenanceCost=" + dailyMaintenanceCost +
                ", navigationDuration=" + navigationDuration +
                '}';
    }
}