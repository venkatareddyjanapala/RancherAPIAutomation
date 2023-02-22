package LoginTests;

import com.restassured.core.helpers.LoginHelper;
import com.restassured.core.helpers.StackHelpers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class LoginTests extends TestBase {
    LoginHelper loginHelper = new LoginHelper();
    StackHelpers stackHelpers = new StackHelpers();
    @Test(description = "verifyLogin")
    public void verifyLogin() {
        loginHelper.getEnvironmentDetails();
        Response response = loginHelper.getLogin();
        String token=response.jsonPath().getString("jwt");
        System.out.println("The token is:" + token);
    }

    @Test(description = "verifyLogin")
    public void createStack() throws FileNotFoundException {
        loginHelper.getEnvironmentDetails();
        Response response = loginHelper.getLogin();
        String token=response.jsonPath().getString("jwt");
        System.out.println("The token is:" + token);
        String projectName="1a5";
        String stackName="myStackVenkat";
        stackHelpers.createStack(projectName,stackName,token);
    }
}
