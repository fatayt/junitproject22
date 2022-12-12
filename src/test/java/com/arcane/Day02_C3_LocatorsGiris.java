package com.arcane;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day02_C3_LocatorsGiris {

   /* Bir class olustur : LocatorsGiris
    Main method olustur ve asagidaki gorevi (task) yap.
    Kullanici "https://www.testyou.in/Login.aspx" gider
    username textbox, password textbox, and signin button icin locator bul
    Kullanici adi and password'i gir ve sign in button click et
    Username : aykut.arcanedata@gmail.com
    Password : Aykut123!
    Kullanici adini verify et (USE getText() method to get the text from the page)
    Home and log out sekmelerinin sayfada gosterildigini dogrula/verify et
    Sayfada bulunan toplam link sayisini bul
    Sayfadan log out yapiniz
    Logged out basarili oldugunu verify edin
    */
    WebDriver chrome;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
    }
    @Test
    public void locatorGiris(){
        chrome.get("https://www.testyou.in/Login.aspx");
//    WebElement emailbox = chrome.findElement(By.id("ctl00_CPHContainer_txtUserLogin"));
//    emailbox.sendKeys("aykut.arcanedata@gmail.com");
        chrome.
                findElement(By.id("ctl00_CPHContainer_txtUserLogin")).
                sendKeys("aykut.arcanedata@gmail.com");
        // password icin yapalim
        chrome.findElement(By.name("ctl00$CPHContainer$txtPassword")).sendKeys("Aykut123!");

        //sing in buttonu locate et ve tikla(click yap)
        chrome.findElement(By.id("ctl00_CPHContainer_btnLoginn")).click();

        // kullanici adini verify et
        WebElement kulaniciAdi = chrome.findElement(By.id("ctl00_headerTopStudent_username"));
        String kullaniciAdiText = kulaniciAdi.getText();
        //getText() WebElementi`in kendisini string olarak dondurur
        System.out.println(kullaniciAdiText);
        String expectedKullaniciAdi = "Aykutsaglam ,";

        Assert.assertEquals(expectedKullaniciAdi, kullaniciAdiText);

        // Home and log out sekmelerinin sayfada gosterildigini dogrula/verify et
        WebElement homeElement = chrome.findElement(By.linkText("Home"));
        // WebElement homeElement1 = chrome.findElement(By.partialLinkText("Hom"));

        /*
        linkText() ile partialLinkTExt() arasindaki farklar
        - linkTextO MUTLAKA text veya metnin tamami bosluk ve noktalama işaretleri dahil yazmak lazim
        -	partialLinkText() netnin/text’ln tarnaıılni yapabildiğiniz gibi bir kişnıinl Yazabilirdiniz
        -	linkTextO dana güvenlidir, cunku butun metni eksiksiz eklediğimizde yanlis yapma olaşiligi azalır
        */
        Assert.assertTrue(homeElement.isDisplayed());
        //isDisplayed() bir elementin safada bulunup bulunmadigini dogrular
        //Return Type`i boolean => element bulunursa true, bulunmazsa false olur

        //log out sekmelerinin sayfada gösterildiğin dogruia/verify et
        WebElement logoutElement = chrome.findElement(By.className("signout"));
        Assert.assertTrue(logoutElement.isDisplayed());

        //Sayfada bulunan toplam link sayisini bul
        // linkler "a"vtag ile olustrulur dolayisiyla butun "a" tag ile olusturulan elementleri bulursam tum linkleri bulms olurum

        List<WebElement> tumLinkler = chrome.findElements(By.tagName("a"));
        int linkSayisi = tumLinkler.size();
        System.out.println("Tum linklerin sayisi:" + linkSayisi);

        //Logged out yapiniz
        chrome.findElement(By.className("signout")).click();

        //Logged out basarili oldugunu verify edin
        Boolean loggedout =  chrome.getCurrentUrl().equals("http://testyou.in/Login.aspx?ReturnUrl=%2fStudent%2fStudentIndex.aspx%3faction%3dlogout&action=logout");
        Assert.assertTrue(loggedout);
    }
    @After
    public void tearDown(){
        chrome.close();
    }
}
