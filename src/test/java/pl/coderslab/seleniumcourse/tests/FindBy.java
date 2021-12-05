package pl.coderslab.seleniumcourse.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.UUID;

public class FindBy {
    WebDriver driver;

    @Test
    public void shouldFindById() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement hotelLocationInput = driver.findElement(By.id("hotel_location"));
        WebElement searchNowBtn = driver.findElement(By.id("search_room_submit"));
        WebElement EnterEmail = driver.findElement(By.id("newsletter-input"));
        hotelLocationInput.sendKeys("Warsaw");
        EnterEmail.sendKeys("test@test.com");
    }

    @Test
    public void shouldFindByName() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement hotelLocationInput = driver.findElement(By.name("hotel_location"));
        WebElement searchNowButton = driver.findElement(By.name("search_room_submit"));
        WebElement EnterEmail = driver.findElement(By.name("email"));
        WebElement subsribeButton = driver.findElement(By.name("submitNewsletter"));
        hotelLocationInput.sendKeys("Warsaw");
        EnterEmail.sendKeys("test@test.com");
        searchNowButton.submit();
    }

    @Test
    public void shouldFindByClassName() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement signInBtn = driver.findElement(By.className("hide_xs"));
        signInBtn.click();
        WebElement emailInput = driver.findElement(By.id("email_create"));
        String randomEmail = UUID.randomUUID() + "@mail.pl";
        emailInput.sendKeys(randomEmail);
        WebElement createAccountBtn = driver.findElement(By.id("SubmitCreate"));
        createAccountBtn.click();
        WebElement radioMr = driver.findElement(By.cssSelector("input#id_gender1"));
        radioMr.click();
    }

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }
}
