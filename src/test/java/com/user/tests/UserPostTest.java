package com.user.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import org.junit.Test;
import com.user.base.TestBase;
import com.user.model.User;

import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import static io.restassured.RestAssured.given;

@Epic("All tests for User")
@DisplayName("User request for post")
@Feature("User Post Request")

public class UserPostTest extends TestBase {
    @Link("https://medium.com/@sevilayal")
    @DisplayName("Create User")
    @Story("User is creating")
    @Description("This request includes creating user")
    @Test
    public void createUser() {
        User user = new User();
        user.setName("Sevilay");
        user.setJob("Test Automation Engineer");
        String Resp = given()
                .contentType(ContentType.JSON)
                .when()
                .body(user)
                .post("/users")
                .then().assertThat().
                        statusCode(201).and().
                        contentType(ContentType.JSON).and().
                        extract().
                        response().asString();
        System.out.println("Response is\t" + Resp);
    }

    @DisplayName("Register User Unsuccessfully")
    @Story("User is registering")
    @Description("This request includes missing register for user")
    @Test
    public void registerUnsuccessful() {
        User user = new User();
        user.setEmailFail("sydney@fife");
        given()
                .contentType(ContentType.JSON)
                .when()
                .body(user)
                .post("/register")
                .then()
                .statusCode(400)
                .assertThat()
                .body("error", equalTo("Missing email or username"));
    }

}
