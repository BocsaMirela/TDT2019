package ElefantTestWebSite.features.search.functionTourTests;

import ElefantTestWebSite.steps.serenity.TabMenuSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class TabMenuFunctionTourTests {

    private static final String WHILE_COLOR = "rgba(255, 255, 255, 1)";
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public TabMenuSteps tabMenuSteps;

    @Test
    public void observeUiWhenTabInvalid() {
        tabMenuSteps.clickBetweenTabs();
        tabMenuSteps.clickBetweenTabsAsert();
    }

    @Test
    public void clickTabMenuAndItemValid() {
        tabMenuSteps.clickMenuStepsParfum("true", WHILE_COLOR);
        tabMenuSteps.clickTabMenuItemStepsParfum("Cosmetice si Parfumuri > Apa de parfum", "Apa de parfum");
    }
} 