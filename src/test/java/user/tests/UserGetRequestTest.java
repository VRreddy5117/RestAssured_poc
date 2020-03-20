package user.tests;


import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

@Epic("All tests for User Get Request")
@Feature("User Test Feature")
@DisplayName("User get request")

public class UserGetRequestTest {
    @Link("https://www.youtube.com/channel/UCdUaAKTLJrPZFStzEJnpQAg")
    @DisplayName("All user list")
    @Story("All of user")
    @Description("This request includes all of user")
    @Test
    public void getAllUsersInformation(){
       Response response= given()
                .when()
                .get("https://reqres.in/api/user");
        System.out.println(response.body().prettyPrint());
        given()
                .when()
                .get("https://reqres.in/api/user")
                .then()
                .statusCode(200);
    }
}
