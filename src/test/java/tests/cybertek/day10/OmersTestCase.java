package tests.cybertek.day10;

import tests.cybertek.utilities.BrowserFactory;
import tests.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class OmersTestCase {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
        searchbox.sendKeys("hafsa cetintas", Keys.ENTER);
        SeleniumUtils.waitPlease(7);
        driver.close();



    }

}
