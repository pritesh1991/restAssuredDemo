package properties;

import helpers.PropertiesReader;

public class ReqResProperties {

    private static final String BASE_URL = PropertiesReader.getProperty("baseUrl").toLowerCase();
    public static String GET_SINGLE_USER = BASE_URL + "/api/users/";
    public static String CREATE_USER = BASE_URL + "/api/users";
}
