package pages.customerpages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class MainCustomerPage {

    public MainCustomerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#theme-navbar-collapse>ul>li>a")
    private List<WebElement> topBarMenu;

    public void selectTopBarModule(String module) {
        for (int i = 0; i < topBarMenu.size() - 1; i++) {
            if (BrowserUtils.getText(topBarMenu.get(i)).equals(module)) {
                topBarMenu.get(i).click();
                break;
            }
        }
    }
}
