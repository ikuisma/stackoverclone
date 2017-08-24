package wad.stackoverclone.selenium.pageobjects;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

@PageUrl("/home")
public class HomePage extends FluentPage {

    @FindBy(xpath = "//div[contains(@class, 'card-block')]")
    private FluentWebElement pageTitle;

    public String getTextFromCard() {
        return pageTitle.text();
    }


}
