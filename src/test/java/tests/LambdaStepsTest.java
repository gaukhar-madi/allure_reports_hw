package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class LambdaStepsTest extends TestBase {

    @Test
    void testIssueSearch() {

        Allure.step("Открыть главную страницу GitHub", () -> {
            open("https://github.com");
        });

        Allure.step("Найти репозиторий gaukhar-madi/allure_reports_hw", () -> {
            $("button[aria-label*='Search']").click();
            $("input[aria-label='Search or jump to']")
                    .setValue("gaukhar-madi/allure_reports_hw")
                    .pressEnter();
        });

        Allure.step("Открыть репозиторий", () -> {
            $(linkText("gaukhar-madi/allure_reports_hw")).click();
        });

        Allure.step("Перейти во вкладку Issues", () -> {
            $("#issues-tab").click();
        });

        Allure.step("Проверить наличие конкретного Issue", () -> {
            $(byText("Allure Homework Issue")).shouldBe(Condition.visible);
        });
    }
}
