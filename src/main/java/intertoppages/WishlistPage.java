package intertoppages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishlistPage extends BasePage {
    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='one-item-wrap']")
    private List<WebElement> favouriteProductsList;

    @FindBy(xpath = "//span[@class='fav-count']")
    private WebElement favouriteProductsCount;

    public int getSizeOfFavouriteProductsList(){
        return favouriteProductsList.size();
    }

    public String getFavouriteProductsCount(){
        return favouriteProductsCount.getText();
    }
}