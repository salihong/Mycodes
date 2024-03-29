package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C05_CheckBox {
    /*
    Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
 a. Verilen web sayfasına gidin.
     https://the-internet.herokuapp.com/checkboxes
 b. Checkbox1 ve checkbox2 elementlerini locate edin.
 c. Checkbox1 seçili değilse onay kutusunu tıklayın
 d. Checkbox2 seçili değilse onay kutusunu tıklayın
     */

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public void teardown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement cb1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement cb2= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //  c. Checkbox1 seçili değilse onay kutusunu tıklayın ve secili oldugunu test edin
        if (!cb1.isSelected()){
            cb1.click();
        }
        Assert.assertTrue(cb1.isSelected());
        //  d. Checkbox2 seçili değilse onay kutusunu tıklayın ve secili oldugunu test edin
        if (!cb2.isSelected()){
            cb2.click();
        }
        Assert.assertTrue(cb2.isSelected());
        Thread.sleep(3000);
    }

}
