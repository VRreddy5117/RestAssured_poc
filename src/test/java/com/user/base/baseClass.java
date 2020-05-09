package com.user.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class baseClass {
    @BeforeClass
    public static void init(){
        RestAssured.baseURI="https://reqres.in";
        RestAssured.basePath="/api";
    }
}
