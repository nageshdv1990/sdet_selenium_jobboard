package SeleniumProject;

import DriverFactory.DriverManager;
import DriverFactory.DriverManagerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class jobs {
    DriverManager driverManager;
    WebDriver driver;
    private WebDriverWait wait = null;


    @BeforeTest
    public void setup(){
        driverManager = DriverManagerFactory.getDriverManager(DriverManagerFactory.DriverType.CHROME);
        driver =driverManager.getDriver();
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        driver.manage().window().maximize();

    }

    @AfterTest
    public void tearDown(){
      //  driverManager.quitDriver();
    }

    @Test
    public void test8(){
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        String titleAdminLoggedInPage = driver.getTitle();
        System.out.println(titleAdminLoggedInPage);
        Assert.assertEquals(titleAdminLoggedInPage, "Dashboard ‹ Alchemy Jobs — WordPress");
    }

    @Test
    public void test9() throws InterruptedException {
        test8();



        System.out.println(driver.getTitle());
     //   driver.findElement(By.linkText("Job Listings")).click();
        //may require wait

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id=\"menu-posts-job_listing\"]/a/div[3]"))).click();
        System.out.println("Job listing button successfully clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add New"))).click();
        System.out.println("Add new job successfully clicked");


        //Fill the job application
        WebElement jobTitle = driver.findElement(By.cssSelector("textarea[id]"));
        jobTitle.sendKeys("API Engineer - Backend");
        WebElement joblocation = driver.findElement(By.cssSelector("input[name='_job_location']"));
        joblocation.sendKeys("Bangalore");
        WebElement companyName = driver.findElement(By.xpath("//input[@name=\"_company_name\"]"));
        companyName.sendKeys("IBM");

        WebElement publishButton = driver.findElement(By.xpath("//button[@class=\"components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary\"]"));
        publishButton.click();
        System.out.println("publish button clicked ");

        //confirming publishing
        WebElement confirmPublishButton = driver.findElement(By.xpath("//button[@class=\"components-button editor-post-publish-button editor-post-publish-button__button is-primary\"]"));
        confirmPublishButton.click();
        System.out.println("Confirmed");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"editor\"]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[1]/a")));
        WebElement getJobTitle = driver.findElement(By.xpath("//*[@id=\"editor\"]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div/div[1]/a"));
        System.out.println(getJobTitle.getText());
        Assert.assertEquals(getJobTitle.getText(), "API Engineer - Backend");

    }
}
