package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SimpleSelenideTest extends TestBase {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $("button[aria-label*='Search']").click();

        $("input[aria-label='Search or jump to']")
                .setValue("gaukhar-madi/allure_reports_hw")
                .pressEnter();

        $(linkText("gaukhar-madi/allure_reports_hw")).click();
        $("#issues-tab").click();
        $(byText("Allure Homework Issue")).shouldBe(Condition.visible);
    }
}