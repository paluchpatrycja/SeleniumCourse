package pl.coderslab.seleniumcourse.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJunitSeleniumTest {
    WebDriver driver;

    @Test
    public void shouldSearchInQuwant() {
        driver.get("https://www.qwant.com/");
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("samoyed");
        searchInput.submit();
    }
    @Test
    public void shouldSearchInDuckDuckGo() {
        driver.get("https://duckduckgo.com/");
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("samoyed");
        searchInput.submit();
    }
    @BeforeEach
    public void beforeEach(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        this.driver = new ChromeDriver();
    }
    @AfterEach
    public void afterEach(){
        this.driver.quit();
    }
}
