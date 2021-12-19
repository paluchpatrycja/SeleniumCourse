package pl.coderslab.seleniumcourse.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// this is our first implementation of Page Object Pattern

public class LandingPage {
    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignIn() {
        WebElement signInBtn = driver.findElement(By.className("hide_xs"));
        signInBtn.click();
    }
}
