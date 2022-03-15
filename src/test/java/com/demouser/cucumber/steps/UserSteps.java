package com.demouser.cucumber.steps;

import com.demouser.cucumber.serenity.UserSerenitySteps;
import com.demouser.junit.driventdata.UserDriventDataTest;
import com.demouser.testbase.TestBase;
import com.model.UserClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.Matchers.equalTo;


public class UserSteps extends TestBase {


    @Steps
    UserSerenitySteps userSerenitySteps;

    @When("user sen get request to get list user then the response show the list user")
    public void userSenGetRequestToGetListUserThenTheResponseShowTheListUser() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .assertThat()
                .header("Via", "1.1 vegur")
                .body("per_page", equalTo(6));
    }


    @When("The admin can create new user with {string} and {string}")
    public void theAdminCanCreateNewUserWithAnd(String name, String job) {
        userSerenitySteps.theAdminCanCreateNewUserWithAnd(name, job)
                .assertThat()
                .statusCode(201);

    }

    @Then("check if the user is added with {string}")
    public void checkIfTheUserIsAddedWith(String name) {
        SerenityRest.rest()
                .given()
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .assertThat()
                .header("Via", "1.1 vegur")
                .body("name", equalTo(name));

    }

}
