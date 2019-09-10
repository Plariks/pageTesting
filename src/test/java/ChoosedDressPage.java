import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChoosedDressPage {

    private BaseFunc baseFunc;
    private final By CHOOSED_ITEM_COLORS = By.xpath("//ul[@id='color_to_pick_list']/li/a");
    private final By ADD_TO_CART_BUTTON = By.xpath("//button[@name='Submit']");
    private final By INPUT_FIELD = By.xpath("//p/input[@id='quantity_wanted']");
    private final By PRODUCT_INFO_CHECK = By.xpath("//section/h3[contains(text(), 'More info')]");

    WebElement howMuchDressNeeded;

    public ChoosedDressPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        Assertions.assertFalse(baseFunc.isElementPresent(PRODUCT_INFO_CHECK));
    }

    public void checkDressColor(String thisColor) {
        List<WebElement> correctColor = baseFunc.getAllElements(CHOOSED_ITEM_COLORS);
        for (int i = 0; i < correctColor.size(); i++) {
            if (correctColor.get(i).getAttribute("name").equals(thisColor)) {
                System.out.println("This dress has: " + thisColor + " color.");
            }
        }
    }


    public void pressAddToCart() {
        baseFunc.getElement(ADD_TO_CART_BUTTON).click();
        baseFunc.refreshPage();
        baseFunc.backPage();
    }

    //    pozvolajet vibiratj skoljko platjev dobavitj.
    public void howMuchDressesYouNeed(int choosedDressAmount) {
        howMuchDressNeeded = baseFunc.getElement(INPUT_FIELD);
        howMuchDressNeeded.clear();
        howMuchDressNeeded.sendKeys(String.valueOf(choosedDressAmount));
    }
}

