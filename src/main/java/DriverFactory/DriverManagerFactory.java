package DriverFactory;



public class DriverManagerFactory {
    public static DriverManager driverManager;
    public enum DriverType{CHROME, FIREFOX, EDGE, IE};

    public static DriverManager getDriverManager(DriverType type) {
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }

}

