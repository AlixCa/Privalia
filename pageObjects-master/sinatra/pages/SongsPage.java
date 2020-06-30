package com.sinatra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SongsPage {
    private WebDriver driver;

    WebElement mensajeBienvenida;
    WebElement linkLogout;
    WebElement headerSongs;
    WebElement linkCreateNewSong;

    public SongsPage(WebDriver wd){
        this.driver = wd;
    }

    public void verificarPagina() {

    }

    public void verificarMensajeBienvenida(String mensaje) {

    }
}
