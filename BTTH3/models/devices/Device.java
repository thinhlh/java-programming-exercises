package models.devices;

import exceptions.InvalidFieldException;
import safety.ValidatedInteger;
import safety.ValidatedModel;

abstract class Device {
    private final ValidatedModel model;
    private final int volume;

    Device(String model, int volume) throws InvalidFieldException, Exception {
        this.model = new ValidatedModel(model);
        this.volume = new ValidatedInteger.Builder()
                .setLowerBound(0)
                .build(volume)
                .getValue();
    }
}
