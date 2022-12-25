package com.arcane.tests;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day07_C20_synchronization2 extends TestBase {
        /*
    Method olustur: isEnabled
    https://the-internet.herokuapp.com/dynamic_controls adresine git
    enable Button'una tikla
    Mesajin “It's enabled!” oldugunu verify et
    Textbox'in enabled oldugunu verify et (textbox'ta yazi yazilabilir)
    Disable button'una tikla
    Mesajin “It's disabled!” oldugunu verify et
    Textbox'in disabled oldugunu verify et (textbox'ta yazi yazilamaz)

    NOTE: .isEnabled(); bir elementin enabled olup olmadigini check eder
     */
    @Test
    public void isEnabled(){
//        https://the-internet.herokuapp.com/dynamic_controls adresine git
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

//        enable Button'una tikla
        driver.findElement(By.xpath("//button[.='Enable']")).click();

//        Mesajin “It's enabled!” oldugunu verify et
        WebElement Enb = driver.findElement(By.id("message"));
        Assert.assertTrue(Enb.getText().equals("It's enabled!"));

//        Textbox'in enabled oldugunu verify et (textbox'ta yazi yazilabilir)
        WebElement enable = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(enable.isEnabled());

//        Disable button'una tikla
        driver.findElement(By.xpath("//button[.='Disable']")).click();

//        Mesajin “It's disabled!” oldugunu verify et
        WebElement Dis = driver.findElement(By.id("message"));
        Assert.assertTrue(Dis.getText().equals("It's disabled!"));

//        Textbox'in disabled oldugunu verify et (textbox'ta yazi yazilamaz)

       // 1.yol: disable oldugu dogrulanarak
        WebElement disable = driver.findElement(By.xpath("//input[@type='text' and @disabled]"));
        Assert.assertTrue(disable.isDisplayed());

       // 2.yol: enable oldugu yanlislanarak
        Assert.assertFalse(enable.isEnabled());
    }
}
