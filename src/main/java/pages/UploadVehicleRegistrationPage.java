package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadVehicleRegistrationPage {
    WebDriver driver;

    private By inputUploadVCardFront = By.id("Fahrzeugschein Vorderseite");
    private By inputUploadVCardBack = By.id("Fahrzeugschein Rückseite");
    private By btnWeiter = By.xpath("//app-step1//div[text()='Weiter ']/ancestor::button");
    private By title = By.xpath("//h2[text()='Fahrzeugschein hochladen']");

    public UploadVehicleRegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    public void uploadVCardFrontImage(String path){
        driver.findElement(inputUploadVCardFront).sendKeys(path);
    }

    public void uploadVCardBackImage(String path){
        driver.findElement(inputUploadVCardBack).sendKeys(path);
    }

    public PersonalInforPage clickWeiterrBtn(){
        driver.findElement(btnWeiter).click();
        return new PersonalInforPage(driver);
    }

    public boolean titleIsDisplayed(){
        return driver.findElement(title).isDisplayed();
    }
}
