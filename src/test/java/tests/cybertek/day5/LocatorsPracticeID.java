package tests.cybertek.day5;

import tests.cybertek.utilities.BrowserFactory;
import tests.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsPracticeID {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {
        // test1();
        test2();
    }

    //negative test, we will use id to locate element
    public static void test1() throws Exception {
        driver.manage().window().fullscreen();
        //selenium will wait 10 seconds for element
        //if, within 10 seconds, element will not show up
        //you will get NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");

        driver.findElement(By.id("woodenspoon")).click();
        Thread.sleep(3000);
        driver.quit();

    }

    public static void test2() throws Exception{
        driver.manage().window().fullscreen();
        //this is you must to use, otherwise you will be in trouble
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");
        Thread.sleep(3000);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);
        String expected ="Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();

        SeleniumUtils.verifyEquals(expected,actual);
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
