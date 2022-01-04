package pl.coderslab.seleniumcourse.zadaniazaliczeniowe.zad1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewAddressTest {
    WebDriver driver;

    @Test
    public void shouldLogIn() {
        driver.get("https://mystore-testlab.coderslab.pl");

        SignIn signIn = new SignIn(driver);
        signIn.clickSignIn();
        signIn.fillLogInForm();
    }

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        this.driver = new ChromeDriver();
    }


}
