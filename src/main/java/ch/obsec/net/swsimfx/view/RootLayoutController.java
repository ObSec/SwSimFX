package ch.obsec.net.swsimfx.view;

import javafx.application.Platform;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.obsec.net.swsimfx.SwSimFX;
import ch.obsec.net.swsimfx.SSFglobal;

/**
 * @version 1.0
 * @since 1.0
 * @author mario.oberli@obsec.ch
 */
@SuppressWarnings("unused")
public class RootLayoutController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootLayoutController.class);
    private SwSimFX mainApp;

    /**
     * establish link to Main
     * @param mainApp mainApp
     */
    public void setMainApp(SwSimFX mainApp) {
        LOGGER.debug("setMainApp({})", mainApp);
        this.mainApp = mainApp;
    }

    @FXML private void handleMenuFileNew() {
        LOGGER.trace("handleMenuFileNew()");
    }

    @FXML private void handleMenuFileOpen() {
        LOGGER.trace("handleMenuFileOpen()");
    }

    @FXML private void handleMenuFileSave() {
        LOGGER.trace("handleMenuFileSave()");
    }

    @FXML private void handleMenuFileSaveAs() {
        LOGGER.trace("handleMenuFileSaveAs()");
    }

    @FXML private void handleMenuFilePrint() {
        LOGGER.trace("handleMenuFilePrint()");
    }

    /**
     * EventHandler, exit
     */
    @FXML private void handleMenuFileExit() {
        LOGGER.trace("handleMenuFileExit()");
        Platform.exit();
    }

    @FXML private void handleMenuEditAdd() {
        LOGGER.trace("handleMenuEditAdd()");
    }

    @FXML private void handleMenuFileDel() {
        LOGGER.trace("handleMenuFileDel()");
    }

    @FXML private void handleMenuFileCopy() {
        LOGGER.trace("handleMenuFileCopy()");
    }

    @FXML private void handleMenuFileCut() {
        LOGGER.trace("handleMenuFileCut()");
    }

    @FXML private void handleMenuFilePaste() {
        LOGGER.trace("handleMenuFilePaste()");
    }

    @FXML private void handleMenuHelpHelp() {
        LOGGER.trace("handleMenuHelpHelp()");
    }

    @FXML private void handleMenuHelpAbout() {
        LOGGER.trace("handleMenuHelpAbout()");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("SwSimFX About");
        alert.setHeaderText("About\nVersion: " + SSFglobal.getVersion());
        alert.setContentText(
                SSFglobal.getSystemInfo()[0] +
                "\n" + SSFglobal.getSystemInfo()[1] + "\n" +
                "\nAuthor: Mario Oberli" +
                "\nhttps://development.obsec.ch"
        );
        alert.showAndWait();
    }

}
