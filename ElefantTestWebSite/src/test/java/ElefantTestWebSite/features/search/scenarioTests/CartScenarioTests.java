package ElefantTestWebSite.features.search.scenarioTests;

import ElefantTestWebSite.steps.serenity.AddToCartSteps;
import ElefantTestWebSite.steps.serenity.SearchSteps;
import ElefantTestWebSite.steps.serenity.TabMenuSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static ElefantTestWebSite.features.search.scenarioTests.TabMenuScenarioTests.WHILE_COLOR;

@RunWith(SerenityRunner.class)
public class CartScenarioTests {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public AddToCartSteps addToCartSteps;

    @Steps
    public SearchSteps searchSteps;

    @Steps
    public TabMenuSteps tabMenuSteps;


    @Test
    public void cartScenarioTest() {
        searchSteps.isTheHomePage();

        tabMenuSteps.clickMenuStepsParfum("true",WHILE_COLOR);
        tabMenuSteps.clickTabMenuItemStepsParfum("Cosmetice si Parfumuri > Apa de parfum", "Apa de parfum");
        String url=tabMenuSteps.clickFirstElementParfum();

        addToCartSteps.openElementPageFromUrl(url);
        addToCartSteps.addToCartButtonClick();
        addToCartSteps.openCartPage();
        addToCartSteps.cartNumberValueShouldBe("1");

    }

} 