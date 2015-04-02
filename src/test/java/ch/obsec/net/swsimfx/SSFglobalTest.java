package ch.obsec.net.swsimfx;

import org.junit.Test;

import static org.junit.Assert.*;

public class SSFglobalTest {

    @Test
    public void testGetVersion() throws Exception {
        if (SSFglobal.getVersion().equals("v1.2")) {
            assertTrue(true);
        } else {
            assertFalse(true);
        }
    }

    @Test
    public void testGetProduct() throws Exception {
        if (SSFglobal.getProduct().equals("SwSimFX")) {
            assertTrue(true);
        } else {
            assertFalse(true);
        }
    }

    @Test
    public void testGetSystemInfo() throws Exception {
        if (SSFglobal.getSystemInfo()[0] != null && SSFglobal.getSystemInfo()[1] != null) {
            assertTrue(true);
        } else {
            assertFalse(true);
        }
    }

}
