package practiceTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {
        static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
        }

        @BeforeAll
        static void BeforeAll () {

            Configuration.baseUrl = "https://demoqa.com";
            Configuration.browserSize = "1920x1080";
            Configuration.pageLoadStrategy = "eager";
            Configuration.timeout = (10);
        }

        @Test
        void fillRegistrationFormTest() {
            open("/automation-practice-form");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");

            $("#firstName").setValue("Alex");
            $("#lastName").setValue("Egorov");
            $("#userEmail").setValue("alex@egorov.com");
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("1234567890");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").$(byText("2005")).click();
            $(".react-datepicker__month-select").$(byText("July")).click();
            $("div.react-datepicker__week div.react-datepicker__day--001").click();
            $("#subjectsInput").setValue("History");
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#uploadPicture").uploadFromClasspath("image.png");
            $("#currentAddress").setValue("New York");


            $("#state").click();
            $("#stateCity-wrapper div#react-select-3-option-2").click();
            $("#city").click();
            $("#city div#react-select-4-option-0").click();
            $("#submit").click();

            $(".table-responsive").shouldHave(text("Alex Egorov"));
            $(".table-responsive").shouldHave(text("alex@egorov.com"));
            $(".table-responsive").shouldHave(text("Male"));
            $(".table-responsive").shouldHave(text("1234567890"));
            $(".table-responsive").shouldHave(text("01 July,2005"));
            $(".table-responsive").shouldHave(text("Sports"));
            $(".table-responsive").shouldHave(text("image.png"));
            $(".table-responsive").shouldHave(text("New York"));
            $(".table-responsive").shouldHave(text("Haryana Karnal"));

            $("#closeLargeModal").click();
        }
}
