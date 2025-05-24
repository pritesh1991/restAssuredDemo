package core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class RequestHandler {

    public Response handleRequest(IServiceEndpoint iServiceEndpoint) {
        RequestSpecification specs = setRequestSpecification(iServiceEndpoint);
        switch (iServiceEndpoint.method()) {
            case GET -> {
                return RestAssured.given().spec(specs).get(iServiceEndpoint.url());
            }
            case POST -> {
                return RestAssured.given().spec(specs).post(iServiceEndpoint.url());
            }
            case PATCH -> {
                return RestAssured.given().spec(specs).patch(iServiceEndpoint.url());
            }
            case PUT -> {
                return RestAssured.given().spec(specs).put(iServiceEndpoint.url());
            }
            case DELETE -> {
                return RestAssured.given().spec(specs).delete(iServiceEndpoint.url());
            }
            default -> throw new UnsupportedOperationException("Unsupported HTTP method: " + iServiceEndpoint.method());
        }
    }

    private RequestSpecification setRequestSpecification(IServiceEndpoint iServiceEndpoint) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        // Add headers if not null
        Map<String, String> headers=new HashMap<>();
        if (iServiceEndpoint.headers() != null) {
            headers.putAll(iServiceEndpoint.headers());
        }
        // accommodating static "x-api-key" header
        headers.put("x-api-key","reqres-free-v1");
        requestSpecBuilder.addHeaders(headers);

        // Set body if not null
        if (iServiceEndpoint.body() != null) {
            requestSpecBuilder.setBody(iServiceEndpoint.body());
        }
        return requestSpecBuilder.build();
    }
}
