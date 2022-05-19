package com.testinium.test;

import com.testinium.page.driver.BaseTest;
import com.testinium.page.LoginPage;
import org.junit.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        loginPage.favAdd();
        loginPage.katalogGrs();
    }
}
