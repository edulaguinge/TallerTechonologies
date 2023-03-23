package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import starter.utils.GlobalConfig;

public class GoogleHome extends PageObject {

    @FindBy(xpath = "//input[@name='q']")
    private WebElementFacade searchBar;

    @FindBy(xpath = "(//input[@class='gNO89b'])[1]")
    private WebElementFacade searchButton;

    @FindBy(xpath = "(//img)[2]")
    private WebElementFacade googleImage;

    public void openGoogle(){
        getDriver().get(GlobalConfig.GOOGLE_HOME);
    }

    public void inputTextOnSearchBar(String text){
        waitFor(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(text);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    private void clickOnGoogleImage(){
        googleImage.click();
    }

}