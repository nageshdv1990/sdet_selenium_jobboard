package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {

    @Override
    public WebDriver createWebDriver(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\NageshDaliVenugopal\\Documents\\IBM India\\Projects\\Architect\\Automation\\myportfolio\\src\\main\\java\\drivers\\msedgedriver.exe");
        this.driver = new EdgeDriver();
        return  driver;
    }

}
