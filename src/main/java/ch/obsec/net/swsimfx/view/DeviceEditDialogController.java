package ch.obsec.net.swsimfx.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.obsec.net.swsimfx.model.Device;

/**
 * @version 1.1
 * @since 1.1
 * @author mario.oberli@obsec.ch
 */
//@SuppressWarnings("unused")
public class DeviceEditDialogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceEditDialogController.class);

    @FXML
    private Label lblSerialID;

    @FXML
    private TextField lblName;

    private Stage dialogStage;
    private Device device;
    private boolean okClicked = false;

    /**
     * is automatically executed during the load of the fxml.
     */
    @FXML
    private void initialize() {
        LOGGER.debug("initialize()");
    }

    /**
     * set stage for the dialog
     * @param dialogStage dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        LOGGER.debug("setDialogStage({})", dialogStage);
        this.dialogStage = dialogStage;
    }

    /**
     * set device information
     * @param device which device
     */
    public void setDevice(Device device) {
        LOGGER.debug("setDevice({})", device);
        this.device = device;
        lblSerialID.setText(Long.toString(device.getId()));
        lblName.setText(device.getDeviceName());
    }

    /**
     * possible location for checks do be done when ok is clicked
     * @return ok
     */
    public boolean isOkClicked() {
        LOGGER.trace("isOkClicked()");
        return okClicked;
    }

    /**
     * EventHandler, ok is clicked
     */
    @FXML
    private void handleDialogOk() {
        LOGGER.trace("handleDialogOk()");
        if (isInputValid()) {
            //company.setCompanyLabel(lblCompany.getText());
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * EventHandler, cancel is clicked
     */
    @FXML
    private void handleDialogCancel() {
        LOGGER.trace("handleDialogCancel()");
        dialogStage.close();
    }

    /**
     * Verify input
     * @return ok/nok
     */
    private boolean isInputValid() {
        LOGGER.debug("isInputValid()");
        String errorMessage = "";
        //if (lblCompany.getText() == null || lblCompany.getText().length() == 0) {
        //    errorMessage += "No valid company name!\n";
        //}
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }


}
