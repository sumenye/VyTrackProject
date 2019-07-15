package com.vytrack.tests.components.login_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.cybertek.OfficeHours.library;
import tests.cybertek.utilities.VYTrackUtils;

import java.util.concurrent.TimeUnit;

public class PageAccessTest {

    WebDriver driver;

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
    public void testStoreManager() {

     VYTrackUtils.login(driver,"storemanager85","UserUser123");
       driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/a/span")).click();
        WebElement vehicles = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[6]/a/span"));
        Assert.assertEquals(vehicles.getText().trim(),"Vehicle Contracts");
}
    @Test
    public void testSalesManager() {
        VYTrackUtils.login(driver,"salesmanager258","UserUser123");
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/a/span")).click();
        WebElement vehicles = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[6]/a/span"));
        Assert.assertEquals(vehicles.getText().trim(),"Vehicle Contracts");
    }
    @Test
    public void testTruckDriver() {
        VYTrackUtils.login(driver,"user160","UserUser123");
        library.sleep(2);
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[6]/a/span")).click();
        String actual= driver.findElement(By.xpath("//div[text()='You do not have permission to perform this action.']")).getText();
        library.sleep(2);
        String expected = "You do not have permission to perform this action.";
        Assert.assertEquals(actual,expected);
    }

    @AfterMethod
    public void close2(){
        driver.quit();
    }
}
