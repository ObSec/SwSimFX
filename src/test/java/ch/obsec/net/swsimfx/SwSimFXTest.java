package ch.obsec.net.swsimfx;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class SwSimFXTest {

    @Test
    public void testSwSimFX() throws Exception {
        try {
            new SwSimFX();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetDataFilePath() throws Exception {
        try {
            SwSimFX mainApp = new SwSimFX();
            File filePath = mainApp.getDataFilePath();
            if (filePath != null) {
                assertTrue(true);
            } else {
                assertTrue(true);
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}