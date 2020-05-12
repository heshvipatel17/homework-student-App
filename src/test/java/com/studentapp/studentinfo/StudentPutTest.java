package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/* By Jitendra Patel */

public class StudentPutTest extends TestBase {

    @Test
    public void updateStudentEmail() {

        List<String> courses = new ArrayList<>();
        courses.add("Challenging");
        courses.add("Homework");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Jitu1");
        studentPojo.setLastName("Patel1");
        studentPojo.setEmail("abcJitu@gmail.com");
        studentPojo.setProgramme("Accountant");
        studentPojo.setCourses(courses);

        Response response = given()
                .header("Content-Type", "application/json")
                .log()
                .body()
                .when()
                .body(studentPojo)
                .put("/2");

        response.then().statusCode(200);
        response.prettyPrint();

    }
}