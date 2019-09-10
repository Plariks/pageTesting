import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private BaseFunc baseFunc;
    private final By CART_BUTTON = By.xpath("//a[@title='View my shopping cart']/b");
    private final By MAIN_LOGO_CHECK = By.xpath("//img[@class='logo img-responsive']");
    private final By HOME_PAGE_ELEMENT_POPULAR_CHECK = By.xpath("//div/ul/li/a[@class='homefeatured']");
    private final By PRESS_ON_NEEDED_TAB = By.xpath("//div[@class='row']/div/ul/li/a");


    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        Assertions.assertFalse(baseFunc.isElementPresent(MAIN_LOGO_CHECK));
        Assertions.assertFalse(baseFunc.isElementPresent(HOME_PAGE_ELEMENT_POPULAR_CHECK));
    }


    public void pressCartButton() {
        baseFunc.getElement(CART_BUTTON).click();
    }

    public void pressThePageYouNeed(String nextPageName) {
        for (int i = 0; i < getFilteredItems(PRESS_ON_NEEDED_TAB).size(); i++) {
            if (getFilteredItems(PRESS_ON_NEEDED_TAB).get(i).getAttribute("title").equals(nextPageName)) {
                getFilteredItems(PRESS_ON_NEEDED_TAB).get(i).click();
            } else continue;
            break;
        }
    }

    public List<WebElement> getFilteredItems(By locator) {
        return baseFunc.getAllElements(locator);
    }
}

