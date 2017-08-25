package wad.stackoverclone.selenium;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wad.stackoverclone.selenium.pageobjects.HomePage;
import wad.stackoverclone.selenium.pageobjects.LoginPage;
import wad.stackoverclone.selenium.pageobjects.QuestionsPage;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomePageTests extends FluentTest {

    @Override
    public WebDriver newWebDriver() {
        return new HtmlUnitDriver();
    }

    @LocalServerPort
    private Integer port;

    @Override
    public String getBaseUrl() {
        return "http://localhost:" + port;
    }

    @Page
    private LoginPage loginPage;

    @Page
    private HomePage homePage;

    @Page
    private QuestionsPage questionsPage;

    @Before
    public void setUp() {
    }

    @Test
    public void userCanOpenPageAndSeeTitleOfApplication() {
        loginPage.go();
        loginPage.login("Admin", "password1");
        homePage.go();
        assertThat(homePage.getDriver().getTitle()).contains("StackOverClone");
        assertThat(homePage.getTextFromCard()).contains("StackOverClone");
    }

    @Test
    public void clickingButtonRedirectsToQuestionsPage() {
        loginPage.go();
        loginPage.login("Admin", "password1");
        homePage.go();
        homePage.clickGoToQuestionsButton();
        assertThat(questionsPage.questionsListIsVisible());
    }

}
