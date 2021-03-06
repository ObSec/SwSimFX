package ch.obsec.net.swsimfx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.obsec.net.swsimfx.model.Device;
import ch.obsec.net.swsimfx.model.DataWrapper;
import ch.obsec.net.swsimfx.view.RootLayoutController;
import ch.obsec.net.swsimfx.view.WorkSpaceController;
import ch.obsec.net.swsimfx.view.DeviceEditDialogController;

/**
 * @version 1.1
 * @since 1.0
 * @author mario.oberli@obsec.ch
 */
public class SwSimFX extends Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwSimFX.class);
    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Device> deviceData = FXCollections.observableArrayList();

    /**
     * Entry point JavaFX
     * @param primaryStage JavaFX main stage
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        LOGGER.debug("start()");
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(SSFglobal.getProduct());
        this.primaryStage.getIcons().add(new Image("/images/SwSimFX.png"));
        initRootLayout();
        showWorkSpace();
    }

    /**
     * Initialize main window
     */
    public void initRootLayout() {
        LOGGER.debug("initRootLayout()");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SwSimFX.class.getResource("/fxml/RootLayout.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            primaryStage.show();
        } catch (IOException e) {
            LOGGER.warn("initRootLayout() failed: {}", e.getMessage());
            throw new RuntimeException(e);
        }
        File file = getDataFilePath();
        if (file != null) {
            loadDataFromFile(file);
        }
    }

    /**
     * Show the main part of the application
     */
    public void showWorkSpace() {
        LOGGER.debug("showWorkSpace()");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SwSimFX.class.getResource("/fxml/WorkSpace.fxml"));
            AnchorPane workSpace = loader.load();
            rootLayout.setCenter(workSpace);
            WorkSpaceController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            LOGGER.warn("showWorkSpace(): {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
    * getting path to data xml file
    * @return file
    */
    public File getDataFilePath() {
        LOGGER.debug("getDataFilePath()");
        Preferences prefs = Preferences.userNodeForPackage(SwSimFX.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    /**
     * setting path to data xml file
     * @param file path
     */
    public void setDataFilePath(File file) {
        LOGGER.debug("setDataFileFilePath()");
        Preferences prefs = Preferences.userNodeForPackage(SwSimFX.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());
            primaryStage.setTitle(SSFglobal.getProduct() + " " + SSFglobal.getVersion() + " - " + file.getName());
        } else {
            prefs.remove("filePath");
            primaryStage.setTitle(SSFglobal.getProduct() + " " + SSFglobal.getVersion());
        }
    }

    /**
     * load existing data xml file
     * @param file data to load
     */
    public void loadDataFromFile(File file) {
        LOGGER.debug("loadDataFromFile()");
        try {
            JAXBContext context = JAXBContext.newInstance(DataWrapper.class);
            Unmarshaller um = context.createUnmarshaller();
            DataWrapper wrapper = (DataWrapper) um.unmarshal(file);
            deviceData.clear();
            deviceData.addAll(wrapper.getDevice());
            setDataFilePath(file);
        } catch (Exception e) {
            LOGGER.warn("loadDataFromFile() file: {}",e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * save data to a xml file
     * @param file file to save data to
     */
    public void saveDataToFile(File file) {
        LOGGER.debug("saveDataToFile()");
        try {
            JAXBContext context = JAXBContext.newInstance(DataWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            DataWrapper wrapper = new DataWrapper();
            wrapper.setDevice(deviceData);
            m.marshal(wrapper, file);
            setDataFilePath(file);
        } catch (Exception e) {
            LOGGER.warn("saveCompanyDataToFile() failed: {}",e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public boolean showDeviceEditDialog(Device device) {
        LOGGER.debug("showDeviceEditDialog()");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SwSimFX.class.getResource("/fxml/DeviceEditDialog.fxml"));
            AnchorPane page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Device");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.getIcons().add(new Image("/images/edit.png"));
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            DeviceEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setDevice(device);
            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            LOGGER.warn("showDeviceEditDialog(): {}", e.getMessage());
            return false;
        }
    }

    /**
     * get our stage
     * @return primaryStage
     */
    public Stage getPrimaryStage() {
        LOGGER.debug("getPrimaryState()");
        return primaryStage;
    }

    /**
     * get a list of all companies
     * @return companies list
     */
    public ObservableList<Device> getDeviceData() {
        LOGGER.debug("getDeviceData()");
        return deviceData;
    }

    /**
     * main before JavaFX takes over
     * @param args anything to add?
     */
    public static void main(String[] args) {
        LOGGER.debug("main()");
        launch(args);
    }

}
