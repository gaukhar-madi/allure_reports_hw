package tests;

import org.junit.jupiter.api.Test;

public class StepsAnnotationTest extends TestBase {
    private final WebSteps steps = new WebSteps();

    @Test
    void testIssueSearch() {

        steps.openMainPage();
        steps.searchForRepository("gaukhar-madi/allure_reports_hw");
        steps.clickOnRepositoryLink("gaukhar-madi/allure_reports_hw");
        steps.openIssuesTab();
        steps.shouldSeeIssueWithName("Allure Homework Issue");
    }
}
