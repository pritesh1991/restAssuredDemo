package endpoints;

import com.google.gson.Gson;
import core.HttpMethod;
import core.IServiceEndpoint;
import properties.ReqResProperties;
import requests.CreateUserRequest;

import java.util.Map;

public class GetSingleUserEndPoint implements IServiceEndpoint {
    String baseUrl = "";
    String id;

    public GetSingleUserEndPoint(String id) {
        this.id = id;
    }

    @Override
    public String url() {
        return ReqResProperties.GET_SINGLE_USER + id;
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.GET;
    }

    @Override
    public Map<String, String> headers() {
        return null;
    }

    @Override
    public String body() {
        return null;
    }
}
