package demo.features.login;

import demo.steps.serenity.LoginUserSteps;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/features/search/LoginDataValid.csv")
public class LoginValidTest {
    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    public LoginUserSteps loginSteps;
    String username, password, description;

    @Test
    public void log_in_tests_for_valid_credentials(){
        loginSteps.is_the_home_page();
        loginSteps.logs_in(username, password);
        loginSteps.should_see_product_description(description);
    }
}
