package pl.coderslab.seleniumcourse.pageobject;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class HotelNameTest {
        WebDriver driver;

        @Test
        public void shouldFindHotelViaName() {
            driver.get("https://hotel-testlab.coderslab.pl/en/");


        }
    }

