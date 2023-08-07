package practiceTest.tests;

import org.junit.jupiter.api.Test;
import practiceTest.pages.RegistrationPage;
import practiceTest.pages.components.TableResultComponent;

public class RegistrationTest extends TestBase {

        RegistrationPage registrationPage = new RegistrationPage();
        TableResultComponent tableResult = new TableResultComponent();

        @Test
        void fillRegistrationFormTest() {
            registrationPage.openPage()
                    .removeBanner()
                    .setFirstName("Alex")
                    .setLastName("Egorov")
                    .setUserEmail("alex@egorov.com")
                    .setGender("Male")
                    .setUserNumber("1234567890")
                    .setBirthDate("01","July","2005")
                    .setSubjects("History")
                    .setHobbies("Sports")
                    .setUploadPicture("image.png")
                    .setCurrentAddress("New York")
                    .setState("Haryana")
                    .setCity("Karnal")
                    .setSubmit();


            tableResult.checkResult("Alex Egorov")
                    .checkResult("alex@egorov.com")
                    .checkResult("Male")
                    .checkResult("01 July,2005")
                    .checkResult("1234567890")
                    .checkResult("Sports")
                    .checkResult("image.png")
                    .checkResult("New York")
                    .checkResult("Haryana Karnal");

        }
}
