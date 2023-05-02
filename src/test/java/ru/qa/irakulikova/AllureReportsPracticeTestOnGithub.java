package ru.qa.irakulikova;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utils.SetUp;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AllureReportsPracticeTestOnGithub extends SetUp {

    private static String REPOSITORY = "eroshenkoam/allure-example";
    private static int ISSUE = 80;

    @Test
    public void testIssueCheck() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();

        $(By.linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE)).should(Condition.exist);

    }

    @Test
    public void testIssueCheckWithLambda() {

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
            $("#issues-tab").click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issues с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    @Test
    public void testIssueCheckWithAnnotatedStep() {

        WebSteps steps = new WebSteps();
        steps.openMainPage()
                .searchForRepository(REPOSITORY)
                .clickOnRepository(REPOSITORY)
                .openIssuesTab()
                .shouldSeeIssueWithNumber(ISSUE)
                .takeScreenshot();
    }
}