package com.studentapp.loggingrequestresponse;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/* By Jitendra Patel */

public class LoggingResponseDetails extends TestBase {


    /**
     * This test will print out all the Response Headers
     */
    @Test
    public void test001() {
        System.out.println("---------------Printing Response Headers------------------");

        given()
                .header("Content-Type", "application/json")
                .when()
                .get("/1")
                .then().log().headers()
                .statusCode(200);
    }


    /**
     * This test will print the Response Status Line
     */
    @Test
    public void test002() {
        System.out.println("---------------Printing Response Status Line------------------");

        given()
                .header("Content-Type", "application/json")
                .when()
                .get("/1")
                .then().log().status()
                .statusCode(200);
    }

    /**
     * This test will print the Response Body
     */
    @Test
    public void test003() {
        System.out.println("---------------Printing Response Body------------------");

        given()
                .header("Content-Type", "application/json")
                .when()
                .get("/1")
                .then().log().body()
                .statusCode(200);
    }

    /**
     * This test will print the Response in case of an error
     */
    @Test
    public void test004() {
        System.out.println("---------------Printing Response Body in case of an error------------------");

        given()
                .header("Content-Type", "application/json")
                .when()
                .get("/150")
                .then().log().ifError()
                .statusCode(404);

    }

    @Test
    public void test005() {
        System.out.println("---------------Printing All the Request Details------------------");

        given()
                .header("Content-Type", "application/json")
                .when()
                .get("/150")
                .then().log().all()
                .statusCode(404);

    }

    /**
     * This test will print Request details if validation fails
     */
    @Test
    public void test006() {
        System.out.println("---------------Printing All the Request Details if validation fails------------------");

        given()
                .header("Content-Type", "application/json")
                .when()
                .get("/150")
                .then().log().ifValidationFails()
                .statusCode(200);
    }
}



