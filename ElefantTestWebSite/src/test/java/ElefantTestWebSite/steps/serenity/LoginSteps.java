package ElefantTestWebSite.steps.serenity;

import ElefantTestWebSite.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoginSteps extends ScenarioSteps {

    private static final String RED_BORDER_COLOR = "rgb(169, 68, 66)";

    LoginPage loginPage;

    @Step
    public void navigateTo(String url) {
        getDriver().navigate().to(url);
    }

    @Step
    public void entersEmail(String keyword) {
        loginPage.enterEmailInput(keyword);
    }

    @Step
    public void entersPassword(String keyword) {
        loginPage.enterPAsswordInput(keyword);
    }

    @Step
    public void login() {
        loginPage.loginButtonClick();
    }

    @StepGroup
    public void loginSteps(String email, String password) {
        entersEmail(email);
        entersPassword(password);
        login();
    }

    @Step
    public void isLoginPage() {
        loginPage.open();
    }

    @Step
    public void shouldPasswordBeRead() {
        assertThat(loginPage.getPasswordBorderColor().toLowerCase(), Matchers.containsString(RED_BORDER_COLOR));
    }

    @Step
    public void shouldEmailBeRead() {
        assertThat(loginPage.getEmailBorderColor().toLowerCase(), Matchers.containsString(RED_BORDER_COLOR));
    }

    @Step
    public void shouldShowInvalidEmailOrPass(String errorMessage) {
        shouldEmailBeRead();
        shouldPasswordBeRead();
        assertThat(loginPage.getInvalidAccountMessage().toLowerCase(), Matchers.containsString(errorMessage.toLowerCase()));
    }
}