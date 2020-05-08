package com.user.tests;

import com.user.base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class UserDeleteTest extends TestBase {

    @Test(description ="This request includes user: 2")
    public void deleteSingleUser() {
        given()
                .when().log().ifValidationFails()
                .delete("/user/2")
                .then();
             //   .body("data.year", equalTo(2001));
    }

}
