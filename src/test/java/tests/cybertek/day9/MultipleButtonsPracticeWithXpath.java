package tests.cybertek.day9;

import tests.cybertek.utilities.BrowserFactory;
import tests.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleButtonsPracticeWithXpath {

    WebDriver driver;
    //only buttons from 1-5
    String buttons = "//button[starts-with(text(),'Button')]";
    String button1Locator= "//button[.='Button 1']";
    String button2locator = "//*[contains(@name,'button2')]";
    String button3Locator = "//button[starts-with(@id,'button_')]";
    String button4Locator = "//button[contains(text(),'Button 4')]";
    String button5Locator = "//button[5]";
    String button6locator = "//*[@id='disappearing_button']";

    String resultLocator = "//p[@id='result']";

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }

    @Test
    public void verifyButton3(){
        String expectedMessage = "Clicked on button three!";
        driver.findElement(By.xpath(button3Locator)).click();
        SeleniumUtils.waitPlease(2);
        String actualMessage = driver.findElement(By.xpath(resultLocator)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void verifyButton4(){
        String expectedMessage = "Clicked on button four!";
        driver.findElement(By.xpath(button4Locator)).click();
        SeleniumUtils.waitPlease(2);
        String actualMessage = driver.findElement(By.xpath(resultLocator)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void verifyButton6(){
        String expectedMessage = "Now it's gone!";

    }

    @AfterMethod
    public void tearDown(){
        driver.close();//to close browser after test
    }
}
