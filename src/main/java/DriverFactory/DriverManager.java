package DriverFactory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;
    public abstract WebDriver createWebDriver();

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver(){
        if(null == driver){
            createWebDriver();
        }

        return driver;

    }

}
