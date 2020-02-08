package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import utils.ConfigurationReader;
import utils.apiservices.Service;

public class APISteps {

    @When("user sends GET exchange rate api request for {string}")
    public void user_sends_GET_exchange_rate_api_request_for(String tickerSymbol) {
        Service.runGetRequest(String.format("%s%s", ConfigurationReader.getProperty("exchangeRateEndpoint"), tickerSymbol));
    }

    @Then("{string} should be returned")
    public void should_be_returned(String statusCode) {
        Assert.assertEquals(Service.getStatusCode(),Integer.parseInt(statusCode));
    }

    @Then("error message with following {string} should be returned")
    public void error_message_with_following_should_be_returned(String mandatory_field) {
        Assert.assertEquals(mandatory_field,Service.getResp().jsonPath().getString("error_type"));
    }

}
