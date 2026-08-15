package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class LambdaStepsTest extends TestBase {

    @Test
    void testIssueSearch() {

        Allure.step("Открыть главную страницу GitHub", () -> {
            open("https://github.com");
        });

        Allure.step("Найти репозиторий gaukhar-madi/allure_reports_hw", () -> {
            $(".input-button").click();
            $("#query-builder-test")
                    .setValue("gaukhar-madi/allure_reports_hw")
                    .pressEnter();
        });

        Allure.step("Открыть репозиторий", () -> {
            $(By.linkText("gaukhar-madi/allure_reports_hw")).click();
        });

        Allure.step("Перейти во вкладку Issues", () -> {
            $("#issues-tab").click();
        });

        Allure.step("Проверить наличие Issue #1", () -> {
            $(withText("#1")).should(Condition.exist);
        });
    }
}
