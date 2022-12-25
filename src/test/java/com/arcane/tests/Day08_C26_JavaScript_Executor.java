package com.arcane.tests;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.TreeMap;

public class Day08_C26_JavaScript_Executor extends TestBase {
    /*
    Kullanici aplicasyonun Url (websayfasi)'ine gider
    Sayfada "Have a Questions?" text'ini verify et
     */

    @Test
    public void scrollIntoView() throws InterruptedException {
        driver.get("http://www.carettahotel.com/");
        Thread.sleep(3000);
        //driver.findElement(By.id());
        Thread.sleep(3000);
        //driver.findElement();

        //elementi asagi kaydir
        WebElement question = driver.findElement(By.xpath("//*[.='Have a Questions?']"));

        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", question);

        Thread.sleep(3000);
        Assert.assertEquals(question.getText(), "Have a Questions?");


    }

}
