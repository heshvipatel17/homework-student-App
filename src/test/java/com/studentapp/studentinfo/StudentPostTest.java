package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;

/* By Jitendra Patel */

public class StudentPostTest extends TestBase {

    @Test
    public void createStudent() {

        List<String> course = new ArrayList<>();
        course.add("Selenium");
        course.add("Java");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Jitu");
        studentPojo.setLastName("Patel");
        studentPojo.setProgramme("Automation");
        studentPojo.setEmail("abc@gmail.com");
        studentPojo.setCourses(course);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }

}
