package pages.employeepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".menu-text")
    private List<WebElement> leftSideModules;

    @FindBy(xpath = "//ul[@class='nav nav-second-level collapse in']//li")
    private List<WebElement> salesModules;

    public void selectLeftSideModule(String moduleName) {
        for (WebElement module : leftSideModules) {
            if (BrowserUtils.getText(module).equals(moduleName)) {
                module.click();
                break;
            }
        }
    }

    public void selectSalesModule(String moduleName) {
        for (WebElement module : salesModules) {
            if (BrowserUtils.getText(module).equals(moduleName)) {
                module.click();
                break;
            }
        }
    }

    public int getSalesSubModuleNumber() {
        return salesModules.size();
    }

    public boolean verifyOrderOfSalesSubModule(List<String> expectedOrder) {
        List<String> actualOrder = new ArrayList<>();
        for (WebElement module : salesModules) {
            actualOrder.add(module.getText().trim());
        }
        for (int i = 0; i < expectedOrder.size(); i++) {
            if (expectedOrder.get(i).equals(actualOrder.get(i))) {
                return true;
            }
        }
        return false;
    }
}
