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
import wad.stackoverclone.selenium.pageobjects.LoginPage;
import wad.stackoverclone.selenium.pageobjects.QuestionsPage;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginLogoutTests extends FluentTest{

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
    private QuestionsPage questionsPage;

    @Before
    public void setUp() {
        setDeleteCookies(true);
    }

    @Test
    public void errorMessageShouldBeVisibleWithInvalidCredentials() {
        loginPage.go();
        loginPage.login("Adgrgrmin", "jogjossjgiasjiga");
        assertThat(loginPage.invalidCredentialsMessageIsVisible());
    }

    @Test
    public void successfulLogoutMessageShouldBeVisibleAfterLogginOut() {
        loginPage.go();
        loginPage.login("Admin", "password1");
        questionsPage.clickLogout();
        assertThat(loginPage.logoutSuccessMessageIsVisible());
    }

}
