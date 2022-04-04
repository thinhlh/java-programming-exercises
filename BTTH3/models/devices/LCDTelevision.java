package models.devices;

import exceptions.InvalidFieldException;

class LCDTelevision extends Device {

    private final int channel;

    LCDTelevision(String model, int volume) throws InvalidFieldException, Exception {
        super(model, volume);
        this.channel = 1;
    }

    LCDTelevision(String model, int volume, int channel) throws InvalidFieldException, Exception {
        super(model, volume);
        this.channel = channel;
    }

}
