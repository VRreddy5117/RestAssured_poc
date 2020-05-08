package com.user.tests;

import com.user.base.TestBase;
import com.user.model.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jdk.nashorn.internal.parser.JSONParser;
import org.testng.annotations.Test;

import java.io.FileReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class UserPostTest extends TestBase {

    @Test(description = "This request for creating user")
    public void createUser() {
/*
        Response postresponse = null;
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader("src/main/resources/CreateJSON_file.json"));

            JSONObject jsonObject = (JSONObject) obj;*/
        User user = new User();
        user.setName("venkat");
        user.setJob("Test Engineer");
        String Resp = given()
                .contentType(ContentType.JSON)
                .when().log().ifValidationFails()
                .body(user)
                .post("/users")
                .then().assertThat().
                        statusCode(201).and().
                        contentType(ContentType.JSON).and().
                        extract().
                        response().asString();
        System.out.println("Response is\t" + Resp);
    }


    @Test(description = "This request includes missing register for user")
    public void registerUnsuccessful() {
        User user = new User();
        user.setEmailFail("restApi@test.com");
        given()
                .contentType(ContentType.JSON)
                .when().log().ifValidationFails()
                .body(user)
                .post("/register")
                .then()
                .statusCode(400)
                .assertThat()
                .body("error", equalTo("Missing email or username"));
    }

}
