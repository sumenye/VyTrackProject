package tests.cybertek.MuhtarsClasses;

import tests.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FaceBookDropDowns {

    //Topic: Select class
    //
    //            Select class is used for handling drop down boxes with tagname of Select
    //
    //            declaration of select class:
    //                        Select variableName= new Select(WebElement of Drop down box);
    //
    //            Methods of Select class:
    //                        selectByindex(int):   selects the options in drop down box by the index number
    //                        selectByValue(String):  selects the options in drop down box by the value
    //                        selectByvisibletext(String): selects the options in drop down box by visibletext
    //                        getoptions(): returns list of WebElements, returns all the options

    public static void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.facebook.com");

        SeleniumUtils.waitPlease(3);

        WebElement monthDB = driver.findElement(By.xpath("/select[@aria-labe;='Month']"));
        Select month = new Select(monthDB);

        //select by index
        month.selectByIndex(5);

        SeleniumUtils.waitPlease(3);
        //select by value
        month.selectByValue("11");

        SeleniumUtils.waitPlease(3);
        //select by visible text
        month.selectByVisibleText("Sep");

        List<WebElement> list1 = month.getOptions();
        WebElement september = list1.get(9);
        System.out.println(september.isSelected());



    }

    public static  void test2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://www.facebook.com");

        SeleniumUtils.waitPlease(3);

        WebElement yearDB = driver.findElement(By.name("birthday_year"));
        Select year = new Select(yearDB);
        year.selectByVisibleText("1909");

        SeleniumUtils.waitPlease(3);
        List<WebElement> list = year.getOptions();
        WebElement Y1909 = null;
        for(WebElement each : list){
            if(each.getText().equals("1909"))
                 Y1909=each;
        }
        System.out.println(Y1909.isSelected());
    }
}
