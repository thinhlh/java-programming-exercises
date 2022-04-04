package models.devices;

import exceptions.InvalidFieldException;

/**
 * This is an implementation of Device
 */
public class DVDPlayer extends Device {
    private double memory = 0.0;

    public DVDPlayer(String model) throws InvalidFieldException, Exception {
        super(model);
    }

    public DVDPlayer(String model, int volume) throws InvalidFieldException, Exception {
        super(model, volume);
    }

    public DVDPlayer(String model, int volume, Double memory) throws InvalidFieldException, Exception {
        super(model, volume);
        this.memory = memory;
    }

    @Override
    public void turnOn() {
        System.out.println("DVDPlayer turns on");
    }

    @Override
    public void turnOff() {
        System.out.println("DVDPlayer turns off");
    }

    @Override
    public void volumeUp() {
        System.out.println("DVDPlayer volume up");
    }

    @Override
    public void volumeDown() {
        System.out.println("DVDPlayer volume down");

    }
}