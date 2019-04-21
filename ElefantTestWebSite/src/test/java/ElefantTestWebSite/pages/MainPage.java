package ElefantTestWebSite.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

@DefaultUrl("http://www.elefant.ro/")
public class MainPage extends PageObject {

    @FindBy(name = "query")
    private WebElementFacade searchInput;

    @FindBy(id = "searchsubmit")
    private WebElementFacade searchButton;

    @FindBy(xpath = "//*[@id=\"navbar-collapse-grid\"]/ul/li[1]/a")
    private WebElementFacade tabMenuParfum;

    @FindBy(css = "#navbar-1 > li:nth-child(4) > a")
    private WebElementFacade tabMenuItemApaDeParfum;

    @FindBy(css = "body > div.container > header > div:nth-child(1) > div.no-gutter-left-xs.col-xs-4.col-sm-offset-4.col-sm-5.col-md-offset-0.col-md-3.col-md-push-6 > div.header-shopping-cart.header-loaded > div.header-cart-icon")
    private WebElementFacade cartButton;

    public void enterSearchInput(String keyword) {
        element(searchInput).waitUntilVisible();
        searchInput.type(keyword);
    }

    public void searchButtonClick() {
        element(searchButton).waitUntilVisible();
        searchButton.click();
    }

    public void tabMenuParfumClick() {
        element(tabMenuParfum).waitUntilVisible();
        tabMenuParfum.click();
    }

    public void tabMenuItemApaDeParfumClick() {
        element(tabMenuItemApaDeParfum).waitUntilVisible();
        tabMenuItemApaDeParfum.click();
    }

    public void cartButtonClick() {
        element(cartButton).waitUntilVisible();
        cartButton.click();
    }

    public String getExpendedTabMenuValue() {
        WebElementFacade webElement = find(By.xpath("//*[@id=\"navbar-collapse-grid\"]/ul/li[1]/a"));
        return webElement.getAttribute("aria-expanded");
    }

    public String getExpendedTabMenuColor() {
        WebElementFacade webElement = find(By.xpath("//*[@id=\"navbar-collapse-grid\"]/ul/li[1]/a"));
        return webElement.getCssValue("background-color");
    }

    public String getCartNumberValue() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(400,0)");
        WebElementFacade webElement = find(By.id("cart_count"));
        return webElement.getText();
    }
}