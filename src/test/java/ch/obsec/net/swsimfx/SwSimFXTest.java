package ch.obsec.net.swsimfx;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SwSimFXTest {

    protected SwSimFX mainApp;

    @Before
    public void setUp() {
        mainApp = new SwSimFX();
    }

    @Test
    public void testSwSimFX() throws Exception {
        try {
            new SwSimFX();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testInitRootLayout() throws Exception {

    }

    @Test
    public void testShowWorkSpace() throws Exception {

    }

    @Test
    public void testGetDataFilePath() throws Exception {
        mainApp.getDataFilePath();
    }

    @Test
    public void testSetDataFilePath() throws Exception {

    }

    @Test
    public void testLoadDataFromFile() throws Exception {

    }

    @Test
    public void testSaveDataToFile() throws Exception {

    }

    @Test
    public void testShowDeviceEditDialog() throws Exception {

    }

    @Test
    public void testGetPrimaryStage() throws Exception {
        mainApp.getPrimaryStage();
    }

    @Test
    public void testGetDeviceData() throws Exception {
        mainApp.getDataFilePath();
    }

}
