package wad.stackoverclone.selenium.pageobjects;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("/questions")
public class QuestionsPage extends FluentPage {

    @FindBy(id = "questions-list")
    private FluentWebElement questionsList;

    public boolean questionsListIsVisible() {
        return questionsList.displayed();
    }

}
