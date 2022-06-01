package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class employeeDeleteTest extends TestBase {

    @Test
    public void deleteEmployee(){
       Response response =  given()
                .header("Authorization","Bearer ba41816a2250d319d94b675bc82065a88bf3a7bdf4783dce41165818018dd9b3")
                .pathParam("id",2)
                .when()
                .delete("/delete"+"/{id}");
                response.then().statusCode(200);
                response.prettyPrint();
    }
}
