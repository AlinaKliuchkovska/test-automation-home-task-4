package intertoppages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    public static final long TIME_TO_WAIT = 30;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIME_TO_WAIT);
        PageFactory.initElements(driver, this);
    }

    public void waitForVisibilityOfElement(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}