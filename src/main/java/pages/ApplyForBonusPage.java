package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApplyForBonusPage {
    WebDriver driver;
    private By title = By.xpath("//h2[text()='Angaben überprüfen & THG-Prämie beantragen']");

    public ApplyForBonusPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean titleIsDisplayed(){
        return driver.findElement(title).isDisplayed();
    }

}
