package com.studentapp.loggingrequestresponse;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/* By Jitendra Patel */

public class LoggingRequestDetails extends TestBase {

    /**
     * This test will print out all the request headers
     */
    @Test
    public void test001() {
        System.out.println("---------------Printing Request Headers------------------");
        given()
                .log()
                .headers()
                .when()
                .get("/1")
                .then()
                .statusCode(200);
    }

    /**
     * This test will print out all the request Parameters
     */
    @Test
    public void test002() {
        System.out.println("---------------Printing Request Parameters------------------");
        given()
                .param("programme", "Computer Science")
                .param("limit", 2)
                .log()
                .parameters()
                .when()
                .get("/list")
                .then()
                .statusCode(200);

    }

    /**
     * This test will print out the Request body
     */
    @Test
    public void test003() {
        System.out.println("---------------Printing Request Body------------------");

        List<String> course = new ArrayList<>();
        course.add("Selenium");
        course.add("Java");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Jitu");
        studentPojo.setLastName("Patel");
        studentPojo.setProgramme("Automation");
        studentPojo.setEmail("abcd146@gmail.com");
        studentPojo.setCourses(course);

        Response response = given()
                .header("Content-Type", "application/json")
                .log()
                .body()
                .when()
                .body(studentPojo)
                .post();
        response.then().log().all().statusCode(201);
    }

    /**
     * This test will print out All the details
     */
    @Test
    public void test004() {
        System.out.println("---------------Printing All the Request Details------------------");

        List<String> course = new ArrayList<>();
        course.add("Selenium");
        course.add("Java");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Jitu");
        studentPojo.setLastName("Patel");
        studentPojo.setProgramme("Automation");
        studentPojo.setEmail("abuh1234@gmail.com");
        studentPojo.setCourses(course);

        Response response = given()
                .header("Content-Type", "application/json")
                .log()
                .all()
                .when()
                .body(studentPojo)
                .post();
        response.then().log().all().statusCode(201);

    }

    /**
     * This test will print Request details if validation fails
     */
    @Test
    public void test005() {
        System.out.println("---------------Printing All the Request Details if validation fails------------------");

        List<String> course = new ArrayList<>();
        course.add("Selenium");
        course.add("Java");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Jitu");
        studentPojo.setLastName("Patel");
        studentPojo.setProgramme("Automation");
        studentPojo.setEmail("akud1234@gmail.com");
        studentPojo.setCourses(course);

        Response response = given()
                .log()
                .ifValidationFails()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().log().all().statusCode(201);

    }
}
