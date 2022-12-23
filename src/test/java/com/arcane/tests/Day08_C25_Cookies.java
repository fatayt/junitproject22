package com.arcane.tests;

import com.arcane.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day08_C25_Cookies extends TestBase {
    /*
    Method: handleCookies
    -Amazon'a (https://www.amazon.com) git and tasks automate et
    1. Toplam cookies sayisini bul
    2. Tum cookies yazdir
    3. Cookies isimleriyle yazdir
    4. Yeni cookie ekle
    5. Cookie ismiyle sil
    6. Tum cookies sil
    */

    @Test
    public void handleCookies(){
//        -Amazon'a (https://www.amazon.com) git and tasks automate et
        driver.get("https://www.amazon.com");

//        1. Toplam cookies sayisini bul
       Set<Cookie> tumcookies = driver.manage().getCookies();
       System.out.println(tumcookies.size());

//        2. Tum cookies yazdir
        for (Cookie herbirEleman: tumcookies
             ) {
            System.out.println("Cookie ismi:   " + herbirEleman.getName());
            System.out.println("Cookie value:  " + herbirEleman.getValue());

        }

//        3. Cookies isimleriyle yazdir
        System.out.println("Cookie ismi seassion-id-time olan cookie:   " + driver.manage().getCookieNamed("session-id-time"));

//        4. Yeni cookie ekle
        Cookie cookieEkle = new Cookie("Favori Kekim", "incirli");
        //cookie ekle
        driver.manage().addCookie(cookieEkle);

        //tum cookie leri al ve sayisini yazdir
        tumcookies = driver.manage().getCookies();

        System.out.println(tumcookies.size());

//        5. Cookie ismiyle sil
        driver.manage().deleteCookieNamed("csm-hit");
        tumcookies = driver.manage().getCookies();
        System.out.println(tumcookies.size());

//        6. Tum cookies sil
        driver.manage().deleteAllCookies();
        tumcookies = driver.manage().getCookies();
        System.out.println(tumcookies.size());
    }
}
