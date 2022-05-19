package com.testinium.page;

import com.testinium.methods.Methods;
import com.testinium.page.driver.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.testinium.page.driver.BaseTest.driver;

public class ProductPage  {
    Methods methods;
    Logger logger= LogManager.getLogger(ProductPage.class);
    public ProductPage() {
   methods=new Methods();

    }
    public  void scrollAndSelect(){
        /* login*/
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
        methods.waitBySeconds(7);
        methods.senKeys(By.id("search-input"), "Oyuncak");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySeconds(5);
        methods.scrollWithAction(By.xpath("//div[@id='product-table']/div[7]"));
        methods.waitBySeconds(5);
        favAdd();

        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/']"));
        methods.waitBySeconds(5);
        methods.click(By.xpath("//div[@class='lvl1catalog']"));// puan katalog
       methods.waitBySeconds(5);
       methods.click(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:4359433/wh:14a4e2d16']"));
       methods.waitBySeconds(5);
        methods.selectByText(By.xpath("//div[@class='sort']/select[@onchange='location = this.value;']"),
                "Yüksek Oylama");
        methods.waitBySeconds(5);
        randomSec();
        /* favorilerimden 3. ürünü  silme*/
        favDell();
        methods.click(By.id("cart-items") );
        methods.waitBySeconds(3);
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=checkout/cart']"));
        methods.waitBySeconds(3);
        driver.findElement(By.xpath("//input[@name='quantity']")).clear();
        methods.senKeys(By.xpath("//input[@name='quantity']"), "2");
        methods.waitBySeconds(1);
        methods.click(By.xpath("//i[@onclick='cartProductUpdate($(this).parent())']"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//button[@class='swal2-close']"));
        /*buy Books Button*/
        methods.click(By.cssSelector(".button.red"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//a[@href='#tab-shipping-new-adress']"));
        /*Yeni adres ekleme*/
        incrementBuy();
        methods.senKeys(By.id("credit-card-owner"),"Veysel Oner");
        methods.waitBySeconds(3);
        methods.senKeys(By.id("credit_card_number_1"),"1234");
        methods.waitBySeconds(3);
        methods.senKeys(By.id("credit_card_number_2"),"2345");
        methods.waitBySeconds(3);
        methods.senKeys(By.id("credit_card_number_3"),"3456");
        methods.waitBySeconds(3);
        methods.senKeys(By.id("credit_card_number_4"),"4567");
        methods.waitBySeconds(3);
        methods.senKeys(By.id("credit-card-expire-date-month"),"01");
        methods.waitBySeconds(3);
        methods.senKeys(By.id("credit-card-expire-date-year"),"2025");
        methods.waitBySeconds(3);
        methods.senKeys(By.id("credit-card-security-code"),"123");
        methods.waitBySeconds(3);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(3);

        /*Logout*/
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/']"));
        methods.waitBySeconds(5);
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=account/logout']"));


}

 public void randomSec() {
         methods.click(By.xpath("//ul[@class='js-ajaxCt js-bookCt']/li[3]/span"));
         methods.waitBySeconds(3);
         methods.click(By.xpath("//a[@href='kategori/kitap-hobi/1_212.html']"));
         methods.waitBySeconds(3);
         Random random=new Random(); //random sınıfı
         int x=random.nextInt(6);
         while(true)
         {
             if(x != 0)
                 break;
             x = random.nextInt(6);
         }

         System.out.println("//ul[@class='product-grid jcarousel-skin-opencart']/li[" + x + "]");
         methods.click(By.xpath(
                 "//ul[@class='product-grid jcarousel-skin-opencart']/li[" + x + "]"));
         methods.waitBySeconds(3);
         methods.click(By.id("button-cart"));
         methods.waitBySeconds(3);
     }
     public void favAdd(){
        for (int i=7;i<11;i++) {
            methods.scrollWithAction(By.xpath("//div[@id='product-table']/div[" + i + "]"));
            methods.waitBySeconds(3);
            methods.click(By.xpath("//div[@id='product-table']/div[" + i + "]/div[2]/div[3]/a[4]"));
            methods.waitBySeconds(3);
        }
     }
    public void favDell(){
        methods.click(By.cssSelector(".menu.top.my-list"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=account/favorite&selected_tags=0']"));
        methods.waitBySeconds(3);
       methods.click(By.xpath("//div[@class='product-cr']/div[2]/div[3]/a[@data-title='Favorilerimden Sil']"));
        methods.waitBySeconds(3);

    }
    public void incrementBuy(){//adres metodu
    methods.senKeys(By.id("address-firstname-companyname"),"veysel");
    methods.waitBySeconds(2);
    methods.senKeys(By.id("address-lastname-title"),"oner");
    methods.waitBySeconds(2);
    methods.senKeys(By.xpath("//select[@name='zone_id']"),"İzmir");
    methods.waitBySeconds(2);
    methods.senKeys(By.id("address-county-id"),"BUCA");
    methods.waitBySeconds(2);
    methods.senKeys(By.id("district"),"Buca hasanağa");
    methods.waitBySeconds(2);
    methods.senKeys(By.id("address-address-text"),"300005 sok vsvs mah");
    methods.waitBySeconds(2);
    methods.click(By.id("address-postcode"));
    methods.waitBySeconds(2);
    methods.senKeys(By.id("address-mobile-telephone"),"5374657746");
    methods.waitBySeconds(2);
    methods.click(By.id("address_type_1"));//Şahıs
    methods.waitBySeconds(2);
    methods.click(By.id("use-payment-address"));
    methods.waitBySeconds(2);
    methods.click(By.id("button-checkout-continue"));
    methods.waitBySeconds(2);




    }


        public void textControlTest(){
        String text=methods.getText(By.cssSelector(".common-sprite"));
            System.out.println("Alınan text "+text);
            logger.info("Alınan text"+text);
            methods.waitBySeconds(3);
        }

}
