package models.devices;

import exceptions.InvalidFieldException;

/**
 * This is an implementation of Device
 */
public class LCDTelevision extends Device {

    private int channel = 1;

    public LCDTelevision(String model) throws InvalidFieldException, Exception {
        super(model);
    }

    public LCDTelevision(String model, int volume) throws InvalidFieldException, Exception {
        super(model, volume);
    }

    public LCDTelevision(String model, int volume, int channel) throws InvalidFieldException, Exception {
        super(model, volume);
        this.channel = channel;
    }

    @Override
    public void turnOn() {
        System.out.println("LCDTelevision turns on");
    }

    @Override
    public void turnOff() {
        System.out.println("LCDTelevision turns off");
    }

    @Override
    public void volumeUp() {
        System.out.println("LCDTelevision volume up");
    }

    @Override
    public void volumeDown() {
        System.out.println("LCDTelevision volume down");
    }

}
