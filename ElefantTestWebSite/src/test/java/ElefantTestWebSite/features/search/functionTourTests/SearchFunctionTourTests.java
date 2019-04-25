package ElefantTestWebSite.features.search.functionTourTests;

import ElefantTestWebSite.steps.serenity.SearchSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchFunctionTourTests {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public SearchSteps searchSteps;

    @Issue("#WIKI-1")
    @Test
    public void searchingByEmptyString() {
        searchSteps.isTheHomePage();
        searchSteps.looks_for("");
        searchSteps.shouldBeMainPage("Și ce mai citim?", "îmbogățește-ți colecția");

    }

    @Test
    public void searchingByHugeString() {
        searchSteps.isTheHomePage();
        searchSteps.looks_for("aaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        searchSteps.shouldSeeNoSearchContent("Ups", "Nici un produs gasit.");

    }

    @Test
    public void searchingStringWithLength1() {
        searchSteps.isTheHomePage();
        searchSteps.looks_for("c");
        searchSteps.shouldSeeTitle("Rezultate pentru "+"\"c" );
        searchSteps.shouldSeeSearchContent("c","c","c");
    }

    @Test
    public void searchingStringWithLength2() {
        searchSteps.isTheHomePage();
        searchSteps.looks_for("ab");
        searchSteps.shouldSeeTitle("Rezultate pentru "+"\"ab");
        searchSteps.shouldSeeSearchContent("a","b","");
    }

    @Test
    public void searchingStringWithSpecialCharacters() {
        searchSteps.isTheHomePage();
        searchSteps.looks_for("-a?b*c");
        searchSteps.shouldSeeTitle("Rezultate pentru "+"\"-a?b*c");
        searchSteps.shouldSeeSearchContent("a","b","");
    }
} 