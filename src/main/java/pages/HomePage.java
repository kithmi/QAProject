package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void selectAVehicleClass(String vClass){
        By imageVehicleClass = By.xpath("//span[contains(text(),'"+vClass+"')]/ancestor::label");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement eleVehicleImage = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(imageVehicleClass)));
        eleVehicleImage.click();
    }

    public UploadVehicleRegistrationPage clickApplyForBonus(String premiumModel){
        By btnApplyForABonus = By.xpath("//p[contains(text(),'"+premiumModel+"')]/ancestor::mat-card-content//span[text()=' Prämie beantragen ']/ancestor::button");
        driver.findElement(btnApplyForABonus).click();
        return new UploadVehicleRegistrationPage(driver);
    }
}
