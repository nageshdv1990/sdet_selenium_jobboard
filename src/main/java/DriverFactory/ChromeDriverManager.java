package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    @Override
    public WebDriver createWebDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\NageshDaliVenugopal\\Documents\\IBM India\\Projects\\Architect\\Automation\\myportfolio\\src\\main\\java\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        this.driver = new ChromeDriver(options);
        return this.driver;
    }

}
