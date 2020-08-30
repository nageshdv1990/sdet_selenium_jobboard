package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {

    @Override
    public WebDriver createWebDriver(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\NageshDaliVenugopal\\Documents\\IBM India\\Projects\\Architect\\Automation\\myportfolio\\src\\main\\java\\drivers\\geckodriver.exe");
        this.driver = new FirefoxDriver();
        return driver;
    }

}
