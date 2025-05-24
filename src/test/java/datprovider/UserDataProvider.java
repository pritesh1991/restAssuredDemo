package datprovider;

import org.testng.annotations.DataProvider;

public class UserDataProvider {

    @DataProvider(name = "userdata")
    public static Object[][] getUserDetails(){
        return new Object[][]{
                {"7","Michael","Lawson","michael.lawson@reqres.in"},
                {"8","Lindsay","Ferguson","lindsay.ferguson@reqres.in"},
                {"9","Tobias","Funke","tobias.funke@reqres.in"},
        };
    }

}
