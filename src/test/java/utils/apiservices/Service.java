package utils.apiservices;

import beans.ExchangeRateResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Objects;

public class Service {

    private static ExchangeRateResponse response;
    private static ObjectMapper mapper = new ObjectMapper();
    private static int statusCode;
    private static Response resp;

    public static void runGetRequest(String uri) {
        resp = RestAssured.get(uri);
        statusCode = resp.statusCode();

        try {
            response = mapper.readValue(Objects.requireNonNull(resp).asString(), ExchangeRateResponse.class);
        } catch (IOException e) {
            System.out.println("JSON could not map Exchange Rate Response object");
        }
    }

    public static ExchangeRateResponse getResponse() {
        return response;
    }

    public static Response getResp(){
        return resp;
    }

    public static int getStatusCode() {
        return statusCode;
    }

}