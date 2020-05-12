package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/* By Jitendra Patel */

public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentsInfo() {
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        System.out.println(response.prettyPrint());
    }

    @Test
    public void searchStudentWithParameterWithLimit() {
        Response response = given()
                .param("programme", "Computer Science")
                .param("limit", 2)
                .when()
                .get("/list");
        response.then().statusCode(200);
    }

    @Test
    public void searchStudentWithParameter() {
        Response response = given()
                .param("programme", "Law")
//                .param("programme", "Disaster Management")
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getStudentById() {
        Response response = given()
                .when()
                .get("/4");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
