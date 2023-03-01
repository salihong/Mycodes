package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_BestBuyAssertions {
    /*
    1) Bir class oluşturun: BestBuyAssertions
2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
 ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
 ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
 ○ logoTest => BestBuy logosunun görüntülendigini test edin
 ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
BestBuy.comBestBuy.com
Best Buy | Official Online Store | Shop Now & Save
Shop Best Buy for electronics, computers, appliances, cell phones, video games & more new tech.
In-store pickup & free 2-day shipping on thousands of items.
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void urlTest(){
        //      ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    @Test
    public void titleTest(){
        //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String expectedIcermeyeKelime="Rest";
        String actualTitle= driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedIcermeyeKelime));
    }
    @Test
    public void logoTest(){
        //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElementi= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }
    @Test
    public void FransizcaLinkTesti(){
        //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement fransizcaLinki= driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(((WebElement) fransizcaLinki).isDisplayed());
    }




}
