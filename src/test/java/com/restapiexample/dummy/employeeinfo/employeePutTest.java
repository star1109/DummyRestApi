package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.model.EmployeePojo;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class employeePutTest extends TestBase {

    @Test
    public void updateEmployee(){
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setId("21");
        employeePojo.setEmployee_name("abc");
        employeePojo.setEmployee_salary("50000");
        employeePojo.setEmployee_age("40");
        employeePojo.setProfile_image("");

      Response response = given()
                .pathParam("id",21)
                .body(employeePojo)
                .when()
                .put("/update"+"/{id}");
                response.then().statusCode(200);

                response.prettyPrint();
    }

}
