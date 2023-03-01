package day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class C02_BeforeAfter {

    WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("setup çalıştı");

    }
    @AfterTest
    public void tearDown(){
        System.out.println("tearDown çalıştı");
        driver.close();
    }
    @Test
    public void test01 (){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
    }
    @Test
        public void test03() throws InterruptedException {
            driver.get("https://www.youtube.com");
            System.out.println(driver.getTitle());
            Thread.sleep(3000);
    }

}
