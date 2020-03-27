package com.user.tests;


import com.user.base.TestBase;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Epic("All tests for User")
@DisplayName("User request for get")
@Feature("Get Request")

public class UserGetTest extends TestBase {
    @Link("https://www.youtube.com/channel/UCdUaAKTLJrPZFStzEJnpQAg")
    @DisplayName("All user list")
    @Story("All of user")
    @Description("This request includes all of user")
    @Test
    public void getAllUsersInformation() {
        Response response = given()
                .when().log().ifValidationFails()
                .get("/user");
        System.out.println(response.body().prettyPrint());
        given()
                .when()
                .get("/user")
                .then()
                .statusCode(200);
    }

    @DisplayName("Get All userName")
    @Story("List of UserName")
    @Description("This request includes userNames")
    @Test
    public void getAllUserName() {
        List names = given()
                .when().log().ifValidationFails()
                .get("/user")
                .then()
                .extract().path("data.name");
        System.out.println("The user name are " + names);
    }

    @DisplayName("user page limit")
    @Story("user Page")
    @Description("This request includes page 2")
    @Test
    public void getUsersPage() {
        Response response = given()
                .param("page", 2)
                .log()
                .params()
                .when().log().ifValidationFails()
                .get("/user");
        System.out.println(response.body().prettyPrint());
    }

    @DisplayName("Year verification of single user")
    @Story("Get Request for Single User")
    @Description("This request includes user :2")
    @Test
    public void getSingleUser() {
        given()
                .when().log().ifValidationFails()
                .get("/user/2")
                .then()
                .body("data.year", equalTo(2001));
    }

    @DisplayName("Get first user's year")
    @Story("Extract first user's year")
    @Description("This request extract first user's year")
    @Test
    public void getSingleYearForUser() {
        int year = given()
                .when()
                .get("/user")
                .then()
                .extract().path("data[0].year");
        System.out.println("First user's year is: " + year);
    }

    @DisplayName("Extract Single User name for Id:2")
    @Story("Get Single UserName")
    @Description("This request includes userName Id :2")
    @Test
    public void getSingleUserName() {
        String name = given()
                .when().log().ifValidationFails()
                .get("/user/2")
                .then()
                .extract().path("data.name");
        System.out.println("The user name is " + name);
    }
}
