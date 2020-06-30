package com.upwork.tests;

import com.upwork.utils.Candidato;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BuscarCandidatoPadre {

    WebDriver driver;
    WebDriverWait wait;

    public static List<WebElement> candidatos;

    public static final int SHORT_WAIT = 5;
    public static final int MEDIUM_WAIT = 10;
    public static final int LONG_WAIT = 30;

    @Before
    public void before()
    {
        navegar ("https://upwork.com");
        verificarPaginaPrincipal();
    }

    protected void navegar(String url)
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(SHORT_WAIT, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, LONG_WAIT);
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    protected void verificarPaginaPrincipal()
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#layout .container-visitor .navbar-brand")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".d-lg-flex [name='q']")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".navbar-collapse.d-lg-flex button[type='submit']")));
        }
        catch (Exception e)
        {
            System.out.println("No se encontraron algunos de los elementos");
            System.exit(-1);
        }
    }

    protected void buscarCandidatosPorHabilidad(String habilidad)
    {
        WebElement campoBusqueda = driver.findElement(By.cssSelector(".d-lg-flex [name='q']"));
        campoBusqueda.sendKeys((habilidad));
        campoBusqueda.submit();
    }

    protected void verificarListaFreelancers()
    {
        try
        {
            WebElement esperaCargaLista = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#oContractorResults section.air-card-hover")));
            candidatos = driver.findElements(By.cssSelector("#oContractorResults section.air-card-hover"));
            esperaCargaLista = null;
            System.out.println("El tamaño de la lista de candidatos es de: "+candidatos.size()+ "candidatos");
        }
        catch (Exception e)
        {
            System.out.println("La lista esta vacia, no hay candidatos");
            System.exit(-1);
        }
    }

    protected Candidato buscarMejorCandidato()
    {
        Candidato ideal = null;
        for(WebElement we: candidatos)
        {
            WebElement nombreElement = we.findElement(By.cssSelector("#oContractorResults section.air-card-hover [data-qa'tile_name']"));
            String nombreCandidato = nombreElement.getText();

            WebElement tituloElement = we.findElement(By.cssSelector("#oContractorResults section.air-card-hover .d-md-block [data-qa='tile_title']"));
            String titulo = tituloElement.getText();

            WebElement rateElement = we.findElement(By.cssSelector("#oContractorResults section.air-card-hover [data-rate] strong"));
            String rateText = rateElement.getText().substring(1);
            double rate = Double.parseDouble(rateText);

            WebElement successElement = we.findElement(By.cssSelector("#oConstractorResults section.air-card-hover .d.lg-block .progress-bar > span"));
            String successText = successElement.getText().split("%")[0];
            int success = Integer.parseInt(successText);

            WebElement countryElement = we.findElement(By.cssSelector("#oCountractorResults section.air-card-hover .freelancer-tile-location"));
            String countryText = countryElement.getText();

            // meto al primer candidato
            if (ideal == null)
            {
                ideal = new Candidato(nombreCandidato, titulo, rate, success, countryText);
            }
            else if (rate < ideal.getRate()) //si encuentro candidato con menos slario, saco al candidato anterior y meto al nuevo
            {
                ideal = new Candidato(nombreCandidato, titulo, rate, success, countryText);
            }
            else if (rate == ideal.getRate()) //si encuentro un candidato con el miso salario, pero menos success rate, lo ignoro. Si el success rate es mayor, saco al candidato anterior y meto al nuevo
            {
                if (success > ideal.getSuccess())
                {
                    ideal = new Candidato(nombreCandidato, titulo, rate, success, countryText);
                }
            }





            //si encuentro un cadidato con el mismo salario, mismo success rate, menor ingreso, lo ignoro
            // si el ingreso es menor es saco al candidato anterior y meto al nuevo

            //si todos son iguales lo meto al arreglo
        }
        return null;
    }

    protected void seleccionarCandidato(Candidato ideal) {
        protected void seleccionarCandidato(Candidato ideal){
            String nombre = ideal.getNombreCandidato();
            double rate = ideal.getRate();
//    String xpath = "//section[contains(@class, 'air-card-hover') and contains( . , '"+nombre+"')   and contains( . , '"+rate+"')]";
//    driver.findElement(By.xpath(xpath)).click();
            for (WebElement we : candidatos) {
                Candidato actual = getCandidateData(we);
                if (actual.getNombreCandidato().equals(ideal.getNombreCandidato()) && actual.getRate() == ideal.getRate())
                    we.click();
                break;
            }
        }
    }
            protected void verificarInformacionCandidato(Candidato ideal) throws Exception {
                Candidato candidatoPagina = getInformacionCandidatoPagina();
                if( candidatoPagina.getNombreCandidato().contains(ideal.getNombreCandidato()) &&
                        candidatoPagina.getTitulo().contains(ideal.getTitulo()) &&
                        candidatoPagina.getCountryText().contains(ideal.getCountryText()) &&
                        candidatoPagina.getSuccess() == ideal.getSuccess() &&
                        candidatoPagina.getRate() == ideal.getRate() )
                    System.out.println("La informacion coincide");
                else {
                    System.out.println("La informacion no coincide");
                    throw new Exception("La informacion del candidato no coincide");
                }
        }

    private Candidato getInformacionCandidatoPagina() {
        return null;
    }

    @After
    public void after()
    {
        driver.quit();
    }

}

    private Candidato getCandidateData(WebElement we) {
    }
