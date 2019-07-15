package brite_erp.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import tests.cybertek.utilities.SeleniumUtils;

public class BriteUtilities {

    private static String usernamelocator = "//*[@id='login']";
    private static String passwordLocator = "//*[@id='password']";


    public static void login(WebDriver driver, String username, String password){
        driver.findElement(By.xpath(usernamelocator)).sendKeys(username);
        driver.findElement(By.xpath(passwordLocator)).sendKeys(password, Keys.ENTER);
        SeleniumUtils.waitPlease(3);
    }

//    public static void navigateToModule(WebDriver driver, String module){
//        driver.findElement(By.xpath(firstEvent)).click();
//        SeleniumUtils.waitPlease(2);
//    }
}
