package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleResultPage extends PageObject {

    @FindBy(xpath = "//h3[text()='Search for weather on a specific location - Weather.us']")
    private WebElementFacade weatherLink;

    public void clickOnWeatherUsLink(){
        waitFor(ExpectedConditions.visibilityOf(weatherLink));
        weatherLink.click();
    }
}