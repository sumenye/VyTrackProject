package tests.cybertek.day5;
import tests.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorsPracticeClassName {

    public static void main(String[] args) {


        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        List<WebElement> list=driver.findElements(By.className("list-group-item"));
        System.out.println(list.size());
        for (WebElement ele:list) {
            System.out.println(ele.getText());
        }
        driver.close();
    }
}
