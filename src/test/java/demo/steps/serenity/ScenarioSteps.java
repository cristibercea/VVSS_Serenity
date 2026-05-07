package demo.steps.serenity;

import demo.pages.MainPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class ScenarioSteps {
    MainPage mainPage;

    @Step
    public void should_see_product_description(String description) {
        assertEquals(mainPage.getProductDescription(), description);
    }

    @Step
    public void click_on_product_name(){
        mainPage.enter_product_description_page();
    }

    @Step
    public void add_current_product_to_cart(){
        mainPage.click_add_to_cart_button();
    }

    @Step
    public void back_to_product_inventory(){
        mainPage.return_to_product_inventory_page();
    }

    @Step
    public void should_see_product_name(String productName) {
        assertEquals(mainPage.getProductName(), productName);
    }

    @Step
    public void should_see_remove_from_cart_button() {
        assertTrue(mainPage.removeFromCartButtonIsVisible());
        assertTrue(mainPage.addToCartButtonNotVisible());
    }

    @Step
    public void click_cart_button() {mainPage.click_on_cart_button_div();}

    @Step
    public void click_checkout_button() {mainPage.click_on_checkout_button();}

    @Step
    public void submit_client_data_in_form(String firstName, String lastName, String zipCode) {
        mainPage.enter_client_details_in_form(firstName,lastName,zipCode);
        should_see_continue_button();
        click_continue_button();
    }

    @Step
    private void should_see_continue_button() {assertTrue(mainPage.submit_button_is_clickable());}

    @Step
    public void click_continue_button() {mainPage.click_on_submit_button();}

    @Step
    public void should_see_finish_button() {assertTrue(mainPage.finish_button_is_clickable());}

    @Step
    public void click_finish_button() {mainPage.click_on_finish_button();}

    @Step
    public void should_see_order_confirmation(String orderConfirmation) {
        assertEquals(mainPage.get_order_confirmation_message(),orderConfirmation);
    }

    @Step
    public void enter_side_menu() {mainPage.click_on_side_menu_button();}

    @Step
    public void click_log_out() {mainPage.click_on_logout_option();}
}
