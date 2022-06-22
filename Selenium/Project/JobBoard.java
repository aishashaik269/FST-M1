package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class JobBoard {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void launchBrowser()
    {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://alchemy.hguy.co/jobs/");
    }
    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }
    @Test
    public void activity1() throws InterruptedException
    {
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(2000);
        Assert.assertEquals(title, "Alchemy Jobs – Job Board Application");
    }
    @Test
    public void activity2() throws InterruptedException
    {
        String headingTitle = driver.findElement(By.className("entry-title")).getText();
        System.out.println(headingTitle);
        Thread.sleep(2000);
        Assert.assertEquals(headingTitle, "Welcome to Alchemy Jobs");
    }
    @Test
    public void activity3() throws InterruptedException
    {
        WebElement url = driver.findElement(By.xpath("//*[@id='post-16']/header/div/img"));
        System.out.println("Url of the image" + url.getAttribute("src"));
    }
    @Test
    public void activity4() throws InterruptedException
    {
        String heading2 = driver.findElement(By.xpath("//h2[text()='Quia quis non']")).getText();
        System.out.println(heading2);
        Thread.sleep(2000);
        Assert.assertEquals(heading2, "Quia quis non");
    }
    @Test
    public void activity5() throws InterruptedException
    {
        driver.findElement(By.xpath("//a[text()='Jobs']")).click();
        Thread.sleep(2000);
        String pageJob = driver.getTitle();
        System.out.println(pageJob);
        Assert.assertEquals(pageJob, "Jobs – Alchemy Jobs");
    }
    @Test
    public void activity6() throws InterruptedException
    {
        driver.findElement(By.xpath("//a[text()='Jobs']")).click();
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.id("search_keywords"));
        search.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        search.sendKeys("Banking");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Search Jobs']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        WebElement element= driver.findElement(By.xpath("//ul[@class='job_listings']//li//h3[text()='Banking']"));
        wait = new WebDriverWait (driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='job_listings']//li//h3[text()='Banking']")));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
        String email=driver.findElement(By.xpath("//a[text()='abcqqwe@gmail.com']")).getText();
        System.out.println(email);
    }
    @Test
    public void activity7() throws InterruptedException
    {
        driver.findElement(By.xpath("//a[text()='Post a Job']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("create_account_email")).sendKeys("aishaak@test.com");
        driver.findElement(By.id("job_title")).sendKeys("FST");
        //driver.switchTo().frame("job_description_ifr");
        WebElement Description = driver.findElement(By.xpath("//iframe[contains(@id, 'job_description_ifr')]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        Description.sendKeys("Test FST description");
        // driver.switchTo().defaultContent();
        driver.findElement(By.id("application")).sendKeys("https://alchemy.hguy.co/jobs/post-a-job/");
        driver.findElement(By.id("company_name")).sendKeys("IBM");
        driver.findElement(By.xpath("//input[@value='Preview']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.findElement(By.id("job_preview_submit_button")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.findElement(By.xpath("//a[text()='click here']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        String JobTitle=  driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
        Assert.assertEquals(JobTitle,"FST");
    }

}
