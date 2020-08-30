package SeleniumProject;

import DriverFactory.DriverManager;
import DriverFactory.DriverManagerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Random;

import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    DriverManager driverManager;
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driverManager = DriverManagerFactory.getDriverManager(DriverManagerFactory.DriverType.CHROME);
        driver =driverManager.getDriver();
        driver.get("https://alchemy.hguy.co/jobs/");

    }

    @AfterTest
    public void tearDown(){
      //  driverManager.quitDriver();
    }

    @Test
    public void test1(){
        String pageTitle = driver.getTitle();
        Assert.assertEquals("Alchemy Jobs – Job Board Application", pageTitle);
    }

    @Test
    public void test2(){
        String heading =  driver.findElement(By.className("entry-title")).getText();
        Assert.assertEquals("Welcome to Alchemy Jobs",heading);
        if(heading=="Welcome to Alchemy Jobs"){
            System.out.println("Test passed"+heading);
        }
        else{
            System.out.println("Failed"+heading);
        }
    }

    @Test
    public void test3(){
        String url =  driver.findElement(By.tagName("img")).getAttribute("src");
        System.out.println(url);
    }

    @Test
    public void test4(){
        String heading2 = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(heading2,"Quia quis non");
    }

    @Test
    public void test5(){
        driver.findElement(By.id("menu-item-24")).click();
        String title2 = driver.getTitle();
        Assert.assertEquals("Jobs – Alchemy Jobs",title2);
        System.out.println(title2);
    }

    @Test
    public void test6() throws InterruptedException {
        driver.findElement(By.id("menu-item-24")).click();
        String title2 = driver.getTitle();
        Assert.assertEquals("Jobs – Alchemy Jobs",title2);
        System.out.println(title2);
        WebElement searchkeys =  driver.findElement(By.id("search_keywords"));
        searchkeys.sendKeys("API Engineer");
        driver.findElement(By.className("search_submit")).click();

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"post-7\"]/div/div/ul/li[1]")));

        driver.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/ul/li[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/article/div/div/div/div/input")));

        String title3 = driver.getTitle();
        System.out.println(title3);
        driver.findElement(By.xpath("//*[@id=\"main\"]/article/div/div/div/div/input")).click();
        String consoleMessage = driver.findElement(By.xpath("//*[@id=\"post-1288\"]/div/div/div/div[3]/div/p")).getText();
        Assert.assertEquals("To apply for this job please visit alchemy.hguy.co.", consoleMessage );
        System.out.println(consoleMessage);

    }


    @Test
    public void test7() throws InterruptedException {
        String jobTitle = new String("API Engineer"+new Date());
        System.out.println(jobTitle);
        driver.findElement(By.xpath("//*[@id=\"menu-item-26\"]/a")).click();

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu-item-26\"]/a")));
        driver.findElement(By.xpath("//*[@id=\"job_title\"]")).sendKeys(jobTitle);
        driver.findElement(By.id("job_location")).sendKeys("bangalore");
       // List<WebElement> jobType = driver.findElements(By.id("job_type"));
        Select jobType = new Select(driver.findElement(By.id("job_type")));
        jobType.selectByVisibleText("Temporary");

        driver.findElement(By.id("application")).sendKeys("nagesh@ibm.com");
        driver.findElement(By.id("company_name")).sendKeys("IBM");

        Random rand = new Random();
        String email = new String("n1"+rand.nextInt(500)+"@mail.com");
        driver.findElement(By.xpath("//input[@name='create_account_email']")).sendKeys(email);

        driver.switchTo().frame("job_description_ifr");
        WebElement content = driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        content.sendKeys("rest assured");
        driver.switchTo().defaultContent();
        WebElement submitButton = driver.findElement(By.xpath("//input[@name='submit_job']"));
        submitButton.click();
        System.out.println("new page");
        System.out.println(driver.getTitle());
        WebElement submitListing = driver.findElement(By.xpath("//input[@name='continue']"));
        submitListing.click();

        driver.findElement(By.xpath("//*[@id=\"post-5\"]/div/a")).click();
        System.out.println("navigated to job posting page");
        System.out.println(driver.getTitle());
        String postedJob = driver.findElement(By.xpath("//h1[@class=\"entry-title\"]")).getText();
        System.out.println(postedJob);
        Assert.assertEquals(jobTitle,postedJob);


    }

    @Test
    public void test8(){


    }



}
