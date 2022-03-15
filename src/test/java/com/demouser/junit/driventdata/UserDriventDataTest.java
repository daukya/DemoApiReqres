package com.demouser.junit.driventdata;


import com.demouser.testbase.TestBase;
import com.model.UserClass;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@UseTestDataFrom("testdata/datademo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class UserDriventDataTest extends TestBase {
    private String name;
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    @Test
    public void updateUserDriventData() {
        System.out.println("tuyen"+ getName());
        UserClass userClass = new UserClass();
        userClass.setName(name);
        userClass.setJob(job);
        SerenityRest.rest()
                .given()
                .when()
                .body(userClass)
                .patch("/users/2")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200);

    }
}
