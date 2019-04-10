package ElefantTestWebSite.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends PageObject {

    public List<String> getSearchContent() {
        List<WebElementFacade> definitionList = this.findAll(By.cssSelector("div[class='col-sm-12 elf-title']"));
        return definitionList.stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }

    public String getTitle() {
        WebElementFacade definitionList = find(By.tagName("h1"));
        return definitionList.getText();
    }

    public String getAddTitle() {
        WebElementFacade definitionList = find(By.className("title"));
        return definitionList.getText();
    }

    public String getAddSubtitle() {
        WebElementFacade definitionList = find(By.className("subtitle"));
        return definitionList.getText();
    }

    public String getSearchNoContentMessage() {
        WebElementFacade definitionList = find(By.tagName("h2"));
        return definitionList.getText();
    }
}