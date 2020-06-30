package Privalia;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static junit.framework.Assert.*;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class StepDefinition
{

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void setUpTest()
    {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        driver = new ChromeDriver(opt);
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().setSize(new Dimension(1366, 780));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDownTest()
    {
        driver.quit();
    }

    @When("I am in Privalia home page")
    public void iAmInPrivaliaHomePage()
    {
        driver.get("https://mex.privalia.com/public/");
        //logo privalia id= "claim"
        WebElement privaliaLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("claim")));
        assertTrue(privaliaLogo.isDisplayed());
        //boton entrar css= "['.grid_4 #authLogin']"
       // WebElement botonEntrar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("['.grid_4 #authLogin']")));
       // assertTrue(privaliaLogo.isEnabled());

    }


    @Then("All the feature ads are up to date")
    public void allTheFeatureAdsAreUpToDate()
    {
        List<WebElement> promociones = driver.findElements(By.xpath("//h2[ text() = 'Destacados']/following-sibling::article"));
        for(WebElement w: promociones)
        {
            WebElement vigencia = w.findElement(By.cssSelector(".item-dataInfo"));
            System.out.println(vigencia.getText());
        }
    }


    @Then("All the current ads are up to date")
    public void allTheCurrentAdsAreUpToDate()
    {
        List<WebElement> promociones = driver.findElements(By.xpath("//h2[ text() = 'Actualmente']/following-sibling::article"));
        for(WebElement w: promociones)
        {
            WebElement vigencia = w.findElement(By.cssSelector(".item-dataInfo"));
            System.out.println(vigencia.getText());
        }
    }


    @Then("Coming up promotions have start date")
    public void comingUpPromotionsHaveStartDate()
    {
        List<WebElement> promociones = driver.findElements(By.xpath("//h2[ text() = 'Próximamente']/following-sibling::article"));
        for(WebElement w: promociones)
        {
            WebElement marcaElement = w.findElement(By.xpath("./a"));
            String marca = marcaElement.getAttribute("href").split("campaign/")[1].split("/")[0];
            WebElement startDate = w.findElement(By.cssSelector(".item-dataInfo"));
            System.out.println(marca + " " + startDate.getText());
        }
    }

}

