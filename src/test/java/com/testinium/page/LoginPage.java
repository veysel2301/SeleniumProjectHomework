package com.testinium.page;

import com.testinium.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class LoginPage {

    Methods methods;
    WebDriver driver;
    //BaseTest baseTest;


    Logger logger= LogManager.getLogger(LoginPage.class);
    public LoginPage() {

        methods = new Methods();
    }
    @Test
    public void login()
    {
        String girisKontrol = "//div[@class='menu-top-button login']";
        methods.click(By.xpath(girisKontrol));
        methods.waitBySeconds(5);
        methods.senKeys(By.id("login-email"),"veyseloner23@gmail.com");
        methods.waitBySeconds(5);
        methods.senKeys(By.xpath("//input[@id='login-password']"), "veysel123.");
        methods.waitBySeconds(5);
        methods.click(By.cssSelector((".ky-btn.ky-btn-orange.w-100.ky-login-btn")));
        methods.waitBySeconds(5);
        Assert.assertTrue(methods.isElementVisible(By.xpath("//input[@id='search-input']")));
        methods.waitBySeconds(5);
       methods.senKeys(By.id("search-input"), "Oyuncak");
       methods.waitBySeconds(2);
       methods.click(By.cssSelector(".common-sprite.button-search"));
       methods.scrollWithAction(By.id("product-479137"));
       methods.waitBySeconds(5);


    }
    public void favAdd(){
        methods.click(By.cssSelector(".pr-img-link"));
        methods.click(By.id("product-detail-add-to-favorites"));
        methods.waitBySeconds(5);
    }
    public void katalogGrs(){
        methods.click(By.xpath("//div[@class='lvl1catalog']"));// puan katalog
        methods.waitBySeconds(5);
        methods.click(By.xpath("//div[@class='landing-block']/a/img[@src='https://img.kitapyurdu.com/v1/getImage/fn:4359433/wh:14a4e2d16']"));
        methods.waitBySeconds(5);
        methods.selectByText(By.xpath("//div[@class='sort']/select[@onchange='location = this.value;']"),"Yüksek Oylama");
        methods.waitBySeconds(15);
    }

//    public void attributeTest(){
//        String attiribute=methods.getAttribute(By.cssSelector(".add-to-favorites>i"),"title");
//        System.out.println("Alınan text "+ attiribute);
//        logger.info("Alınan text "+ attiribute);
//        methods.waitBySeconds(3);
//    }
    }

