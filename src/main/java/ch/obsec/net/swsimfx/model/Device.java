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

    /**
     * Default constructor.
     */
    public Device() {
        LOGGER.trace("Device()");
    }

    public long getId() {
        LOGGER.debug("getId(): {}",deviceID);
        return deviceID;
    }

}
