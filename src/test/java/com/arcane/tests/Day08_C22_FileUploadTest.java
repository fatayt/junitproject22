package com.arcane.tests;

import com.arcane.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day08_C22_FileUploadTest extends TestBase {
    /*
    1- Method : fileUploadTest
    2- https://the-internet.herokuapp.com/upload linkine git
    3- Kullanici masaustunden bir resim secer
    4- upload button'a tikla
    5- Ardindan "File Uploaded!" mesajinin gosterildigini (displayed) verify et
     */
    @Test
    public void fileUploadTest(){

//        2- https://the-internet.herokuapp.com/upload linkine git
          driver.get("https://the-internet.herokuapp.com/upload");

//        3- Kullanici masaustunden bir resim secer
        //homepath al
        String homePath = System.getProperty("user.home");
        String cicekPath = homePath + "\\Desktop\\cicek.jpg";

        WebElement fileUpload = driver.findElement(By.id("file-upload"));

        fileUpload.sendKeys(cicekPath);
//        4- upload button'a tikla
        driver.findElement(By.id("file-submit")).click();

//        5- Ardindan "File Uploaded!" mesajinin gosterildigini (displayed) verify et
        WebElement fileUploaded = driver.findElement(By.xpath("//h3[.='File Uploaded!']"));
        Assert.assertTrue(fileUploaded.isDisplayed());
    }
}
