package ch.obsec.net.swsimfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.obsec.net.swsimfx.view.RootLayoutController;

/**
 * @version 1.0
 * @since 1.0
 * @author mario.oberli@obsec.ch
 */
public class SwSimFX extends Application{

    private static final Logger LOGGER = LoggerFactory.getLogger(SwSimFX.class);
    private Stage primaryStage;
    private BorderPane rootLayout;

    /**
     * Entry point JavaFX
     * @param primaryStage JavaFX main stage
     */
    @Override
    public void start(Stage primaryStage) {
        LOGGER.debug("start()");
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("SwSimFX");
        this.primaryStage.getIcons().add(new Image("/images/address_book_32.png"));
        initRootLayout();
        //showSwSimOverview();
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
        }
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
