package core;

import java.util.Map;

public interface IServiceEndpoint {
    String url();

    HttpMethod method();

    Map<String, String> headers();

    String body();
}
