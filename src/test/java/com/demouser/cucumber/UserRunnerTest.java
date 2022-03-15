package com.demouser.cucumber;


import com.demouser.testbase.TestBase;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/user.feature", tags = "")
public class UserRunnerTest extends TestBase {

}
