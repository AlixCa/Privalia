package com.sinatra.tests;

import com.sinatra.pages.HomePage;
import com.sinatra.pages.LoginPage;
import com.sinatra.pages.SongsPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public HomePage home;
    public LoginPage login;
    public SongsPage songs;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        home = new HomePage(driver);
        login = new LoginPage(driver);
        songs = new SongsPage(driver);

    }

    @After
    public void after() {
        driver.quit();

    }
}
