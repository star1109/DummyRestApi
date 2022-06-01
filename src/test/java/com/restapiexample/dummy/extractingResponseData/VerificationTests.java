package com.restapiexample.dummy.extractingResponseData;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class VerificationTests {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://dummy.restapiexample.com";
        RestAssured.basePath = "/api/v1";
        response = given()
                .when()
                .get("/employees")
                .then().statusCode(200);
    }

    //1. total records are 24
    @Test
    public void test001() {
        int records = response.extract().path("data.size");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total records are : " + records);
        System.out.println("------------------End of Test---------------------------");
    }

    //2. data[23].id = 24
    @Test
    public void test002() {
        int id = response.extract().path("data[23].id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("data[23].id = " + id);
        System.out.println("------------------End of Test---------------------------");
    }

    //3. data[23].employee_name = “Doris Wilder”
    @Test
    public void test003() {
        String name = response.extract().path("data[23].employee_name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("data[23].employee_name = " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //4. message = “Successfully! All records has been fetched.”
    @Test
    public void test004() {
        String message = response.extract().path("message");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("message = " + message);
        System.out.println("------------------End of Test---------------------------");
    }

    //5.status = success
    @Test
    public void test005() {
        String message = response.extract().path("status");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("status = " + message);
        System.out.println("------------------End of Test---------------------------");
    }
    //6. id = 3 has employee_salary = 86000
    @Test
    public void test006() {
        int id = response.extract().path("data[2].id");
        int salary = response.extract().path("data[2].employee_salary");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("id "+ id +" has employee_salary = " + salary);
        System.out.println("------------------End of Test---------------------------");
    }
    //7. id = 6 has employee_age = 61
    @Test
    public void test007() {
        int id = response.extract().path("data[5].id");
        int age = response.extract().path("data[5].employee_age");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("id "+ id +" has employee_age = " + age);
        System.out.println("------------------End of Test---------------------------");
    }
    //8. id = 11 has employee_name = Jena Gaines
    @Test
    public void test008() {
        int id = response.extract().path("data[10].id");
        String name = response.extract().path("data[10].employee_name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("id "+ id +" has employee_name = " + name);
        System.out.println("------------------End of Test---------------------------");
    }
}