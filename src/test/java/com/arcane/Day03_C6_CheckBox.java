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

import java.util.concurrent.TimeUnit;

public class Day03_C6_CheckBox {
        /*
  Test method olusturun ve asagidaki task'i tamamlayin.
  https://the-internet.herokuapp.com/checkboxes gidin
  checkbox elementlerini bulun
  Ardindan eger checkbox1 secilMemis ise click/check edin
  Ardindan eger checkbox2 secilMEmis ise click/check edin
  Ardindan checkbox1 ve checkbox2'nin checked oldugunu verify edin
   */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void checkBox() throws InterruptedException {
//        https://the-internet.herokuapp.com/checkboxes gidin
        driver.get("https://the-internet.herokuapp.com/checkboxes");
//        checkbox elementlerini bulun
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        Ardindan eger checkbox1 secilMemis ise click/check edin
        Thread.sleep(5000);
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
//        Thread.sleep(5000);
//        Ardindan eger checkbox2 secilMEmis ise click/check edin
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }

//        Ardindan checkbox1 ve checkbox2'nin checked oldugunu verify edin
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected());

    }
    @After
    public void tearDown(){
        driver.close();
    }


}