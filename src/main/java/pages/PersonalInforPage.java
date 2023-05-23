package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalInforPage {
    WebDriver driver;

    private By selectAnrede = By.xpath("//mat-select");
    private By inputVorname = By.cssSelector("onpier-input[label='Vorname'] input");
    private By inputNachname = By.cssSelector("onpier-input[label='Nachname'] input");
    private By inputEmail = By.cssSelector("onpier-input[label='E-Mail-Adresse'] input");
    private By inputKontoinhaber = By.cssSelector("onpier-input[label='Kontoinhaber'] input");
    private By inputIBAN = By.cssSelector("onpier-input[label='IBAN'] input");
    private By btnWeiter = By.xpath("//app-step2//div[text()='Weiter ']/ancestor::button");
    private By btnZurück = By.xpath("//app-step2//button[text()=' Zurück ']");
    private By errorMsgIBAN = By.xpath("//onpier-input[@label='IBAN']//p[contains(@class,'error-msg')]");

    public PersonalInforPage(WebDriver driver){
        this.driver = driver;
    }

    public void setSelectAnrede(String anrede){
        driver.findElement(selectAnrede).click();
        driver.findElement(By.xpath("//mat-option//span[text()='"+anrede+"']")).click();
    }

    public void setInputVorname(String vorname){
        driver.findElement(inputVorname).sendKeys(vorname);
    }

    public void setInputNachname(String nachname){
        driver.findElement(inputNachname).sendKeys(nachname);
    }

    public void setInputEmail(String email){
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void setInputKontoinhaber(String kontoinhaber){
        driver.findElement(inputKontoinhaber).sendKeys(kontoinhaber);
    }

    public void setInputIBAN(String iban){
        driver.findElement(inputIBAN).sendKeys(iban);
    }

    public boolean isWeiterBtnEnabled(){
        return driver.findElement(btnWeiter).isEnabled();
    }

    public UploadVehicleRegistrationPage clickZurückBtn(){
        driver.findElement(btnZurück).click();
        return new UploadVehicleRegistrationPage(driver);
    }

    public String getIBANErrorMsg(){
        return driver.findElement(errorMsgIBAN).getText();
    }
    public ApplyForBonusPage clickWeiterBtn(){
        driver.findElement(btnWeiter).click();
        return new ApplyForBonusPage(driver);
    }
}
