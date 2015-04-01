package ch.obsec.net.swsimfx.model;

import javafx.beans.property.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.obsec.net.swsimfx.IdCounter;

/**
 * @version 1.1
 * @since 1.1
 * @author mario.oberli@obsec.ch
 */
public class Device {

    private static final Logger LOGGER = LoggerFactory.getLogger(Device.class);

    private long deviceID = IdCounter.nextId();
    private final StringProperty deviceNameProperty;

    /**
     * Default constructor.
     */
    public Device() {
        this(null);
        LOGGER.trace("Device()");
    }

    /**
     * Constructor with some initial data.
     */
    public Device(String name) {
        LOGGER.debug("Device({})",name);
        this.deviceNameProperty = new SimpleStringProperty("Name");
    }

    public long getId() {
        LOGGER.debug("getId(): {}",deviceID);
        return deviceID;
    }

    /**
     * getter
     * @return device name
     */
    public String getDeviceName() {
        LOGGER.debug("getDeviceName(): {}",deviceNameProperty.get());
        return deviceNameProperty.get();
    }

    /**
     * setter
     * @param name set device name
     */
    public void setDeviceName(String name) {
        LOGGER.debug("setDeviceName({})",name);
        this.deviceNameProperty.set(name);
    }

    /**
     * property
     * @return device name property
     */
    public StringProperty deviceNameProperty() {
        LOGGER.debug("deviceNameProperty(): {}",deviceNameProperty);
        return deviceNameProperty;
    }

}
