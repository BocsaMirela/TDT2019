package ElefantTestWebSite.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

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
//        element(tabMenuItemApaDeParfum).waitUntilVisible();
        tabMenuItemApaDeParfum.click();
    }

    public String getExpendedTabMenuValue() {
        WebElementFacade webElement = find(By.xpath("//*[@id=\"navbar-collapse-grid\"]/ul/li[1]/a"));
        return webElement.getAttribute("aria-expanded");
    }

    public String getExpendedTabMenuColor() {
        WebElementFacade webElement = find(By.xpath("//*[@id=\"navbar-collapse-grid\"]/ul/li[1]/a"));
        return webElement.getCssValue("background-color");
    }
}