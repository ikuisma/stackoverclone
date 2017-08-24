package wad.stackoverclone.selenium;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wad.stackoverclone.selenium.pageobjects.HomePage;
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
    private HomePage homePage;

    @Test
    public void userCanOpenPageAndSeeTitleOfApplication() {
        homePage.go();
        assertThat(homePage.getDriver().getTitle()).contains("StackOverClone");
        assertThat(homePage.getTextFromCard()).contains("StackOverClone");
    }

}
