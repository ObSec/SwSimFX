package ch.obsec.net.swsimfx;

/**
 * @version 1.0
 * @since 1.0
 * @author mario.oberli@obsec.ch
 */
public class SSFglobal {

    private static final String SSFVERSION = "v1.0";
    private static final String SSFPRODUCT = "SwSimFX";

    public static String getVersion() {
        return SSFVERSION;
    }

    public static String getProduct() {
        return SSFPRODUCT;
    }

    public static String[] getSystemInfo() {
        String[] sysInfo = new String[2];
        sysInfo[0] = "Java " + System.getProperty("java.version") + " from " + System.getProperty("java.vendor");
        sysInfo[1] = System.getProperty("os.name") + " (" + System.getProperty("os.version") + ", " + System.getProperty("os.arch") + ")";
        return sysInfo;
    }
}
