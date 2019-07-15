package com.vytrack.tests.smoke_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.cybertek.OfficeHours.library;

import java.util.concurrent.TimeUnit;

public class MenuOptionsTest {
    //credentials--> user160, UserUser123 truck driver
    //storemanager93, salesmanager258
    WebDriver driver;


    @BeforeGroups(groups = {"a"})
    public void setUp1(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        library.sleep(5);

        WebElement userName = driver.findElement(By.name("_username"));
        library.sleep(5);
        userName.sendKeys("user160");
        library.sleep(2);
        WebElement password = driver.findElement(By.name("_password"));
        library.sleep(5);
        password.sendKeys("UserUser123");
        library.sleep(2);
        WebElement loginButton = driver.findElement(By.name("_submit"));
        loginButton.click();
    }

    @Test(groups = {"a"})
    public void test1() {
        library.sleep(5);
        WebElement fleet = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/a/span"));
        library.sleep(5);
        fleet.click();
        WebElement vehicle = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/div/div/ul/li[3]/a/span"));
        library.sleep(3);
        vehicle.click();
        library.sleep(3);
        String actual = driver.getTitle().trim();
        String expected="Car - Entities - System - Car - Entities - System";
        library.sleep(3);
        System.out.println("actual title: "+actual);
        System.out.println("expected title: "+expected);

        WebElement actualName=driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div/div[1]/div/h1"));
        String actualname = actualName.getText();
        String expectedName="Cars";
        System.out.println("actual name: "+actualname);
        System.out.println("expected name: "+expectedName);
        Assert.assertEquals(actual,expected);
        Assert.assertEquals(actualname,expectedName);
    }
    @Test(groups = {"a"})
    public void test2() {

        WebElement customer = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/a/span"));
        library.sleep(3);
        customer.click();
        WebElement accounts = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/div/div/ul/li[3]/a/span"));
        library.sleep(3);
        accounts.click();
        library.sleep(5);
        String actual = driver.getTitle().trim();
        String expected="Accounts - Customers";
        library.sleep(5);
        System.out.println("actual title: "+actual);
        System.out.println("expected title: "+expected);

        WebElement actualName=driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div/div[1]/div/h1"));
        String actualname = actualName.getText();
        String expectedName="Accounts";
        System.out.println("actual name: "+actualname);
        System.out.println("expected name: "+expectedName);
        Assert.assertEquals(actual,expected);
        Assert.assertEquals(actualname,expectedName);

    }
    @Test(groups = {"a"})
    public void test3() {

        WebElement customer = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/a/span"));
        library.sleep(3);
        customer.click();
        WebElement contacts = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/div/div/ul/li[4]/a/span"));
        library.sleep(3);
        contacts.click();
        library.sleep(5);
        String actual = driver.getTitle().trim();
        String expected="Contacts - Customers";
        library.sleep(5);
        System.out.println("actual title: "+actual);
        System.out.println("expected title: "+expected);

        WebElement actualName=driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div/div[1]/div/h1"));
        String actualname = actualName.getText();
        String expectedName="Contacts";
        System.out.println("actual name: "+actualname);
        System.out.println("expected name: "+expectedName);
        Assert.assertEquals(actual,expected);
        Assert.assertEquals(actualname,expectedName);

    }
    @Test(groups = {"a"})
    public void test4() {

        WebElement activities = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[3]/a/span"));
        library.sleep(3);
        activities.click();
        WebElement calenderEvents = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[3]/div/div/ul/li[3]/a/span"));
        library.sleep(3);
        calenderEvents.click();
        library.sleep(5);
        String actual = driver.getTitle().trim();
        String expected="Calendar Events - Activities";
        library.sleep(5);
        System.out.println("actual title: "+actual);
        System.out.println("expected title: "+expected);

        WebElement actualName=driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div/div[1]/div/h1"));
        String actualname = actualName.getText();
        String expectedName="Calendar Events";
        System.out.println("actual name: "+actualname);
        System.out.println("expected name: "+expectedName);
        Assert.assertEquals(actual,expected);
        Assert.assertEquals(actualname,expectedName);

    }
    @AfterGroups(groups = {"a"})
    public void close1(){
        driver.quit();

    }

    @BeforeGroups(groups = {"b"})
    public void setUp2(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("http://qa2.vytrack.com/user/login");
        library.sleep(5);
        WebElement userName = driver.findElement(By.name("_username"));
        library.sleep(3);
        WebElement password = driver.findElement(By.name("_password"));
        library.sleep(3);
        WebElement loginButton = driver.findElement(By.name("_submit"));

        userName.sendKeys("storemanager93");
        password.sendKeys("UserUser123");
        library.sleep(5);
        loginButton.click();
    }

    @Test(groups = {"b"})
    public void maganertest1() {
        WebElement dashboard = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/a/span"));
        library.sleep(5);
        dashboard.click();
        WebElement dashboards = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/div/div/ul/li[3]/a/span"));
        library.sleep(5);
        dashboards.click();
        library.sleep(5);
        String actual = driver.getTitle().trim();
        String expected="Dashboard - Dashboards";
        library.sleep(5);
        System.out.println("actual title: "+actual);
        System.out.println("expected title: "+expected);

        WebElement actualName=driver.findElement(By.xpath("//*[@id='container']/div[2]/div[1]/div/div/div[1]/div/h1"));
        String actualname = actualName.getText();
        String expectedName="Dashboard";
        System.out.println("actual name: "+actualname);
        System.out.println("expected name: "+expectedName);
        Assert.assertEquals(actual,expected);
        Assert.assertEquals(actualname,expectedName);
    }
    @Test(groups = {"b"})
    public void maganertest2() {
        WebElement fleet = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/a/span"));
        library.sleep(3);
        fleet.click();
        WebElement vehicles = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]/div/div/ul/li[3]/a/span"));
        library.sleep(3);
        vehicles.click();
        library.sleep(5);
        String actual = driver.getTitle().trim();
        String expected="All - Car - Entities - System - Car - Entities - System";
        library.sleep(5);
        System.out.println("actual title: "+actual);
        System.out.println("expected title: "+expected);

        WebElement actualName=driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div/div[1]/div/div/div/div[1]/div/h1"));
        String actualname = actualName.getText();
        String expectedName="All Cars";
        System.out.println("actual name: "+actualname);
        System.out.println("expected name: "+expectedName);

        Assert.assertEquals(actual,expected);
        Assert.assertEquals(actualname,expectedName);
    }
    @Test(groups = {"b"})
    public void maganertest3() {
        library.sleep(7);

        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Customers')]")).click();
        library.sleep(7);
        driver.findElement(By.xpath("//li[@class='dropdown-menu-single-item first']//span[@class='title title-level-2'][contains(text(),'Accounts')]")).click();
        library.sleep(7);
        String expectedTitle = "All - Accounts - Customers";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        System.out.println("expectedTitle: "+expectedTitle);
        System.out.println("actualTitle: "+actualTitle);
        String expectedName = "All Accounts";
        String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedName, actualName);
        System.out.println("expectedName: "+expectedName);
        System.out.println("actualName: "+actualName);

    }
    @Test(groups = {"b"})
    public void maganertest4() {
        library.sleep(7);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Customers')]")).click();
        library.sleep(5);
        driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
        library.sleep(5);
        String expectedTitle = "All - Contacts - Customers";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        String expectedName = "All Contacts";
        String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedName, actualName);
    }
    @Test(groups = {"b"})
    public void maganertest5() {
        library.sleep(7);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Sales')]")).click();
        library.sleep(7);
        driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Opportunities')]")).click();
        library.sleep(7);
        String expectedTitle = "Open Opportunities - Opportunities - Sales";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        String expectedName = "Open Opportunities";
        String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedName, actualName);

    }
    @Test(groups = {"b"})
    public void maganertest6() {
        library.sleep(7);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]")).click();
        library.sleep(7);
        driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Calls')]")).click();
        library.sleep(7);
        String expectedTitle = "All - Calls - Activities";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        String expectedName = "All Calls";
        String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedName, actualName);

    }
    @Test(groups = {"b"})
    public void maganertest7() {
        library.sleep(7);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]")).click();
        library.sleep(7);
        driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Calendar Events')]")).click();
        library.sleep(7);
        String expectedTitle = "All - Calendar Events - Activities";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        String expectedName = "All Calendar Events";
        String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    @AfterGroups(groups = {"b"})
    public void close2(){
        driver.quit();

    }


}

