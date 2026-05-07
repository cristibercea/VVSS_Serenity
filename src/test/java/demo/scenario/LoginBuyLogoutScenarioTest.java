package demo.scenario;

import demo.steps.serenity.LoginUserSteps;
import demo.steps.serenity.ScenarioSteps;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/features/search/ScenarioData.csv")
public class LoginBuyLogoutScenarioTest {
    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    public LoginUserSteps loginSteps;
    @Steps
    public ScenarioSteps scenarioSteps;
    public String username, password, description, product_name, first_name, last_name, zip_code, order_confirmation;

    @Test
    public void log_in_tests_for_valid_credentials(){
        loginSteps.is_the_home_page();
        loginSteps.logs_in(username, password);
        loginSteps.should_see_product_description(description);
        scenarioSteps.should_see_product_name(product_name);
        scenarioSteps.click_on_product_name();
        scenarioSteps.should_see_product_description(description);
        scenarioSteps.add_current_product_to_cart();
        scenarioSteps.should_see_remove_from_cart_button();
        scenarioSteps.back_to_product_inventory();
        scenarioSteps.click_cart_button();
        scenarioSteps.should_see_product_name(product_name);
        scenarioSteps.click_checkout_button();
        scenarioSteps.submit_client_data_in_form(first_name,last_name,zip_code);
        scenarioSteps.should_see_finish_button();
        scenarioSteps.click_finish_button();
        scenarioSteps.should_see_order_confirmation(order_confirmation);
        scenarioSteps.back_to_product_inventory();
        scenarioSteps.enter_side_menu();
        scenarioSteps.click_log_out();
        loginSteps.is_the_home_page();
    }
}
