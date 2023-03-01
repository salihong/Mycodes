package day05_JUnitFramework;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class C01_ElvedaMainMethod {

    @Test
    public void test01(){
        System.out.println("test01 çalıştı");
    }
    @Test @Ignore
    public void test03(){
        System.out.println("test03 çalıştı");
    }
    @Test
        public void test02(){
            System.out.println("test03 çalıştı");


}
}


