package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_C1_FirstMavenClass {
    public static void main(String[] args) {
       // System.setProperty("driver Type", "Driver Path`i"); Maven da kullanilmayacak

        //crome driveri set et
        WebDriverManager.chromedriver().setup();

        //driver objesi olustur
        WebDriver driver = new ChromeDriver();

        //Ekrani kapla
        driver.manage().window().maximize();

        //amazona git
        driver.get("https://www.amazon.com");

        //browseri kapat
        driver.close();
    }
}
