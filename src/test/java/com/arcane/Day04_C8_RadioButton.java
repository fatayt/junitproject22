package com.arcane;

import com.fasterxml.jackson.core.json.PackageVersion;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day04_C8_RadioButton {
    /*
    Test method olusturun ve asagidaki task'i tamamlayin.
    https://www.facebook.com/ adresine gidin
    Create an Account button'una click edin
    Radio button'larin elementlerini locate edin
    Ardindan eger cinsiyet secili degilse radio button'a click ederek secin
    Sing Up buttonuna click edip hesap olusturun
    */
    Faker faker = new Faker();
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void radioButton() throws InterruptedException {

//      https://www.facebook.com/ adresine gidin
        driver.get("https://www.facebook.com/");
//      Create an Account button'una click edin
        Thread.sleep(3000);
        driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();
        // zorunlu alanlari girmem lazim
        Thread.sleep(3000);
        // firstname ==> isim
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName());
        Thread.sleep(3000);
        //lastname => soyisim
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());
        Thread.sleep(3000);
        //email adresi
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(faker.internet().emailAddress());
        Thread.sleep(3000);
        //email dogrulama isterse

        //sifre ==password
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(faker.internet().password());
        Thread.sleep(3000);
        //dogum tarihi
        //gun
        WebElement gun = driver.findElement(By.xpath("//select[@name='birthday_day']"));
        Select gunDropDown = new Select(gun);
        gunDropDown.selectByValue("21");
        //ay
        WebElement ay = driver.findElement(By.xpath("//select[@name='birthday_month']"));
        Select ayDropDown = new Select(ay);
        ayDropDown.selectByVisibleText("Haz");
        //yil
        WebElement yil = driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select yilDropDown = new Select(yil);
        yilDropDown.selectByValue("1998");
        Thread.sleep(3000);

//        Radio button'larin elementlerini locate edin
        WebElement maleSecenek = driver.findElement(By.xpath("//input[@type='radio'] and @value='2']"));
        WebElement femaleSecenek = driver.findElement(By.xpath("//input[@type='radio'] and @value='1']"));
        // Ardindan eger cinsiyet secili degilse radio button'a click ederek secin
        if (!maleSecenek.isDisplayed()) {
            maleSecenek.click();
        }
        // Sing Up buttonuna click edip hesap olusturun
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
    }


    @After
    public void tearDown() {
        driver.close();

    }

}