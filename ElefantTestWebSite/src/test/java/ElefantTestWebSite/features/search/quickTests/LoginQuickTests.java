package ElefantTestWebSite.features.search.quickTests;

import ElefantTestWebSite.steps.serenity.LoginSteps;
import ElefantTestWebSite.steps.serenity.SearchSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginQuickTests {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public LoginSteps loginSteps;

    @Test
    public void searchingByEmptyString() {
        loginSteps.isLoginPage();
        loginSteps.loginSteps("bocsa_mirela@yahoo.com","");
        loginSteps.shouldPasswordBeRead();
    }

    @Test
    public void searchingByInvalidEmail() {
        loginSteps.isLoginPage();
        loginSteps.loginSteps("bocsa_mi","secret");
        loginSteps.shouldEmailBeRead();
    }

    @Test
    public void searchingByInvalidAccount() {
        loginSteps.isLoginPage();
        loginSteps.loginSteps("bocsa_mirela@yahoo.com","secret");
        loginSteps.shouldShowInvalidEmailOrPass("Email-ul si/sau parola introduse sunt gresite.");
    }

} 