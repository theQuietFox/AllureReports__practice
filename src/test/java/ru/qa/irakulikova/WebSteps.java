package ru.qa.irakulikova;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу GitHub")
    public WebSteps openMainPage() {
        open("https://github.com");
        return this;
    }

    @Step("Ищем репозиторий {repo}")
    public WebSteps searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
        return this;
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public WebSteps clickOnRepository(String repo) {
        $(By.linkText(repo)).click();
        $("#issues-tab").click();
        return this;
    }

    @Step("Открываем таб Issues")
    public WebSteps openIssuesTab() {
        $("#issues-tab").click();
        return this;
    }

    @Step("Проверяем наличие Issues с номером {issue}")
    public WebSteps shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
        return this;
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver())
                .getScreenshotAs(OutputType.BYTES);
    }
}
