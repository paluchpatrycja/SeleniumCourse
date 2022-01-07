package pl.coderslab.seleniumcourse.zadaniazaliczeniowe.zad1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAddress {
    @FindBy(name = "alias")
    private WebElement aliasInput;
    @FindBy(name = "address1")
    private WebElement addressInput;
    @FindBy(name = "postcode")
    private WebElement zipCodeInput;
    @FindBy(name = "city")
    private WebElement cityInput;
    @FindBy(name = "id_country")
    private WebElement selectCountryCheck;
    @FindBy(name = "phone")
    private WebElement phoneNumberInput;

    public CreateNewAddress(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void shouldFillForm(FillInForm fillInForm) {
        aliasInput.sendKeys(fillInForm.getAlias());
        addressInput.sendKeys(fillInForm.getAddress());
        zipCodeInput.sendKeys(fillInForm.getZipCode());
        cityInput.sendKeys(fillInForm.getCity());
        selectCountryCheck.sendKeys(fillInForm.getSelectCountry());
        phoneNumberInput.sendKeys(fillInForm.getPhoneNumber());
    }

}
