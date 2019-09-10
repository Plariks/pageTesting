import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class WomenPage {
    private BaseFunc baseFunc;
    private final By WOMEN_LOGO_CHECK = By.xpath("//div/div[@class='cat_desc']/span[contains(text(), 'Women')]");
    private final By WOMEN_PAGE_CHOOSED_CHECK = By.xpath("//div/div/h2[contains(text(), 'Women')]");


    public WomenPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        Assertions.assertFalse(baseFunc.isElementPresent(WOMEN_LOGO_CHECK));
        Assertions.assertFalse(baseFunc.isElementPresent(WOMEN_PAGE_CHOOSED_CHECK));


    }
}
