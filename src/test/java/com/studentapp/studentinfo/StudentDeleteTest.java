package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/* By Jitendra Patel */

public class StudentDeleteTest extends TestBase {

    @Test
    public void deleteStudentStudentRecordById() {
        given()
                .log()
                .body()
                .when()
                .delete("/1")
                .then().statusCode(204).log().all();

    }
}
