package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import starter.utils.WeatherUsCitySearchedUtils;

public class WeatherUsCitySearched extends PageObject {

    @FindBy(xpath = "(//div[@class='fc-temp'])[1]")
    private WebElementFacade forecastTemperature;

    @FindBy(xpath = "//h3[text()='Forecast']")
    private WebElementFacade forecastTitle;

    public String getFrontEndTemperature() throws InterruptedException {
        wait(50000);
        waitFor(ExpectedConditions.visibilityOf(forecastTitle));
        WeatherUsCitySearchedUtils.scrollToElement(forecastTitle);
        String frontEndTemperature = forecastTemperature.getText();
        System.out.println("FRONT-END Forecast value: " + frontEndTemperature);
        return frontEndTemperature;
    }
}