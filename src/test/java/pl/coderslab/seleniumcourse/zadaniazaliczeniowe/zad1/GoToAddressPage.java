package pl.coderslab.seleniumcourse.zadaniazaliczeniowe.zad1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoToAddressPage {
    WebDriver driver;

    public GoToAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddresses() {
        WebElement adressessBtn = driver.findElement(By.cssSelector("#footer_account_list a[title=\"Addresses\"]"));
        adressessBtn.click();
    }

    public void clickCreateNewAddress() {
        WebElement plusCreateBtn = driver.findElement(By.cssSelector(".addresses-footer a"));
        plusCreateBtn.click();
    }

}
