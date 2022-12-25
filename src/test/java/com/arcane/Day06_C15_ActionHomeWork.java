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

public class Day06_C15_ActionHomeWork {

    /*
        test method olustur : hoverOver() and test the following scenario:
        1- Given kullanici  https://www.amazon.com/ adresine gider
        2- When kullanici “Account” linkini click eder
        3- When kullanici “language” actionunda "español-ES" click eder
        4- Then page title'in “Tu cuenta” icerdigini verify et
     */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void hoverOver() throws InterruptedException {
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

//        3- When kullanici “language” actionunda "español-ES" click eder

        //1.adim: action objesi olustur
        //Actions actionsHw = new Actions(driver);      //Yukarida olusturuldu

        //2.adim: uzerine gidecegimiz (hover Over) elementi locate et
        WebElement actionsHw = driver.findElement(By.id("icp-nav-flyout"));

        //3.adim: hover over yap
        actions.moveToElement(actionsHw).perform();

        WebElement language = driver.findElement(By.xpath("(//*[@dir='ltr'])[5]"));

        // Ardindan eger ES secili degilse radio button'a click ederek secin
        actions.moveToElement(language).perform();
        driver.findElement(By.partialLinkText("español")).click();
        Thread.sleep(3000);

//        4- Then page title'in “Tu cuenta” icerdigini verify et

        //1.yol: h1 tag name ile locate et
        WebElement TuCuenta = driver.findElement(By.tagName("h1"));
        Assert.assertEquals("Tu cuenta", TuCuenta.getText());

        //2.yol:partialLink text ile locate et
        //Assert.assertTrue(driver.findElement(By.partialLinkText("Tu cuenta")).isDisplayed());
        // calisiyor ancak aranan Link olmadigi icin bu scripti kullanmadim
    }
    @After
    public void tearDown(){
        //close method
        driver.close();
    }
}
