package ElefantTestWebSite.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://www.elefant.ro/")
public class MainPage extends PageObject {

    @FindBy(name = "query")
    private WebElementFacade searchInput;

    @FindBy(id = "searchsubmit")
    private WebElementFacade searchButton;

    public void enterSearchInput(String keyword) {
        element(searchInput).waitUntilVisible();
        searchInput.type(keyword);
    }

    public void searchButtonClick() {
        element(searchButton).waitUntilVisible();
        searchButton.click();
    }
}