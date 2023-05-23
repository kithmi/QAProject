package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    protected HomePage myHomePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://thg-greenair.dev.wgv.onpier.de/onboarding");
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        myHomePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
