package demo.steps.serenity;

import demo.pages.LoginPage;
import net.serenitybdd.annotations.Step;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class LoginUserSteps {

    LoginPage loginPage;

    @Step
    public void enters(String username, String password) {
        loginPage.enter_credentials(username, password);
    }

    @Step
    public void login() {
        loginPage.login();
    }

    @Step
    public void should_see_product_description(String description) {
        assertThat(loginPage.getInventory(), hasItem(containsString(description)));
    }
    
    @Step
    public void should_see_error_message(String errorMessage) {
        assertEquals(loginPage.getErrorMessage(), errorMessage);
    }

    
    @Step
    public void is_the_home_page() {
        loginPage.open();
    }

    @Step
    public void logs_in(String username, String password) {
        enters(username, password);
        login();
    }
}