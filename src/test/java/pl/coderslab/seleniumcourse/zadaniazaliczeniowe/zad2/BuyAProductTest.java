package pl.coderslab.seleniumcourse.zadaniazaliczeniowe.zad2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.seleniumcourse.zadaniazaliczeniowe.zad1.SignIn;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;

public class BuyAProductTest {
    private WebDriver driver;

    @Given("User is logged in on homepage")
    public void shouldLogIn() {
        this.setUpDriver();

        SignIn signIn = new SignIn(driver);
        signIn.clickSignIn();
        signIn.fillLogInForm();
    }

    @When("^User searches for the (.*)$")
    public void shouldSearchProduct(String productName) {
        WebElement searchInput = driver.findElement(By.cssSelector("#search_widget form input[name=\"s\"]"));
        searchInput.sendKeys(productName);
        searchInput.submit();
    }

    @Then("^Go into (.*) page$")
    public void shouldOpenProductPage(String productName) {
        WebElement searchedItem = driver.findElement(By.cssSelector(".products article:first-child"));
        searchedItem.click();
    }

    @And("^Can select size: (.*)$")
    public void shouldSelectSize(String productSize) {
        WebElement pickingSize = driver.findElement(By.cssSelector(".form-control.form-control-select"));
        pickingSize.sendKeys(productSize);
    }

    @And("^Can select quantity: (.*)$")
    public void shouldSelectQuantity(String quantity) {
        WebElement increaseQuantity = driver.findElement(By.cssSelector(".qty input[name=\"qty\"]"));
        increaseQuantity.clear();
        increaseQuantity.sendKeys(quantity);
        increaseQuantity.clear();
        increaseQuantity.sendKeys(quantity);
        increaseQuantity.clear();
        increaseQuantity.sendKeys(quantity);
        increaseQuantity.clear();
        increaseQuantity.sendKeys(quantity);
        //po wprowadzeniu danych do inputa wartość jest nadpisywana przez przegladarkę. stąd ta ilość powtórzeń
    }

    @And("Can add to cart")
    public void shouldAddToCart() {
        WebElement addToCart = driver.findElement(By.cssSelector(".product-add-to-cart .add button"));
        addToCart.click();
        driver.findElement(By.cssSelector(".modal-dialog .cart-content-btn a")).click();
    }

    @And("User can proceed to checkout")
    public void shouldCheckout() {
        WebElement checkout = driver.findElement(By.cssSelector(".text-sm-center a"));
        checkout.click();
    }

    @And("Confirm address")
    public void shouldSubmitAddress() {
        WebElement subAddress = driver.findElement(By.cssSelector("button[name=\"confirm-addresses\"]"));
        subAddress.click();
    }

    @And("^Select delivery method: (.*)$")
    public void shouldPickDelivery(String deliveryMethod) {
        WebElement pickDelivery = driver.findElement(By.cssSelector(".delivery-options"));
        pickDelivery.click();
        WebElement submitDelivery = driver.findElement(By.cssSelector("#js-delivery button[type=\"submit\"]"));
        submitDelivery.click();
    }

    @And("Select payment method: Pay by Check")
    public void shouldPickPayment() {
        WebElement pickPayment = driver.findElement(By.cssSelector("#payment-option-1"));
        pickPayment.click();
        WebElement clickAgreement = driver.findElement(By.cssSelector("#conditions-to-approve .float-xs-left"));
        clickAgreement.click();
    }

    @And("Can place an order")
    public void shouldConfirmOrder() {
        WebElement confirmOrder = driver.findElement(By.cssSelector("#payment-confirmation button[type=\"submit\"]"));
        confirmOrder.click();
    }

    @And("Take a screenshot for confirmation")
    public void shouldTakeScreenshot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File tmpScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        String home = System.getProperty("user.home");
        Files.copy(tmpScreenshot.toPath(), Paths.get(home,"workspace", "test-evidence", "screenshot-"+currentDateTime+".png"));
    }

    private void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        driver.get("https://mystore-testlab.coderslab.pl");
    }
}
