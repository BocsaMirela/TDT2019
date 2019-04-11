package ElefantTestWebSite.features.search.quickTests;

import ElefantTestWebSite.steps.serenity.AddToCartSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CartQuickTests {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public AddToCartSteps addToCartSteps;

    @Test
    public void clickEmptyCart() {
        addToCartSteps.clickCartButtonSteps();
        addToCartSteps.shouldBeMainPage("Și ce mai citim?", "îmbogățește-ți colecția");
        addToCartSteps.cartNumberValueShouldBe("0");
    }

    @Test
    public void addItemToCart() {
        addToCartSteps.addToCartButtonSteps("cosmetice-si-parfumuri/parfumuri/apa-de-parfum/apa-de-parfum-christian-dior-j-adore-iii-ml-pentru-femei-incolor-40321-355.html");
        addToCartSteps.openCartPage();
        addToCartSteps.cartNumberValueShouldBe("1");
        addToCartSteps.pageElementShouldContainElement("christian-dior-j-adore","CHRISTIAN DIOR","Apa de parfum Christian Dior", "lei");

    }

    @Test
    public void addItemToCartAndImediatellyOpenCart() {
        new Thread(()->{
            addToCartSteps.addToCartButtonSteps("cosmetice-si-parfumuri/parfumuri/apa-de-parfum/apa-de-parfum-christian-dior-j-adore-iii-ml-pentru-femei-incolor-40321-355.html");
        }).start();

        new Thread(()->{
            addToCartSteps.openCartPage();
            addToCartSteps.cartNumberValueShouldBe("1");
            addToCartSteps.pageElementShouldContainElement("christian-dior-j-adore","CHRISTIAN DIOR","Apa de parfum Christian Dior", "lei");
        }).start();
    }

} 