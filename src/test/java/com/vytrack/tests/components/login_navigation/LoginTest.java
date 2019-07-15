package com.vytrack.tests.components.login_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.cybertek.OfficeHours.library;
import tests.cybertek.utilities.VYTrackUtils;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;
    //credentials--> user160, UserUser123 truck driver
    //storemanager93, salesmanager258

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        library.sleep(2);
    }

    @Test
    public void positiveTest(){
        VYTrackUtils.login(driver, "storemanager85", "UserUser123");
        library.sleep(5);
        Assert.assertEquals(driver.getTitle().trim(),"Dashboard");
        library.sleep(2);
        VYTrackUtils.logout(driver);
        library.sleep(3);
        VYTrackUtils.login(driver, "salesmanager258", "UserUser123");
        library.sleep(5);
        Assert.assertEquals(driver.getTitle().trim(),"Dashboard");
        library.sleep(2);
        VYTrackUtils.logout(driver);
        library.sleep(3);
        VYTrackUtils.login(driver, "user160", "UserUser123");
        library.sleep(5);
        Assert.assertEquals(driver.getTitle().trim(),"Dashboard");
        library.sleep(2);
        VYTrackUtils.logout(driver);
    }

    @Test
    public void negativeTest(){
        String firstUrl=driver.getCurrentUrl();
        String firstTitle=driver.getTitle();
        VYTrackUtils.login(driver, "username", "password");
        library.sleep(2);
        String expectedMessage = "Invalid user name or password.";
        String lastUrl = driver.getCurrentUrl();
        String lastTitle=driver.getTitle();
        String actualMessage = driver.findElement(By.xpath("//*[@id='login-form']/fieldset/div[1]/div")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
        Assert.assertEquals(firstTitle,lastTitle);
        Assert.assertEquals(firstUrl,lastUrl);
    }

    @AfterMethod
    public void close(){
        driver.quit();

    }
}
