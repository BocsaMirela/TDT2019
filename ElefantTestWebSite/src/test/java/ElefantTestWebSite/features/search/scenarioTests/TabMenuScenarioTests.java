package ElefantTestWebSite.features.search.scenarioTests;

import ElefantTestWebSite.steps.serenity.AddToCartSteps;
import ElefantTestWebSite.steps.serenity.LoginSteps;
import ElefantTestWebSite.steps.serenity.SearchSteps;
import ElefantTestWebSite.steps.serenity.TabMenuSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class TabMenuScenarioTests {

    public static final String WHILE_COLOR = "rgba(255, 255, 255, 1)";
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public AddToCartSteps addToCartSteps;

    @Steps
    public SearchSteps searchSteps;

    @Steps
    public TabMenuSteps tabMenuSteps;


    @Test
    public void loginScenarioTest() {
        searchSteps.isTheHomePage();
        tabMenuSteps.clickMenuStepsParfum("true",WHILE_COLOR);
        tabMenuSteps.clickTabMenuItemStepsParfum("Cosmetice si Parfumuri > Apa de parfum", "Apa de parfum");
        String url=tabMenuSteps.clickFirstElementParfum();
        addToCartSteps.openElementPageFromUrl(url);
        addToCartSteps.addToCartButtonClick();

        searchSteps.isTheHomePage();
        tabMenuSteps.clickMenuStepsCarti("true",WHILE_COLOR);
        tabMenuSteps.clickTabMenuItemStepsCarti("Carti > Fictiune", "c");

        url=tabMenuSteps.clickFirstElementCarti();
        addToCartSteps.openElementPageFromUrl(url);
        addToCartSteps.addToCartButtonClick();
        addToCartSteps.cartNumberValueShouldBe("2");
    }
} 