package model;

import com.github.javafaker.Faker;
import core.RequestHandler;
import endpoints.CreateUserEndPoint;
import endpoints.GetSingleUserEndPoint;
import io.restassured.response.Response;
import responses.CreateUserResponse;
import responses.GetSingleUserResponse;

public class ReqResClient {
    public CreateUserResponse createUser(String name, String job) {
        CreateUserEndPoint createUserEndPoint = new CreateUserEndPoint(name, job);
        Response response = new RequestHandler().handleRequest(createUserEndPoint);
        System.out.println(response.asString());
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.getStatusCode());
        return createUserResponse;
    }

    public GetSingleUserResponse getUser(String id) {
        GetSingleUserEndPoint getSingleUserEndPoint = new GetSingleUserEndPoint(id);
        Response response = new RequestHandler().handleRequest(getSingleUserEndPoint);
        System.out.println(response.asString());
        GetSingleUserResponse getSingleUserResponse = response.as(GetSingleUserResponse.class);
        getSingleUserResponse.setStatusCode(response.getStatusCode());
        return getSingleUserResponse;
    }
}
