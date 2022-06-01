package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class employeeGetTest extends TestBase {

    @Test
    public void getAllEmployee(){
        Response response = given()
                .header("Authorization","Bearer ba41816a2250d319d94b675bc82065a88bf3a7bdf4783dce41165818018dd9b3")
                .when()
                .get("/employees");
                response.then().statusCode(200);
                response.prettyPrint();
    }

    @Test
    public void getSingleEmployee(){

       Response response = given()
                .pathParam("id",1)
                .when()
                .get("/employee" + "/{id}");
                response.then().statusCode(200);
                response.prettyPrint();
    }

}
