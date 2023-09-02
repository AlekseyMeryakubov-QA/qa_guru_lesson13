package practicetest.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import practicetest.pages.RegistrationPage;
import practicetest.pages.components.TableResultComponent;

import static io.qameta.allure.Allure.step;
import static practicetest.utils.RandomUtils.*;

public class RegistrationRandomUtilsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TableResultComponent tableResultComponent = new TableResultComponent();

    @Test
    @Tag("demoQA")
    @Tag("registration")
    void fillRegistrationFormTest() {
        step("Открыта форма регистрации", () -> {
            registrationPage.openPage()
                    .removeBanner()
                    .removeFooter();
        });

        step("Заполнение полей формы", () -> {
            registrationPage.setFirstName(firstName)
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
        });

        step("Проверка заполнения формы", () -> {
            tableResultComponent
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
        });
    }
}
