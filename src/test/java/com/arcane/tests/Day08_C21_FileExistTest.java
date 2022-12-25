package com.arcane.tests;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_C21_FileExistTest {
    /*
    Method: dosyaVarmi
    1- Masaustundeki bir dosyayi secin
    2- Bu dosyanin bilgisayarinizda bulunup bulunmadigini verify edin
    */
    @Test
    public void dosyaVarMi(){
        String homePath = System.getProperty("user.home");
        System.out.println(homePath);   //C:\Users\deneme
        // "C:\Users\deneme\Desktop\cicek.jpg"
        String cicekPath = homePath + "\\Desktop\\cicek.jpg";
        System.out.println(cicekPath);

        boolean varMi = Files.exists(Paths.get(cicekPath));
        Assert.assertTrue(varMi);

    }
}
