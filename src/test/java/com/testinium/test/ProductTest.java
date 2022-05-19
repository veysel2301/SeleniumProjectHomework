package com.testinium.test;

import com.testinium.page.LoginPage;
import com.testinium.page.ProductPage;
import com.testinium.page.driver.BaseTest;
import org.junit.Test;

public class ProductTest extends BaseTest {
    @Test
    public void productTest(){
        ProductPage productPage =new ProductPage();
        productPage.scrollAndSelect();
        productPage.randomSec();
        productPage.favAdd();
        productPage.favDell();
        productPage.incrementBuy();
    }





//    @Test
//    public void getTextTest(){
//        LoginPage loginPage=new LoginPage();
//        ProductPage productPage=new ProductPage();
//        loginPage.login();
//        productPage.textControlTest();
//    }
//    @Test
//    public void getJavascriptTest(){
//        ProductPage productPage=new ProductPage();
//        productPage.valueControlTest();
//    }
}
