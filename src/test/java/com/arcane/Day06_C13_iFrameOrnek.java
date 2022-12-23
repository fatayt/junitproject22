package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day06_C13_iFrameOrnek {
    //mulakat sorusu: bir web sayfasi icerisinde iframe leri bulunuz
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://amazon.com");
    }
    @Test
    public void iFrameSayisi(){
   List<WebElement> iframeelement = driver.findElements(By.xpath("//iframe"));
    int iframesayisi = iframeelement.size();
        System.out.println(driver.findElements(By.xpath("//iframe")).size());

        driver.get("https://the-internet.herokuapp.com/iframe");
        System.out.println(driver.findElements(By.xpath("//iframe")).size());
        System.out.println(driver.findElements(By.tagName("iframe")).size());
    }
    @After
    public void tearDown(){
        //close method
        driver.close();
    }
}
