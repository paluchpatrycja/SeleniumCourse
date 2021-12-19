package pl.coderslab.seleniumcourse.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlreadyRegisteredPage {
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id = "SubmitLogin")
    private WebElement signInBtn;

    public AlreadyRegisteredPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillRegisteredEmail() {
        String registeredEmail = "pattest@test.pl";
        emailInput.clear();
        emailInput.sendKeys(registeredEmail);
    }

    public void fillRegisteredPassword() {
        String registeredPsw = "hehehe1";
        passwordInput.clear();
        passwordInput.sendKeys(registeredPsw);
    }

    public void clickSignInBtn() {
        signInBtn.click();
    }
}

