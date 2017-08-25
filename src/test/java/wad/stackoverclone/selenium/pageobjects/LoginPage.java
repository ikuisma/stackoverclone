package wad.stackoverclone.selenium.pageobjects;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("/login")
public class LoginPage extends FluentPage {

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private FluentWebElement submitButton;

    @FindBy(xpath = ".//form[@action=\"/login\"]")
    private FluentWebElement loginForm;

    public void login(String username, String password) {
        $("input").fill().with(username, password);
        submitButton.click();
    }

    public boolean loginFormIsVisible() {
        return loginForm.displayed();
    }

}
