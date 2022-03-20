package models;

/**
 * This is the factory class that it cannot be instantiate an intance
 * 
 * This factory class is used to create a specific vehicle depends on users'
 * needs.
 */
class VehicleFactory {
    private VehicleFactory() {

    }

    /**
     * 
     * Create a new vehicle depends on the vehicle type users chose
     * 
     * @param type
     * @return Vehicle
     */
    public static Vehicle createVehicle(VehicleType type) {
        switch (type) {
            case Bicycle:
                return new Bicycle();

            case Car:
                return new Car();

            case Bike:

                return new Bike();

            case Truck:

                return new Truck();

            default:
                return null;
        }
    }
}
