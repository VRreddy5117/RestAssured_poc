package com.user.tests;

import com.user.base.baseClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class DeleteUserTest extends baseClass {

    @Test(description ="This request includes user: 2")
    public void deleteSingleUser() {
        given()
                .when().log().ifValidationFails()
                .delete("/user/2")
                .then();
             //   .body("data.year", equalTo(2001));
    }

}
