import org.junit.jupiter.api.Test;

public class DressesTest {

    private final String url = "http://automationpractice.com/";
    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage;
    private WomenPage womenPage;
    private DressesPage dressPage;
    private ChoosedDressPage choosedDressPage;
    private YourCartPage yourCartPage;


    @Test
    public void orangeDressCheck() {
        baseFunc.openPage(url);
        homePage = new HomePage(baseFunc);
        homePage.pressThePageYouNeed("Women");

        womenPage = new WomenPage(baseFunc);
        homePage.pressThePageYouNeed("Dresses");

        dressPage = new DressesPage(baseFunc);
        dressPage.chooseTheColorToFilter("Blue");
        dressPage.checkAllColorsExistingOnPage("Blue");
        dressPage.clickingOnChoosedDress("Printed Dress");
        choosedDressPage = new ChoosedDressPage(baseFunc);
        choosedDressPage.checkDressColor("Orange");
        choosedDressPage.howMuchDressesYouNeed(1000);
        choosedDressPage.pressAddToCart();

        dressPage.clickingOnChoosedDress("Printed Chiffon Dress");
        choosedDressPage.howMuchDressesYouNeed(1000);
        choosedDressPage.pressAddToCart();

        homePage.pressCartButton();

        yourCartPage = new YourCartPage(baseFunc);
        yourCartPage.checkAllDresses();
        yourCartPage.dressPricePlusDelivery();
        yourCartPage.compareCostOfDresses();

//        baseFunc.exitFromTest();

    }
}


