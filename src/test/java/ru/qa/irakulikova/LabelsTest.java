package ru.qa.irakulikova;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("ru.qa.irakulikova")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com")
    @DisplayName("Создание issues для авторизованного пользователя")
    public void testStaticLabels() {
    }

    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание issues для авторизованного пользователя")
        );
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("owner", "ru.qa.irakulikova");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://github.com");
    }

}
