package ElefantTestWebSite.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class ElementPage extends PageObject {

    @FindBy(id = "add-to-cart")
    private WebElementFacade addToCartButton;

    public void addToCartButtonClick(){
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,400)");
        addToCartButton.click();
    }

    public String getElementImageURL() {
        WebElementFacade webElement = find(By.cssSelector("#main_comanda > div:nth-child(2) > div > div > div.checkout-image > a"));
        return webElement.getAttribute("href");
    }

    public String getElementBrand() {
        WebElementFacade webElement = find(By.cssSelector("#main_comanda > div:nth-child(2) > div > div > div.checkout-product > div.checkout-product-brand"));
        return webElement.getText();
    }

    public String getElementTitle() {
        WebElementFacade webElement = find(By.cssSelector("#main_comanda > div:nth-child(2) > div > div > div.checkout-product > div.checkout-product-title > a"));
        return webElement.getText();
    }

    public String getElementMoneyType() {
        WebElementFacade webElement = find(By.cssSelector("#main_comanda > div:nth-child(2) > div > div > div.checkout-price > div.product-price-after > span.product-price-cur"));
        return webElement.getText();
    }
}