import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.autojava4.GenerateDate;

import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestApp {
    GenerateDate dateCreate = new GenerateDate();
    Random rnd = new Random();

    @Test
    void positiveTests() {
        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Майкоп");
        $("[data-test-id='date'] input").sendKeys(Keys.CONTROL + "a");
        $("[data-test-id='date'] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(dateCreate.dateCreate(rnd.nextInt(5) + 3));
        $("[data-test-id='name'] input").setValue("Койфман Станислав-Богданович");
        $("[data-test-id='phone'] input").setValue("+79999999999");
        $("[data-test-id='agreement']").click();
        $("button.button_view_extra").click();
        $("button.button_view_extra .spin_visible").shouldBe(visible);
        $(withText("Встреча успешно забронирована")).shouldBe(visible, Duration.ofSeconds(15));
    }

    @Test
    void positiveCityTests() {
        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Ма");
        $$(".popup .menu-item span").find(exactText("Майкоп")).click();
        $("[data-test-id='date'] input").sendKeys(Keys.CONTROL + "a");
        $("[data-test-id='date'] input").sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(dateCreate.dateCreate(rnd.nextInt(5) + 3));
        $("[data-test-id='name'] input").setValue("Койфман Станислав-Богданович");
        $("[data-test-id='phone'] input").setValue("+79999999999");
        $("[data-test-id='agreement']").click();
        $("button.button_view_extra").click();
        $("button.button_view_extra .spin_visible").shouldBe(visible);
        $(withText("Встреча успешно забронирована")).shouldBe(visible, Duration.ofSeconds(15));
    }

    @Test
    void positiveDateTests() {
        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Майкоп");
        $("[data-test-id='date'] input").click();
        if (!($(String.format("[data-day='%s']", dateCreate.dateTimestampSevenDays())).isDisplayed())) {
            $(".calendar__arrow_direction_right[data-step='1']").click();
        }
        $(String.format("[data-day='%s']", dateCreate.dateTimestampSevenDays())).click();
        $("[data-test-id='name'] input").setValue("Койфман Станислав-Богданович");
        $("[data-test-id='phone'] input").setValue("+79999999999");
        $("[data-test-id='agreement']").click();
        $("button.button_view_extra").click();
        $("button.button_view_extra .spin_visible").shouldBe(visible);
        $(withText("Встреча успешно забронирована")).shouldBe(visible, Duration.ofSeconds(15));
    }
}
