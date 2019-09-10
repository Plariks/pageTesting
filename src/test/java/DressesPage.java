import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DressesPage {
    private BaseFunc baseFunc;
    private final By ALL_EXISTING_COLORS_ON_PAGE = By.xpath("//a[@class = 'color_pick']");
    private final By ONE_OF_THE_DRESSES_NAME = By.xpath("//div[@class='right-block']/h5/a");
    private final By FILTER_EXISTED_ON_PAGE = By.xpath("//ul/li/label[@class='layered_color']/a");
    private final By DRESS_LOGO_CHECK = By.xpath("//div/div[@class='cat_desc']/span[contains(text(), 'Dresses')]");
    private final By DRESS_PAGE_CHOOSED_CHECK = By.xpath("//div/div/h2[contains(text(), 'Dresses')]");
    private String orangeCode = "background: rgb(243, 156, 17);";
    private String blueCode = "background: rgb(93, 156, 236);";
    private String blackCode = "background: rgb(67, 74, 84);";
    private String yellowCode = "background: rgb(241, 196, 15);";
    private String pinkCode = "background: rgb(252, 202, 205);";
    private String beigeCode = "background: rgb(119, 119, 119);";
    private String greenCode = "background: rgb(160, 212, 104);";
    private String whiteCode = "background: rgb(255, 255, 255);";


    private String orangeTrue;


    public DressesPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        Assertions.assertFalse(baseFunc.isElementPresent(DRESS_LOGO_CHECK));
        Assertions.assertFalse(baseFunc.isElementPresent(DRESS_PAGE_CHOOSED_CHECK));
    }


    public void checkAllColorsExistingOnPage(String colorCodes) {
        if (colorCodes == "Orange") {
            colorCodes = orangeCode;
        } else if (colorCodes == "Blue") {
            colorCodes = blueCode;
        } else if (colorCodes == "Black") {
            colorCodes = blackCode;
        } else if (colorCodes == "Yellow") {
            colorCodes = yellowCode;
        } else if (colorCodes == "Pink") {
            colorCodes = pinkCode;
        } else if (colorCodes == "Beige") {
            colorCodes = beigeCode;
        } else if (colorCodes == "Green") {
            colorCodes = greenCode;
        } else if (colorCodes == "White") {
            colorCodes = whiteCode;
        }
        for (int j = 0; j < getFilteredItems(ALL_EXISTING_COLORS_ON_PAGE).size(); j++) {
            orangeTrue = getFilteredItems(ALL_EXISTING_COLORS_ON_PAGE).get(j).getAttribute("style");
//            Assertions.assertTrue(orangeTrue.contains(colorCodes));
        }
    }

    public void clickingOnChoosedDress(String selectedDressName) {
        for (int i = 0; i < getFilteredItems(ONE_OF_THE_DRESSES_NAME).size(); i++) {
            if (getFilteredItems(ONE_OF_THE_DRESSES_NAME).get(i).getText().equals(selectedDressName)) {
                getFilteredItems(ONE_OF_THE_DRESSES_NAME).get(i).click();
            } else continue;
            break;
        }
    }


    public void chooseTheColorToFilter(String filteredColorName) {
        for (int i = 0; i < getFilteredItems(FILTER_EXISTED_ON_PAGE).size(); i++) {
            if (getFilteredItems(FILTER_EXISTED_ON_PAGE).get(i).getText().contains(filteredColorName)) {
                getFilteredItems(FILTER_EXISTED_ON_PAGE).get(i).click();
            } else continue;
            break;
        }
    }

    public List<WebElement> getFilteredItems(By locator) {
        return baseFunc.getAllElements(locator);
    }
}


