package sinatra.test;

import org.junit.Before;

public class BaseTest {
    public WebDriver driver;
    public HomePage home;
    public LoginPage;
    public SongsPage songs;

    @Before
    public void before(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, SECONDS)
    }
}
