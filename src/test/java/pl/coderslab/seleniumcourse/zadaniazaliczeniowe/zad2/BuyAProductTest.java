package pl.coderslab.seleniumcourse.zadaniazaliczeniowe.zad2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.seleniumcourse.zadaniazaliczeniowe.zad1.SignIn;

import java.time.Duration;

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
    public void shouldSelectQuantity(String quantity)  {
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


    private void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        driver.get("https://mystore-testlab.coderslab.pl");
    }
}
