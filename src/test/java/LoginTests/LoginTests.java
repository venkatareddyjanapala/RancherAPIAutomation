package LoginTests;

import com.restassured.core.helpers.LoginHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    LoginHelper loginHelper = new LoginHelper();

    @Test()
    public void verifyLogin() {
        loginHelper.getEnvironmentDetails();
        Response response = loginHelper.getLogin();
        Assert.assertEquals(200,
                response.getStatusCode());
       // Assert.assertTrue(response.jsonPath().getString("user").contains(loginHelper.getUserName()));
    }
}
