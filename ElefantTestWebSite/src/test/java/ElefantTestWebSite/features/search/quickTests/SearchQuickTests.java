package ElefantTestWebSite.features.search.quickTests;

import ElefantTestWebSite.steps.serenity.SearchSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchQuickTests {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public SearchSteps searchSteps;

    @Issue("#WIKI-1")
    @Test
    public void searchingByEmptyString() {
        searchSteps.isTheHomePage();
        searchSteps.looks_for("");
        searchSteps.shouldBeMainPage("Și ce mai citim?","îmbogățește-ți colecția");

    }

    @Test
    public void searchingByHugeString() {
        searchSteps.isTheHomePage();
        searchSteps.looks_for("aaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        searchSteps.shouldSeeNoSearchContent("Ups","Nici un produs gasit.");

    }

} 