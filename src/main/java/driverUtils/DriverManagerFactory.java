package driverUtils;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DriverManagerFactory {

    public static final String DRIVER_TYPE = "driver.type";
    private static AbstractDriverManager driverManager;


    public static AbstractDriverManager getInstance() {
        if(driverManager == null || !driverManager.isRunning()) {
            driverManager = initDriverManager();
        }
        return driverManager;
    }

    private static AbstractDriverManager getManager(DriverType type) {
        switch (type) {
            case SELENOID_CHROME:
                return new SelenoidDriverManager();
            case LOCAL_CHROME:
                return new ChromeDriverManager();
            default:
                throw new NotImplementedException();
        }
    }

    private static AbstractDriverManager initDriverManager() {
        String driverType = System.getProperty(DRIVER_TYPE);
        if(driverType!= null) {
            return getManager(DriverType.valueOf(driverType));
        }
        return getManager(DriverType.LOCAL_CHROME);

    }
}
