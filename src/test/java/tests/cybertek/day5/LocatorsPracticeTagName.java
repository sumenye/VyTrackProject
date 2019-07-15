package tests.cybertek.day5;

import tests.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsPracticeTagName {
    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception{
        test1();
        //here we will execute our tests
        //we will create seperate method for every test
    }
    //TASK: FIND ALL BUTTONS, put them in the list, and click on them one by one.
    public static void test1() throws Exception{
        driver.manage().window().fullscreen();
        //selenium will wait up to 30 seconds to find the element
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //HOW TO FIND ALL BUTTONS?
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("Size: "+buttons.size());//to get how many elements in the list
        for(WebElement button : buttons){

            System.out.println(button.getText());
            button.click();
            Thread.sleep(1000);
        }
        driver.close();

    }
}
