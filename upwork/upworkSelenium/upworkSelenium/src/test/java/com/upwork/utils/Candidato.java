package com.upwork.utils;

public class Candidato
{

    String nombreCandidato;
    String titulo;
    double rate;
    int success;
    String countryText;

    public String getNombreCandidato() {
        return nombreCandidato;
    }

    public void setNombreCandidato(String nombreCandidato) {
        this.nombreCandidato = nombreCandidato;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getCountryText() {
        return countryText;
    }

    public void setCountryText(String countryText) {
        this.countryText = countryText;
    }

    public Candidato(String nombreCandidato, String titulo, double rate, int success, String countryText) {
        this.nombreCandidato = nombreCandidato;
        this.titulo = titulo;
        this.rate = rate;
        this.success = success;
        this.countryText = countryText;
    }




}
