import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.util.List;

public class YourCartPage {

    private BaseFunc baseFunc;
    private final By DRESS_PRICE = By.xpath("//td/span[contains(@id, 'total_product_price')]");
    private final By SUM_IN_CART = By.xpath("//tr[@class='cart_total_price']/td[@class='price']/span");
    private final By SHOPPING_CART_CHECK = By.xpath("//div/div/h1[contains(text(), 'Shopping-cart summary')]");

    private String getTextFromCart;
    private String allDressPrice;
    private String withoutDollorAllDressesPrice;

    double delivery = 2.00;
    double sumSimple;
    double integerDressesPrice;


    private String addDollarSimbolAndSum;

    private static DecimalFormat threeNumber = new DecimalFormat("0.00");
    private static DecimalFormat fourNumber = new DecimalFormat("0,000.00");

    public YourCartPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        Assertions.assertFalse(baseFunc.isElementPresent(SHOPPING_CART_CHECK));

    }


    public void checkAllDresses() {
        List<WebElement> allDressesInCart = baseFunc.getAllElements(DRESS_PRICE);
        for (int i = 0; i < allDressesInCart.size(); i++) {
            allDressPrice = allDressesInCart.get(i).getText();
            withoutDollorAllDressesPrice = allDressPrice.replace("$", "").replace(",", "");
            integerDressesPrice = Double.parseDouble(withoutDollorAllDressesPrice);
            sumSimple += integerDressesPrice;
        }
        System.out.println(sumSimple);
    }


    public void dressPricePlusDelivery() {
        if (sumSimple < 1000) {
            addDollarSimbolAndSum = "$" + (threeNumber.format(sumSimple + delivery));
        } else if (sumSimple >= 1000) {
            addDollarSimbolAndSum = "$" + (fourNumber.format(sumSimple + delivery));
        }
    }

    public void compareCostOfDresses() {
        getTextFromCart = baseFunc.getElement(SUM_IN_CART).getText();
        Assertions.assertEquals(addDollarSimbolAndSum, getTextFromCart);
    }


}

