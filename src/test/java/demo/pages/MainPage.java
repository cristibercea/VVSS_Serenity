package demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertNotNull;

public class MainPage extends PageObject {
    @FindBy(id="item_1_title_link")
    private WebElement productLink;
    @FindBy(id="add-to-cart")
    private WebElement addToCartButton;
    @FindBy(id="back-to-products")
    private WebElement backToProductsButton;
    @FindBy(id="shopping_cart_container")
    private WebElement cartButtonDiv;
    @FindBy(id="checkout")
    private WebElement checkoutButton;
    @FindBy(id="first-name")
    private WebElementFacade firstname;
    @FindBy(id="last-name")
    private WebElementFacade lastname;
    @FindBy(id="postal-code")
    private WebElementFacade zipcode;
    @FindBy(id="continue")
    private WebElementFacade continueButton;
    @FindBy(id="finish")
    private WebElementFacade finishButton;
    @FindBy(id="header_container")
    private WebElementFacade headerContainerDiv;
    @FindBy(id="react-burger-menu-btn")
    private WebElementFacade burgerMenuButton;
    @FindBy(id="logout_sidebar_link")
    private WebElementFacade logoutLink;

    public void enter_product_description_page(){productLink.findElement(By.className("inventory_item_name")).click();}

    public void click_add_to_cart_button() {addToCartButton.click();}

    public void return_to_product_inventory_page() {backToProductsButton.click();}

    public String getProductDescription() {
        WebElementFacade inventoryList = find(By.className("inventory_details_desc_container"));
        return inventoryList.findElement(By.className("inventory_details_desc")).getText();
    }

    public String getProductName() {
        WebElement productNameDiv = productLink.findElement(By.className("inventory_item_name"));
        assertNotNull(productNameDiv);
        return productNameDiv.getText();
    }

    public boolean removeFromCartButtonIsVisible() {
        WebElementFacade removeButton = find(By.name("remove"));
        return removeButton.isClickable();
    }

    public boolean addToCartButtonNotVisible() {
        try {
            addToCartButton.click();
            return false;
        } catch (Exception e) {return true;}
    }

    public void click_on_cart_button_div() {cartButtonDiv.click();}

    public void click_on_checkout_button() {checkoutButton.click();}

    public void enter_client_details_in_form(String firstName, String lastName, String zipCode) {
        firstname.type(firstName);
        lastname.type(lastName);
        zipcode.type(zipCode);
    }

    public boolean submit_button_is_clickable() {return continueButton.isClickable();}

    public void click_on_submit_button() {continueButton.submit();}

    public boolean finish_button_is_clickable() {return finishButton.isClickable();}

    public void click_on_finish_button() {finishButton.click();}

    public String get_order_confirmation_message() {return headerContainerDiv.findElement(By.className("title")).getText();}

    public void click_on_side_menu_button() {burgerMenuButton.click();}

    public void click_on_logout_option() {logoutLink.click();}
}
