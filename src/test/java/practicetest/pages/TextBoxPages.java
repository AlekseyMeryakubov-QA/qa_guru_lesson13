package practicetest.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPages {
    static {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
    }


    SelenideElement
            userNameInput =   $("#userName"),
            userEmailInput =   $("#userEmail"),
            currentAddressInput =   $("#currentAddress"),
            permanentAddressInput =   $("#permanentAddress"),
            submitButton =   $("#submit");
   public TextBoxPages openPage() {
        open("/text-box");

       return this;
   }
    public TextBoxPages setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }
    public TextBoxPages setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    public TextBoxPages setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }
    public TextBoxPages setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }
    public TextBoxPages setSubmitButton() {
        submitButton.click();

        return this;
    }
}
