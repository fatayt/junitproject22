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

public class Day06_C12_IFrame {
    /*
    method olustur: iframeTest
    https://the-internet.herokuapp.com/iframe adresine git
    Bolded/kalin yazilan text'in “Editor” kelimesii contain/icerdigini verify et
    text box'i locate et
    text box icindeki text'i sil
    “This text box is inside the iframe” yaz
    Elemental Selenium text'in sayfada gosterildigini/displayed verify et
    */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @Test
    public void iframeTest(){
        //Bolded/kalin yazilan text'in “Editor” kelimesii contain/icerdigini verify et
        String boldedText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(boldedText.contains("Editor"));

        //text box'i locate et
        //1.yol iframe gecis icin index kullanma ==> indexler 0`dan baslar
       // String textBox = driver.switchTo().frame(1);
        //2.yol iframe gecis icin id/name value kullanma
       // driver.switchTo().frame("mce_0_ifr");
        //3.yol iframe gecis icin WebElement kullanma
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElement);

        //text box icindeki text'i sil
        WebElement textBox = driver.findElement(By.xpath("//p"));
        //clear() box icindeki text veya metni siler
        textBox.clear();

        //“This text box is inside the iframe” yaz
        textBox.sendKeys("This text box is inside the iframe");

        //Elemental Selenium text'in sayfada gosterildigini/displayed verify et
        // Elemental Selenium iFrame disindadir
        // parent frame e gecis lazim
        driver.switchTo().parentFrame();
        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
    }
    @After
    public void tearDown(){
        //close method
        driver.close();
    }
}
