package ch.obsec.net.swsimfx.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version 1.1
 * @since 1.0
 * @author mario.oberli@obsec.ch
 */
@XmlRootElement(name = "device")
public class DataWrapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataWrapper.class);

    private List<Device> device;

    /**
     * getDevice
     * @return device
     */
    @XmlElement(name = "device")
    public List<Device> getDevice() {
        LOGGER.debug("getSimData()");
        return device;
    }

    /**
     * setDevice
     * @param deviceData which data
     */
    public void setDevice(List<Device> deviceData) {
        LOGGER.debug("setSimData({})",deviceData);
        this.device = deviceData;
    }

}
