package models.devices;

/**
 * This interface describe the methods that a device can do
 */
public interface IDeviceControllable {
    void turnOn();

    void turnOff();

    void volumeUp();

    void volumeDown();
}
