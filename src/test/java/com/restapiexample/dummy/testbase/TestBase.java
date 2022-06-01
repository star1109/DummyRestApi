package com.restapiexample.dummy.testbase;


import com.restapiexample.dummy.utils.TestUtils;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase extends TestUtils {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://dummy.restapiexample.com";
        RestAssured.basePath = "/api/v1";

    }
}
