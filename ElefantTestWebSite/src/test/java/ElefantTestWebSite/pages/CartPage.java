package ElefantTestWebSite.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("http://www.elefant.ro/comanda")
public class CartPage extends PageObject {

    public String getAddTitle() {
        WebElementFacade definitionList = find(By.className("title"));
        return definitionList.getText();
    }

    public String getAddSubtitle() {
        WebElementFacade definitionList = find(By.className("subtitle"));
        return definitionList.getText();
    }
}