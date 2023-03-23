package starter.API;

import static io.restassured.RestAssured.*;

public class ForecastEndpoint {

    /**
     * The idea of this endpoint execution it's about get an specific temperature once we execute it. The endpoint it's the following:
     * https://api.openweathermap.org/data/3.0/onecall?lat=-31.4135000&lon=-64.1810500 using the api-key 52c8d54e221347e01e2c9cfac6c10301
     *
     * Read more about it in the following URL:
     */
    public String executeEndPoint(){
        String backEndForecast = given()
                                        .baseUri("https://api.openweathermap.org")
                                        .header("X-Api-Key","52c8d54e221347e01e2c9cfac6c10301")
                                        .log().all()
                                 .when()
                                        .get("/data/3.0/onecall?lat=-31.4135000&lon=-64.1810500")
                                 .then()
                                         .log().all()
                                         .assertThat().statusCode(200)
                                         .extract().response().path("message");
        /** My idea here, in the last step, was related to extract from the response body a specific temperature that I could have saved on
         "backEndForecast" variable to return it to MyStepsDefinition java class. But I can not get how this page
         https://openweathermap.org/api/one-call-3 works to be allowed to execute well this endpoint.
         Today I'm getting a 401 with the following message on the response body:

         {
         "cod": 401,
         "message": "Please note that using One Call 3.0 requires a separate subscription to the One Call by Call plan. Learn more here https://openweathermap.org/price. If you have a valid subscription to the One Call by Call plan, but still receive this error, then please see https://openweathermap.org/faq#error401 for more info."
         }
         */
        return backEndForecast;
    }
}