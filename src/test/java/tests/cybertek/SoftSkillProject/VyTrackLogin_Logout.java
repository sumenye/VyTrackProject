package tests.cybertek.SoftSkillProject;

import tests.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VyTrackLogin_Logout {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void setUp(){
        driver.get("http://qa2.vytrack.com/");
    }

    @Test
    public void test(){

        WebElement userName = driver.findElement(By.name("_username"));
        WebElement password = driver.findElement(By.name("_password"));
        WebElement loginButton = driver.findElement(By.name("_submit"));

        userName.sendKeys("user160");
        password.sendKeys("UserUser123");
        loginButton.click();
        WebElement nameOnTopRight = driver.findElement(By.className("dropdown-toggle"));
        SeleniumUtils.waitPlease(10);
        nameOnTopRight.click();

        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[5]/a")).click();
        SeleniumUtils.waitPlease(10);
        String actualUrl = driver.getCurrentUrl();
        System.out.println("current url: "+actualUrl);

        Assert.assertTrue(actualUrl.contains("user/login"));
    }

    @AfterMethod
    public void close(){

        driver.quit();
    }

}

