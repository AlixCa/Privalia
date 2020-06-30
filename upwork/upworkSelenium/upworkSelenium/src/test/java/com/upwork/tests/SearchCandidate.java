package com.upwork.tests;
import com.upwork.utils.Candidato;
import org.junit.Test;

public class SearchCandidate extends BuscarCandidatoPadre
{


    @Test
    public void searchBestCandidate()
    {
        buscarCandidatosPorHabilidad("Selenium");
        verificarListaFreelancers();
        Candidato morris = buscarMejorCandidato();
        seleccionarCandidato(morris);
        verificarInfoCandidato(morris);
    }

}
