package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_C4_Xpath {
    // email adresi xpath ile locate et ==> "https://www.testyou.in/Login.aspx"
    // password'u xpath ile locate et
    // Login'i xpath ile locate et
    // log out'u xpath ile locate et

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void xpathTest(){
        driver.get("https://www.testyou.in/Login.aspx");
        // email addresini xpath locate et
        driver.findElement(By.xpath("//input[@name='ctl00$CPHContainer$txtUserLogin']")).sendKeys("aykut.arcanedata@gmail.com");

        //sifre (password) xpath locate et
        driver.findElement(By.xpath("//input[@id='ctl00_CPHContainer_txtPassword']")).sendKeys("Aykut123!");

        //login xpath locate et
        driver.findElement(By.xpath("(//input[@type='submit'])[3]")).click();

        // log out'u xpath ile locate et
        driver.findElement(By.xpath("//a[@class='signout']")).click();
    }

    @After
    public void tearDown(){
        driver.close();

    }
}