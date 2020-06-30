package com.sinatra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    WebElement campoUser;
    WebElement campoPassword;
    WebElement botonLogin;

    public LoginPage(WebDriver wd){
        this.driver = wd;
    }

    public void loginCorrecto(String usuario, String password) {

    }
}
