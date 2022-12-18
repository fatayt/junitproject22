package com.arcane;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

//        1. Create a class HesapOlusturma

public class Day04_C10_HesapOlusturma {
    /*
    Zorunlu tum alanlari doldurun ve Hesap olusturmanin basarili oldugunu verify edin
1. Create a class HesapOlusturma
2. Go to https://www.automationexercise.com/
3. Signup/Login link'ine click edin
4. Isim ve email adresinizi girin ardindan  Signup button"una click edin
5. Text'i Verify et : ENTER ACCOUNT INFORMATION
6. Text'i Verify et : ADDRESS INFORMATION
7. Text'i Verify et : Title
8. title'i secin
9. Name girin (var olani degistir)
10. Password girin
11. Date of Birth (dogum tarihi) girin
12. Sign up for our newsletter! click edin
13. Receive special offers from our partners! click edin
14. first name girin
15. last name girin
16. company girin
17. Address girin
18. Country secin
19. State girin
20. City girin
21. ZipCode girin
22. mobile phone girin
23. Create Account'u Click edin
24. Ardindan MY ACCOUNT'un sayfada bulundugunuzu verifey edin
     */
    Faker faker = new Faker();

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void HesapOlusturma () throws InterruptedException {


//        2. Go to https://www.automationexercise.com/
        driver.get("https://www.automationexercise.com/");

//        3. Signup/Login link'ine click edin
        driver.findElement(By.partialLinkText("Login")).click();

//        4. Isim ve email adresinizi girin ardindan  Signup button"una click edin
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

//        5. Text'i Verify et : ENTER ACCOUNT INFORMATION
        WebElement eAccountInformation = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(eAccountInformation.isDisplayed());

//        6. Text'i Verify et : ADDRESS INFORMATION
        WebElement aInformation = driver.findElement(By.xpath("//*[text()='Address Information']"));
        Assert.assertTrue(aInformation.isDisplayed());

//        7. Text'i Verify et : Title
        WebElement title = driver.findElement(By.xpath("//*[text()='Title']"));
        Assert.assertTrue(title.isDisplayed());

//        8. title'i secin
        WebElement mrSelect = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        mrSelect.click();
//        9. Name girin (var olani degistir)
        driver.findElement(By.xpath("//input[@name='name']")).clear();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(faker.name().firstName());

//        10. Password girin
        driver.findElement(By.id("password")).sendKeys("Fat97.");
//        11. Date of Birth (dogum tarihi) girin
        WebElement dayS = driver.findElement(By.xpath("//select[@id='days' and @name='days']"));
        Select daySelect = new Select(dayS);
        daySelect.selectByValue("5");

        WebElement monthS = driver.findElement(By.xpath("//select[@id='months' and @name='months']"));
        Select monthSelect = new Select(monthS);
        monthSelect.selectByValue("6");

        WebElement yearS = driver.findElement(By.xpath("//select[@id='years' and @name='years']"));
        Select yearSelect = new Select(yearS);
        yearSelect.selectByValue("2000");

//    12. Sign up for our newsletter! click edin
        WebElement newsletter = driver.findElement(By.xpath("//*[@for='newsletter']"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (!newsletter.isSelected()){
            newsletter.click();
        }

//    13. Receive special offers from our partners! click edin
        WebElement offers = driver.findElement(By.xpath("//*[@for='optin']"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (!offers.isSelected()){
            offers.click();
        }

        Thread.sleep(3000);
//        14. first name girin
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(faker.name().firstName());

//        15. last name girin
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(faker.name().lastName());

//        16. company girin
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(faker.company().name());

//        17. Address girin
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(faker.address().zipCode());

//        18. Country secin
        WebElement coutrY = driver.findElement(By.xpath("//select[@id='country']"));
        Select coutrySelect = new Select(coutrY);
        coutrySelect.selectByValue("United States");

//        19. State girin
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys(faker.address().state());

//        20. City girin
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().city());

//        21. ZipCode girin
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(faker.address().zipCode());

//        22. mobile phone girin
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys(faker.phoneNumber().cellPhone());
        Thread.sleep(10000);
//        23. Create Account'u Click edin
    //   driver.findElement(By.xpath("//button[@data-qa='create-account']")).submit();
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).submit();

//        24. Ardindan MY ACCOUNT'un sayfada bulundugunuzu verifey edin
        driver.findElement(By.linkText("Continue")).click();
        WebElement Logged = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(Logged.isDisplayed());
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
