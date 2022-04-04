package models.devices;

import exceptions.InvalidFieldException;
import safety.ValidatedInteger;
import safety.ValidatedModel;

/**
 * The Device object, which acts as a device of a vehicle
 * This device object have to implement IDeviceControllable interface
 * to show methods that the vehicle can interacts with
 */
public abstract class Device implements IDeviceControllable {
    private final ValidatedModel model;
    private int volume = 1;

    Device(String model) throws InvalidFieldException, Exception {
        this.model = new ValidatedModel(model);
    }

    Device(String model, int volume) throws InvalidFieldException, Exception {
        this.model = new ValidatedModel(model);
        this.volume = new ValidatedInteger.Builder()
                .setLowerBound(0)
                .build(volume)
                .getValue();
    }
}
