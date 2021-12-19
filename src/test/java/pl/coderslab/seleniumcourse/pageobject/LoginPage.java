package pl.coderslab.seleniumcourse.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.UUID;

public class LoginPage {

    @FindBy(id = "email_create")
    private WebElement emailInput;
    @FindBy(id = "SubmitCreate")
    private WebElement createAccountBtn;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void fillCreateAnAccountRandomEmail() {
        String randomEmail = UUID.randomUUID() + "@mail.pl";
        emailInput.clear();
        emailInput.sendKeys(randomEmail);
    }

    public void fillCreateAnAccountEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void clickCreateAnAccount() {
                createAccountBtn.click();
    }
}
