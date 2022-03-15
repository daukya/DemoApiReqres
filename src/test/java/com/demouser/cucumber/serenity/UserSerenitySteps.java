package com.demouser.cucumber.serenity;

import com.model.UserClass;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;


public class UserSerenitySteps {

    @Step
    public ValidatableResponse theAdminCanCreateNewUserWithAnd(String name, String job) {
        UserClass userClass = new UserClass();
        userClass.setName(name);
        userClass.setJob(job);
        return SerenityRest.rest()
                .given()
                .when()
                .body(userClass)
                .post("/users")
                .then();
    }

}
