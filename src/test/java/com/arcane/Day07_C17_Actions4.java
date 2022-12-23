package com.arcane;

import com.arcane.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Day07_C17_Actions4 extends TestBase {
    /*
    Test method olustur : scrollUpDown()
    1- Amazon'a git : https://www.amazon.com
    2- Sayfayi Scroll down (asagi kaydir) yap
    3- Sayfayi Scroll up (yukari kaydir) yap
    */
    @Test
    public void scrollUpDown() throws InterruptedException {
//
//        1- Amazon'a git : https://www.amazon.com
            driver.get("https://www.amazon.com");

//        2- Sayfayi Scroll down (asagi kaydir) yap
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.ARROW_DOWN). //Arrow_Down == Scroll Down == Page_Down
                perform();
        Thread.sleep(3000);

        // 2. kere asagiya kaydir
        actions.sendKeys(Keys.PAGE_DOWN). //Arrow_Down sayfayi Page_Down dan daha asagi kaydiri
                perform();
        Thread.sleep(3000);
//        3- Sayfayi Scroll up (yukari kaydir) yap
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(3000);

        actions.sendKeys(Keys.PAGE_DOWN).   // Arrow_Down sayfayi Page_Down'dan daha asagi kaydirir
                perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

}
