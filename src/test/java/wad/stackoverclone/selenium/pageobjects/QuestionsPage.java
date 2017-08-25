package wad.stackoverclone.selenium.pageobjects;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("/questions")
public class QuestionsPage extends FluentPage {

    @FindBy(id = "questions-list")
    private FluentWebElement questionsList;

    @FindBy(id = "logout")
    private FluentWebElement logoutButton;

    public boolean questionsListIsVisible() {
        return questionsList.displayed();
    }

    public void clickLogout() {
        logoutButton.click();
    }

}
