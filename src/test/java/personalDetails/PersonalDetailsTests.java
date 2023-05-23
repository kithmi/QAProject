package personalDetails;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ApplyForBonusPage;
import pages.PersonalInforPage;
import pages.UploadVehicleRegistrationPage;


import static org.testng.Assert.*;

public class PersonalDetailsTests extends BaseTests {

    @Test
    public void verifySuccessPersonalDetails(){
        myHomePage.selectAVehicleClass("E-PKW");
        UploadVehicleRegistrationPage uploadVehicleRegistrationPage = myHomePage.clickApplyForBonus("Flex-Prämie");
        uploadVehicleRegistrationPage.uploadVCardFrontImage(System.getProperty("user.dir")+"/resources/vCardFrontImage.jpg");
        uploadVehicleRegistrationPage.uploadVCardBackImage(System.getProperty("user.dir")+"/resources/vCardBackImage.jpg");
        PersonalInforPage personalInforPage = uploadVehicleRegistrationPage.clickWeiterrBtn();
        personalInforPage.setSelectAnrede("Herr");
        personalInforPage.setInputVorname("Max");
        personalInforPage.setInputNachname("Mustermann");
        personalInforPage.setInputEmail("maxmus@gmail.com");
        personalInforPage.setInputKontoinhaber("Max Mustermann");
        //please add a valid IBAN number as a parameter below to execute the script
        String IBAN = "DE22 3806 0286 4369 2860 22";
        personalInforPage.setInputIBAN(IBAN);
        ApplyForBonusPage applyForBonusPage = personalInforPage.clickWeiterBtn();
        assertTrue(personalInforPage.isWeiterBtnEnabled(),"Weiter Button is not enabled");
        assertTrue(applyForBonusPage.titleIsDisplayed(),"Angaben überprüfen & THG-Prämie beantragen title not displazed");
    }
    @Test
    public void verifyZurückBtn(){
        myHomePage.selectAVehicleClass("E-PKW");
        UploadVehicleRegistrationPage uploadVehicleRegistrationPage = myHomePage.clickApplyForBonus("Flex-Prämie");
        uploadVehicleRegistrationPage.uploadVCardFrontImage(System.getProperty("user.dir")+"/resources/vCardFrontImage.jpg");
        uploadVehicleRegistrationPage.uploadVCardBackImage(System.getProperty("user.dir")+"/resources/vCardBackImage.jpg");
        PersonalInforPage personalInforPage = uploadVehicleRegistrationPage.clickWeiterrBtn();
        personalInforPage.setInputVorname("Max");
        personalInforPage.setInputNachname("Mustermann");
        UploadVehicleRegistrationPage uploadVehicleRegistrationPageAgain = personalInforPage.clickZurückBtn();
        assertTrue(uploadVehicleRegistrationPageAgain.titleIsDisplayed(),"Fahrzeugschein hochladen title not displayed");
    }

    @Test
    public void verifyIBANErrorMsg(){
        myHomePage.selectAVehicleClass("E-PKW");
        UploadVehicleRegistrationPage uploadVehicleRegistrationPage = myHomePage.clickApplyForBonus("Flex-Prämie");
        uploadVehicleRegistrationPage.uploadVCardFrontImage(System.getProperty("user.dir")+"/resources/vCardFrontImage.jpg");
        uploadVehicleRegistrationPage.uploadVCardBackImage(System.getProperty("user.dir")+"/resources/vCardBackImage.jpg");
        PersonalInforPage personalInforPage = uploadVehicleRegistrationPage.clickWeiterrBtn();
        personalInforPage.setInputKontoinhaber("Max Mustermann");
        personalInforPage.setInputIBAN("DE45 7890 8965 5643 3454 00");
        assertEquals(personalInforPage.getIBANErrorMsg(),"Bitte überprüfen Sie Ihre Eingabe.","Incorrect IBAN error");
    }

    @Test
    public void verifyWeiterrBtnDisabled(){
        myHomePage.selectAVehicleClass("E-PKW");
        UploadVehicleRegistrationPage uploadVehicleRegistrationPage = myHomePage.clickApplyForBonus("Flex-Prämie");
        uploadVehicleRegistrationPage.uploadVCardFrontImage(System.getProperty("user.dir")+"/resources/vCardFrontImage.jpg");
        uploadVehicleRegistrationPage.uploadVCardBackImage(System.getProperty("user.dir")+"/resources/vCardBackImage.jpg");
        PersonalInforPage personalInforPage = uploadVehicleRegistrationPage.clickWeiterrBtn();
        personalInforPage.setSelectAnrede("Herr");
        personalInforPage.setInputVorname("Max");
        personalInforPage.setInputNachname("Mustermann");
        personalInforPage.setInputEmail("maxmus@gmail.com");
        personalInforPage.setInputKontoinhaber("Max Mustermann");
        assertFalse(personalInforPage.isWeiterBtnEnabled(),"Weiter button is not disabled");
    }
}
