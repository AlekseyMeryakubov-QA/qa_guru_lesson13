package practicetest.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import practicetest.pages.TextBoxPage;

import static io.qameta.allure.Allure.step;
import static practicetest.utils.RandomUtils.*;

public class TextBoxPageTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @Tag("demoQA")
    @Tag("textBoxTest")
    @DisplayName("Успешная регистрация TextBox")
    void textBoxTest() {

        step("Открыть форму", () -> {
            textBoxPage.openPage()
                    .removeBannerText()
                    .removeFooterText();
        });

        step("Заполнить поля", () -> {
            textBoxPage.setFullName(fullName)
                    .setEmail(userEmail)
                    .setCurrentAddress(address)
                    .clickOnSubmitButton();
        });

        step("Проверить результат заполнения формы", () -> {
            textBoxPage.checkOverResultName(fullName)
                    .checkOverResultEmail(userEmail)
                    .checkOverResultCurrentAddress(address);
        });
    }
}

