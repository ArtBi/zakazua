package driverUtils;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DriverManagerFactory {

    public static final String DRIVER_TYPE = "test.driver.type";
    private static ThreadLocal<DriverManagerFactory> driverManager = ThreadLocal.withInitial(DriverManagerFactory::new);

    public static DriverManagerFactory getInstance() {
        return driverManager.get();
    }

    private AbstractDriverManager getManager(DriverType type) {
        switch (type) {
            case SELENOID_CHROME:
                return new SelenoidDriverManager();
            case LOCAL_CHROME:
                return new ChromeDriverManager();
            default:
                throw new NotImplementedException();
        }
    }

    public AbstractDriverManager getManager() {
        //TODO : This parameter should be passed through jenkins and POM file in Future
        String driverType = System.getProperty(DRIVER_TYPE);
        System.out.println("Run the following driver: " + driverType);
        if (driverType != null) {
            return getManager(DriverType.valueOf(driverType));
        }
        return getManager(DriverType.LOCAL_CHROME);

    }
}
