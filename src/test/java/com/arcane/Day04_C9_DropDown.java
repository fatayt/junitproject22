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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day04_C9_DropDown {
    //Go to https://the-internet.herokuapp.com/dropdown
    //1.selectByIndexTest methodu olustur ve selectByIndex() kullanarak Select Option 1 yapin
    //2.selectByValueTest methodu olustur ve selectByValue() kullanarak Select Option 2 yapin
    //3.selectByVisibleTextTest  methodu olustur ve visibleText() kullanarak Select Option 1 yapin
    //4.printAllTest methodu olusturun ve tum dropdown value (degerlerini) yazdirin
    //5.printFirstSelectedOptionTest methodu olusturun ve birinci secilen option'i yazdirin
    // Secili option'in "Please select an Option" oldugunu verify et
    //6.sizeTest methodu olusturun ve dropdown size'ini bulun
    // dropdown size'ini bulun, eger dropdown'da 4 element yok ise "Beklenen Acutual'a esit degildir" yazdirin.
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    //1.selectByIndexTest methodu olustur ve selectByIndex() kullanarak Select Option 1 yapin
    @Test
    public void selectByIndexTest(){
        //1.Adim dropdown elementlerini locate et
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        //2.Select object olustur.
        Select select = new Select(dropDown);
        //3. method'dan herhangi birini kullanarak element bulun ==> selectByIndex, selectByValue, selectByVisibleText
        select.selectByIndex(1);
    }
    //2.selectByValueTest methodu olustur ve selectByValue() Select Option 2 yapin.
    @Test
    public void selectByValueTest(){
        //1.Adim dropdown elementlerini locate et
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        //2.Select object olustur.
        Select select = new Select(dropDown);
        //3. method'dan herhangi birini kullanarak element bulun ==> selectByIndex, selectByValue, selectByVisibleText
        select.selectByValue("2");
        //3.selectByVisibleTest methodu olustur ve VisibleTest() Select Option 1 yapin.
    }
    @Test
    public void selectByVisibleTest(){
        //1.Adim dropdown elementlerini locate et
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //2.Select object olustur.
        Select select = new Select(dropdown);
        //3. method'dan herhangi birini kullanarak element bulun ==> selectByValue, '
        select.selectByVisibleText("Option 1");
    }
    //4.printAllTest methodu olusturun ve tum dropdown value (degerlerini) yazdirin
    @Test
    public void printAllTest(){
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select select= new Select(dropDown);
        //getOptions()==> dropdown'daki tum secenekleri bir List <WebElement> olarak dondurur
        List<WebElement> tumSecenekler = select.getOptions();

        //Her bir elementi tek tek yazdirmak icin loop kullaniriz
        for (WebElement HerBirSecenek: tumSecenekler){
            System.out.println(HerBirSecenek.getText());
        }


    }
    //5.printFirstSelectedOptionTest methodu olusturun ve birinci secilen option'i yazdirin
    @Test
    public void printFirstSelectedOptionTest(){
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select select= new Select(dropDown);
        WebElement ilkSecilenSecenek = select.getFirstSelectedOption();
        System.out.println(ilkSecilenSecenek.getText());
        // Secili option'in "Please select an Option" oldugunu verify et
        Assert.assertEquals("Please select an option",ilkSecilenSecenek.getText());
    }
    //6.sizeTest methodu olusturun ve dropdown size'ini bulun
    @Test
    public void sizeTest(){
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDown);
        List<WebElement> tumSecenekler = select.getOptions();
        int size = tumSecenekler.size();
        // dropdown size'ini bulun, eger dropdown'da 4 element yok ise "Beklenen Acutual'a esit degildir" yazdirin.
        Assert.assertEquals("Beklenen Acutual'a esit degildir",3,size);


    }
    @After
    public void tearDown(){
        driver.close();
    }


}