package pl.coderslab.seleniumcourse.zadaniazaliczeniowe.zad1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn {
    WebDriver driver;

    public SignIn(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignIn() {
        WebElement signInBtn = driver.findElement(By.cssSelector(".user-info a"));
        signInBtn.click();
    }

    public void fillLogInForm() {
        WebElement emailInput = driver.findElement(By.cssSelector("#login-form input[name=\"email\"]"));
        emailInput.sendKeys("nqhub@kvhrr.com");

        WebElement passwordInput = driver.findElement(By.cssSelector("#login-form input[name=\"password\"]"));
        passwordInput.sendKeys("beczka123");

        WebElement signInBtn = driver.findElement(By.id("submit-login"));
        signInBtn.click();

    }

}
