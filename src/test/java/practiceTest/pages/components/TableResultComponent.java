package practiceTest.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TableResultComponent {

        SelenideElement
                tableResult = $(".table-responsive"),
                result = $("#output");

        public TableResultComponent checkResult(String value) {
            tableResult.shouldHave(text(value));

            return this;
        }
        public TableResultComponent verification(String value) {
            result.shouldHave(text(value));

            return this;
        }
}
