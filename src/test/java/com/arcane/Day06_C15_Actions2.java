package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Day06_C15_Actions2 {
/*
    test method olustur : hoverOver() and test the following scenario:
    1- Given kullanici  https://www.amazon.com/ adresine gider
    2- When kullanici “Account” linkini click eder
    3- Then page title'in “Your Account” icerdigini verify et
 */
WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void hoverOver(){
//        1- Given kullanici  https://www.amazon.com/ adresine gider
        driver.get("https://www.amazon.com/");

//        2- When kullanici “Account” linkini click eder
        //1.adim: action objesi olustur
        Actions actions = new Actions(driver);
        //2.adim: uzerine gidecegimiz (hover Over) elementi locate et
        WebElement accountLists = driver.findElement(By.id("nav-link-accountList"));
        //3.adim: hover over yap
        actions.moveToElement(accountLists).perform();
        driver.findElement(By.linkText("Account")).click();

//        3- Then page title'in “Your Account” icerdigini verify et
        Assert.assertTrue(driver.getTitle().contains("Your Account"));

    }

    @After
    public void tearDown(){
        //close method
        driver.close();
    }
}
