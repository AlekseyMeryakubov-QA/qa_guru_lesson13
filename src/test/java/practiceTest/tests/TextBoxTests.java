package practiceTest.tests;

import org.junit.jupiter.api.Test;
import practiceTest.pages.TextBoxPages;
import practiceTest.pages.components.TableResultComponent;

public class TextBoxTests extends TestBase {

        TextBoxPages textBoxPages = new TextBoxPages();
        TableResultComponent result = new TableResultComponent();

        @Test
        public void fillFormTest() {
            textBoxPages.openPage()
                    .setUserName("Alex Egorov")
                    .setUserEmail("alex@egorov.com")
                    .setCurrentAddress("Some address 1")
                    .setPermanentAddress("Another address 1")
                    .setSubmitButton();

            result.verification("Alex Egorov")
                    .verification("alex@egorov.com")
                    .verification("Some address 1")
                    .verification("Another address 1");
        }
}
