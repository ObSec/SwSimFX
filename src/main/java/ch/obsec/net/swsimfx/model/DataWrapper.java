package ch.obsec.net.swsimfx.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version 1.0
 * @since 1.0
 * @author mario.oberli@obsec.ch
 */
@XmlRootElement(name = "simData")
public class DataWrapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataWrapper.class);

    private List<SimData> simData;

    /**
     * getData
     * @return simData
     */
    @XmlElement(name = "simData")
    public List<SimData> getData() {
        LOGGER.debug("getSimData()");
        return simData;
    }

    /**
     * setCompany
     * @param simData which company
     */
    public void setData(List<SimData> simData) {
        LOGGER.debug("setSimData({})",simData);
        this.simData = simData;
    }

}
