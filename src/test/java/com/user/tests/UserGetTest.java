package com.user.tests;


import com.user.base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class UserGetTest extends TestBase {


    @Test(description = "This request includes all of user", dependsOnGroups = {"second"}, dependsOnMethods = "getAllUserName")
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



    @Test(description ="This request includes userNames", priority = 0)
    public void getAllUserName() {
        List names = given()
                .when().log().ifValidationFails()
                .get("/user")
                .then()
                .extract().path("data.name");
        System.out.println("The user name are " + names);
    }

    @Test (groups = "second",description ="This request includes page 2" )
    public void getUsersPage() {
        Response response = given()
                .param("page", 2)
                .log()
                .params()
                .when().log().ifValidationFails()
                .get("/user");
        System.out.println(response.body().prettyPrint());
    }

    @Test(description ="This request includes user: 2")
    public void getSingleUser() {
        given()
                .when().log().ifValidationFails()
                .get("/user/2")
                .then()
                .body("data.year", equalTo(2001));
    }

    @Test(description ="This request includes user: 2",enabled = false)
    public void getSingleUser1() {
        given()
                .when().log().ifValidationFails()
                .get("/user/2")
                .then()
                .body("data.year", equalTo(2001));
    }


    @Test(description ="This request extract first user's year")
    public void getSingleYearForUser() {
        int year = given()
                .when()
                .get("/user")
                .then()
                .extract().path("data[0].year");
        System.out.println("First user's year is: " + year);
    }


    @Test(description = "This request includes userName Id :2",priority = 4)
    public void getSingleUserName() {
        String name = given()
                .when().log().ifValidationFails()
                .get("/user/2")
                .then()
                .extract().path("data.name");
        System.out.println("The user name is " + name);
    }
}
