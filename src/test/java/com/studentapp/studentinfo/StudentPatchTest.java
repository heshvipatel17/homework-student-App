package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/* By Jitendra Patel */

public class StudentPatchTest extends TestBase {

    @Test
    public void updateStudentEmailUsingEmailId() {

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail("jitupatel@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .log()
                .body()
                .when()
                .body(studentPojo)
                .patch("/1");
        response.then().statusCode(200);

    }
}

