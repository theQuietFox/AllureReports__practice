package utils;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class SetUp {

    @BeforeAll
    static void setUpTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }
}