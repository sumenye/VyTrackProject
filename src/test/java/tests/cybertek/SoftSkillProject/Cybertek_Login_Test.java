package tests.cybertek.SoftSkillProject;

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

import javax.swing.*;

public class Cybertek_Login_Test {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void setUp(){
        driver.get("http://practice.cybertekschool.com/login");
    }

    @Test
    public void test(){
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/div/input"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/div/input"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"wooden_spoon\"]"));
        userName.sendKeys("username");
        password.sendKeys("password");
        loginButton.click();

        String message = driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
        String expected = "Your username is invalid!";
        System.out.println("actual text: "+message);
        System.out.println("expected text: "+expected);


        Assert.assertTrue(message.contains(expected));
    }


    @AfterMethod
    public void close(){

        driver.quit();
    }

}
