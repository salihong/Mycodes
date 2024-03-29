package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class C06_RadioButton {

    WebDriver driver;
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterTest
    public void teardown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        //  a. Verilen web sayfasına gidin.
        //       https://facebook.com
        driver.get("https://facebook.com");
        //  b. Cookies’i kabul edin
        //driver.findElement(By.xpath("//button[@title='Only allow essential cookies']")).click();?????
        //  c. Create an account buton’una basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //  d. Radio button elementlerini locate edin ve size uygun olani secin
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
        Thread.sleep(4000);
    }
}
