package demo.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {
    @FindBy(name="user-name")
    private WebElementFacade username;
    @FindBy(name="password")
    private WebElementFacade password;
    @FindBy(name = "login-button")
    private WebElement loginButton;


    public void enter_credentials(String uname, String pword) {
        username.type(uname);
        password.type(pword);
    }

    public void login() {
        loginButton.submit();
    }

    public List<String> getInventory() {
        WebElementFacade inventoryList = find(By.className("inventory_list"));
        return inventoryList.findElements(By.className("inventory_item_desc")).stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }

    public String getErrorMessage(){
        WebElementFacade inventoryList = find(By.className("error-message-container"));
        return inventoryList.findElement(By.tagName("h3")).getText();
    }
}
