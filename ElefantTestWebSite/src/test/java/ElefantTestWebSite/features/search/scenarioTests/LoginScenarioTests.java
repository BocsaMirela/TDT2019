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
public class LoginScenarioTests {

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
        loginSteps.isLoginPage();
        loginSteps.loginSteps("mirela.bocsa@x2mobile.net","123ABC");
        loginSteps.shouldBeLogged("Mirela");

        searchSteps.isTheHomePage();
        searchSteps.looks_for("j adore");
        searchSteps.shouldSeeTitle("Rezultate pentru "+"\"j adore");
        searchSteps.shouldSeeSearchContent("j","adore","");
        String url=searchSteps.clickFirstElement();

        addToCartSteps.openElementPageFromUrl(url);
        addToCartSteps.addToCartButtonClick();
        addToCartSteps.openCartPage();
        addToCartSteps.cartNumberValueShouldBe("1");
        addToCartSteps.pageElementShouldContainElement("christian-dior-j-adore","CHRISTIAN DIOR","Apa de parfum Christian Dior", "lei");

    }

} 