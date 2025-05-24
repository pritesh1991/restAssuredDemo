package endpoints;

import com.google.gson.Gson;
import core.HttpMethod;
import core.IServiceEndpoint;
import properties.ReqResProperties;
import requests.CreateUserRequest;

import java.util.Map;

public class CreateUserEndPoint implements IServiceEndpoint {

    CreateUserRequest createUserRequest;
    String name, job;

    public CreateUserEndPoint(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public String url() {
        return ReqResProperties.CREATE_USER;
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.POST;
    }

    @Override
    public Map<String, String> headers() {
        return null;
    }

    @Override
    public String body() {
        createUserRequest = new CreateUserRequest();
        createUserRequest.setJob(job);
        createUserRequest.setName(name);
        Gson gson = new Gson();
        return gson.toJson(createUserRequest);
    }
}
