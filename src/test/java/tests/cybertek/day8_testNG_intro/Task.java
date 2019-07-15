package tests.cybertek.day8_testNG_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void test1() {
        String expected = "2019";
        String expected1 = "July";
        String expected2 = "7";
        WebElement year = driver.findElement(By.id("year"));
        Select selectYear = new Select(year);
        WebElement month = driver.findElement(By.id("month"));
        Select selectMonth = new Select(month);
        WebElement day = driver.findElement(By.id("day"));
        Select selectDay = new Select(day);
        String actualYear = selectYear.getFirstSelectedOption().getText();
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        String actualDay = selectDay.getFirstSelectedOption().getText();

        Assert.assertEquals(actualYear, expected);
        Assert.assertEquals(actualMonth, expected1);
        Assert.assertEquals(actualDay, expected2);
    }


        @AfterMethod
        public void tearDown() {
            driver.quit();
        }
    }

