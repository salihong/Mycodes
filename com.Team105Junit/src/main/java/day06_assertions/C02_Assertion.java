package day06_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_Assertion {
    int P1Yas=60;
    int P2yas=66;
    int P3yas=70;
    @Test
    public void test01(){
        // emekli yasi 65 olduguna gore
        // P2'nin emekli olabilecegini test edin
        Assert.assertTrue(P2yas>65);
    }
    @Test
    public void test02(){
        // emekli yasi 65 olduguna gore
        // P1'nin emekli olamayacagini test edin
        Assert.assertFalse(P1Yas>65);
    }
    @Test
    public void test03(){
        // emekli yasi 65 olduguna gore
        // P3'nin emekli olamayacagini test edin
        Assert.assertFalse(P3yas>65, "Girilen yas 65'den kucuk olmadigindan emekli olabilir");
    }
}

