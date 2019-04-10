package ElefantTestWebSite.steps.serenity;

import ElefantTestWebSite.pages.MainPage;
import ElefantTestWebSite.pages.SearchResultPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class SearchSteps extends ScenarioSteps {

    MainPage mainPage;
    SearchResultPage searchResultPage;

    @Step
    public void navigateTo(String url){
        getDriver().navigate().to(url);
    }
    @Step
    public void openSearchResultPage(String searchString){
        String url="http://www.elefant.ro/search?query="+searchString;
        searchResultPage.openUrl(url);
    }

    @Step
    public void enters(String keyword) {
        mainPage.enterSearchInput(keyword);
    }

    @Step
    public void startsSearch() {
        mainPage.searchButtonClick();
    }

    @Step
    public void shouldSeeTitle(String title) {
        assertThat(searchResultPage.getTitle(), Matchers.containsString(title));
    }

    @Step
    public void shouldSeeSearchContent(String title) {
        assertThat(searchResultPage.getSearchContent(),Matchers.everyItem(Matchers.containsString(title)));
    }

    @Step
    public void shouldSeeNoSearchContent(String title,String subtitle) {
        assertThat(searchResultPage.getTitle().toLowerCase(),Matchers.containsString(title.toLowerCase()));
        assertThat(searchResultPage.getSearchNoContentMessage().toLowerCase(),Matchers.containsString(subtitle.toLowerCase()));
    }
    @Step
    public void shouldBeMainPage(String title, String subtitle) {
        assertThat(searchResultPage.getAddTitle().toLowerCase(), Matchers.containsString(title.toLowerCase()));
        assertThat(searchResultPage.getAddSubtitle().toLowerCase(), Matchers.containsString(subtitle.toLowerCase()));
    }

    @Step
    public void isTheHomePage() {
        mainPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        startsSearch();
        openSearchResultPage(term);
    }
}