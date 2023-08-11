package practicetest.tests;

import org.junit.jupiter.api.Test;
import practicetest.pages.RegistrationPage;
import practicetest.pages.components.TableResultComponent;

import static com.codeborne.selenide.Selenide.sleep;
import static practicetest.utils.RandomUtils.*;

public class RegistrationRandomUtilsTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TableResultComponent tableResult = new TableResultComponent();

    @Test
    void fillRegistrationFormTest() {

        registrationPage.openPage()
                .removeBanner()
                .removeFooter()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobby)
                .setUploadPicture(image)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .setSubmit();

        tableResult
                .checkResult(firstName)
                .checkResult(lastName)
                .checkResult(userEmail)
                .checkResult(gender)
                .checkResult(userNumber)
                .checkResult(day + " " + month + "," + year)
                .checkResult(subject)
                .checkResult(hobby)
                .checkResult(image)
                .checkResult(address)
                .checkResult(state + " " + city);

    }
}
