package starter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fluentlenium.core.annotation.Page;
import starter.API.ForecastEndpoint;
import starter.pages.GoogleHome;
import starter.pages.GoogleResultPage;
import starter.pages.WeatherUs;
import starter.pages.WeatherUsCitySearched;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MyStepsDefinition {

    @Page
    GoogleHome googleHome;

    @Page
    GoogleResultPage googleResultPage;

    @Page
    WeatherUs weatherUs;

    @Page
    WeatherUsCitySearched weatherUsCitySearched;

    ForecastEndpoint forecastEndpoint;

    String frontEndTemperature = "";
    String backEndForecast = "";

    @Given("I open Google homepage")
    public void iOpenGoogleHomepage() {
        googleHome.openGoogle();
    }

    @When("I input {string} in the search bar")
    public void iInputInTheSearchBar(String text) {
        googleHome.inputTextOnSearchBar(text);
    }

    @And("I click on submit bottom")
    public void iClickOnSubmitBottom() {
        googleHome.clickOnSearchButton();
    }

    @And("I click on weather.us link")
    public void iClickOnWeatherUsLink() {
        googleResultPage.clickOnWeatherUsLink();
    }

    @And("accept Terms and conditions of Weather.us")
    public void acceptTermsAndConditionsOfWeatherUs() {
        weatherUs.manageIframe();
    }

    @And("input {string} on Weather worldwide searcher")
    public void inputOnWeatherWorldwideSearcher(String text) throws InterruptedException {
        weatherUs.inputLocationToSearch(text);
        //weatherUs.clickOnSearchBottom();
        frontEndTemperature = weatherUsCitySearched.getFrontEndTemperature();
    }

    @And("I execute the webservice to get our temperature in Cordoba")
    public void iExecuteTheWebserviceToGetOurTemperatureInCordoba() {
        forecastEndpoint.executeEndPoint();
    }

    @Then("I get my temperatures from Weather.us and the web service execution")
    public void iGetMyTemperaturesFromWeatherUsAndTheWebServiceExecution() {
        assertThat(frontEndTemperature).isEqualTo(backEndForecast);
    }
}