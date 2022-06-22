package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class JobBoardAdmin {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
    }
    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }

    @Test
    public void activity89() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Dashboard ‹ Alchemy Jobs — WordPress");
        System.out.println("Backend page title is " + pageTitle);
        Reporter.log("Backend page title is " + pageTitle);
        WebElement jobListing = driver.findElement(By.xpath("//div[contains(text(),'Job Listings')]"));
        jobListing.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement addNewBtn = driver.findElement(By.xpath("(//a[contains(text(),'Add New')])[7]"));
        addNewBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement closePopUp = driver.findElement(By.xpath("(//button[contains(@class,'components-button has-icon')])[5]"));
        closePopUp.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String jobPostTitle = "Test Job FST";
        WebElement positionTxtBx = driver.findElement(By.xpath("//textarea[contains(@id,'post-title-0')]"));
        positionTxtBx.sendKeys(jobPostTitle);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement publishBtn = driver.findElement(By.xpath("//button[contains(text(),'Publish…')]"));
        publishBtn.click();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement cnfPublishBtn = driver.findElement(By.xpath("//button[contains(@class,'components-button editor-post-publish-button editor-post-publish-button__button is-primary')]"));
        cnfPublishBtn.click();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement viewJob = driver.findElement(By.xpath("//a[contains(@class,'components-button is-secondary')]"));
        viewJob.click();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement expectedJobTitle = driver.findElement(By.xpath("//h1"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String jobTitle = expectedJobTitle.getText();
        Assert.assertEquals(jobTitle, jobPostTitle);
        System.out.println("Backend page title is " + jobTitle);
        Reporter.log("Backend page title is " + jobTitle);
    }

}


