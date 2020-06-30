package com.sinatra.tests;

import org.junit.Test;

public class LoginTests  extends BaseTest{

    @Test
    public void testLoginHappyPath() {
        home.navegar("https://evening-bastion-49392.herokuapp.com");
        home.verificarPagina();
        home.clickLogin();
        login.loginCorrecto("frank", "sinatra");
        songs.verificarPagina();
        songs.verificarMensajeBienvenida("You are now logged in as frank");
    }
}
