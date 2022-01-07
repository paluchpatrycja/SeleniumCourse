package pl.coderslab.seleniumcourse.zadaniazaliczeniowe.zad1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewAddressTest {
    private WebDriver driver;

    @Given("Logged-in user is on new address page")
    public void shouldGoToAddressPage() {
        this.setUpDriver();

        SignIn signIn = new SignIn(driver);
        signIn.clickSignIn();
        signIn.fillLogInForm();

        GoToAddressPage newAddress = new GoToAddressPage(driver);
        newAddress.clickAddresses();
        newAddress.clickCreateNewAddress();
    }


    @When("^User fills out form with data: (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void shouldFillForm(String alias, String address, String zipCode, String city, String selectCountry, String phoneNumber) {

        FillInForm fillInForm = new FillInForm()
                .setAlias(alias)
                .setAddress(address)
                .setZipCode(zipCode)
                .setCity(city)
                .setSelectCountry(selectCountry)
                .setPhoneNumber(phoneNumber);

        CreateNewAddress createNewAddress = new CreateNewAddress(driver);
        createNewAddress.shouldFillForm(fillInForm);

    }


    @Then("Click SAVE button")
    public void shouldClickSaveBtn() {
       WebElement saveBtn = driver.findElement(By.cssSelector(".form-footer button[type=\"submit\"]"));
       saveBtn.click();
    }

    @And("The note {string} on the green box will appear")
    public boolean shouldCheckGreenBox(String msg) {
        WebElement greenBox = driver.findElement(By.cssSelector(".alert-success[role=\"alert\"]"));
        String confirmationText = greenBox.getText();
        return confirmationText.equals(msg);
    }

    private void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        this.driver = new ChromeDriver();
        driver.get("https://mystore-testlab.coderslab.pl");
    }
}
