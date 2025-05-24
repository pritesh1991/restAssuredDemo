import datprovider.UserDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import responses.CreateUserResponse;
import responses.GetSingleUserResponse;

public class UserTests extends Tests {

    @Test(priority = 1)
    public void createUserTest(){
        String name="abc";
        String job="Test engineer";
        CreateUserResponse user = reqResClient.createUser(name, job);
        Assert.assertEquals(user.getStatusCode(),201, "Status code doesn't match");
    }
    @Test(priority = 2, dataProvider = "userdata",dataProviderClass = UserDataProvider.class)
    public void getUserDetailsTest(String userId,String firstName,String lastName,String email){

        GetSingleUserResponse user = reqResClient.getUser(userId);
        Assert.assertEquals(user.getData().getFirstName(),firstName);
        Assert.assertEquals(user.getData().getLastName(),lastName);
        Assert.assertEquals(user.getData().getEmail(),email);

    }

}
