package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WeatherUs extends PageObject {

    @FindBy(xpath = "//p[text()='Welcome to our weather portal']")
    private WebElementFacade alertMainTittle;

    @FindBy(xpath = "//input[@placeholder='Search for location']")
    private WebElementFacade locationSearcher;

    @FindBy(xpath = "//div[contains(@class, 'message-container')]//button")
    private WebElementFacade iFrameAcceptButton;

    @FindBy(xpath = "(//span[@title='Search'])[2]")
    private WebElementFacade searchBottom;

    @FindBy(xpath = "//iframe[@title='Iframe title']")
    private WebElementFacade iFrame;

    public void manageIframe(){
        waitFor(ExpectedConditions.visibilityOf(iFrame));
        getDriver().switchTo().frame(iFrame);
        iFrameAcceptButton.click();
    }

    public void inputLocationToSearch(String text){
        waitFor(ExpectedConditions.visibilityOf(locationSearcher));
        locationSearcher.sendKeys(text);
        searchBottom.click();
    }

    public void clickOnSearchBottom(){
        waitFor(ExpectedConditions.visibilityOf(searchBottom));
        searchBottom.click();
    }

}