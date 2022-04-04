package models.devices;

import exceptions.InvalidFieldException;

class DVDPlayer extends Device {
    private final double memory;

    DVDPlayer(String model, int volume, Double memory) throws InvalidFieldException, Exception {
        super(model, volume);
        this.memory = memory;
    }
}