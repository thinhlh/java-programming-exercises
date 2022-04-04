package models;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import helper.StringHelper;

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
    public static Vehicle createVehicleFromWithScanner(VehicleType type) {
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

    /**
     * This will create the vehicle from the given string indicate the vehicle type
     * which follow the below patten
     * [Truck] [Goat301] [green] [2005] [18] [60000] [2000] [100] [TI3001] [5000]
     * 
     * @param vehicleTypeString
     * @return
     */
    public static Vehicle createVehicleWithInputString(String input) {
        Pattern splitPropertiesPattern = Pattern.compile("\\[(.*?)\\]");

        ArrayList<String> splittedProperties = splitPropertiesPattern
                .matcher(input)
                .results()
                .map(result -> result.group())
                .map(rawProperty -> StringHelper.extractPropertyFromString(rawProperty))
                .collect(Collectors.toCollection(ArrayList::new));

        String vehicleTypeString = splittedProperties.get(0);

        ArrayList<String> propertiesString = splittedProperties
                .subList(1, splittedProperties.size())
                .stream()
                .collect(Collectors.toCollection(ArrayList::new));

        try {
            VehicleType type = VehicleType.valueOf(vehicleTypeString);

            switch (type) {
                case Bicycle:
                    return new Bicycle(propertiesString);

                case Car:
                    return new Car(propertiesString);

                case Bike:

                    return new Bike(propertiesString);

                case Truck:

                    return new Truck(propertiesString);

                default:
                    return null;
            }

        } catch (Exception e) {
            System.out.println("Khong co phuong tien nay");
            return null;
        }
    }
}
