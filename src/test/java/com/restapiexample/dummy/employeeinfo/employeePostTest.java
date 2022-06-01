package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.model.EmployeePojo;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class employeePostTest extends TestBase {

    @Test
    public void createEmployeeData(){
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setName("star");
        employeePojo.setSalary("124545");
        employeePojo.setAge("23");
        employeePojo.setId("15");

        Response response = given()
                .body(employeePojo)
                .when()
                .post("/create");
                response.then().statusCode(200);
                response.prettyPrint();
    }
}
