package driverUtils;

public enum DriverType {
    LOCAL_CHROME("LOCAL_CHROME"),
    SELENOID_CHROME("SELENOID_CHROME");

    public final String driver;

    DriverType(String driver) {
        this.driver = driver;/// comment
    }
}
