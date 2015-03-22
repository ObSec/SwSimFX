package ch.obsec.net.swsimfx.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.obsec.net.swsimfx.SwSimFX;

/**
 * @version 1.0
 * @since 1.0
 * @author mario.oberli@obsec.ch
 */
@SuppressWarnings("unused")
public class WorkSpaceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkSpaceController.class);
    private SwSimFX mainApp;

    /**
     * establish link to Main
     * @param mainApp mainApp
     */
    public void setMainApp(SwSimFX mainApp) {
        LOGGER.debug("setMainApp({})", mainApp);
        this.mainApp = mainApp;
    }

}
