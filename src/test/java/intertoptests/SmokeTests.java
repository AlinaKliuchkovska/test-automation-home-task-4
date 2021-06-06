package intertoptests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTests extends BaseTest {
    private static final String SEARCH_KEY_WORD = "Кеди";
    private static final int EXPECTED_SIZE_OF_FAVOURITE_PRODUCT_LIST = 1;
    private static final String EXPECTED_COUNT_OF_FAVOURITE_PRODUCTS = "1";
    private static final String EXPECTED_COUNT_OF_PRODUCTS_IN_CART = "1";

    @Test
    public void testAddProductToWishlist() {
        getHomePage().enterKeyWordToSearchInput(SEARCH_KEY_WORD)
                .clickOnSearchButton();
        getSearchSneakersPage().clickOnLikeButton()
                .chooseFavouriteSize()
                .clickOnAddProductToWishlistButton();
        getHomePage().clickOnWishlistButton();
        assertEquals(getWishlistPage().getFavouriteProductsCount(), EXPECTED_COUNT_OF_FAVOURITE_PRODUCTS);
        assertEquals(getWishlistPage().getSizeOfFavouriteProductsList(), EXPECTED_SIZE_OF_FAVOURITE_PRODUCT_LIST);
    }

    @Test
    public void checkThatSearchFindsCorrectProducts() {
        getHomePage().enterKeyWordToSearchInput(SEARCH_KEY_WORD)
                .clickOnSearchButton();
        for (WebElement item : getSearchSneakersPage().getProductsNameList()) {
            assertTrue(getSearchSneakersPage().getProductsNameText(item).contains(SEARCH_KEY_WORD),
                    String.format("Error: Expected \"%s\" contains \"%s\"", getSearchSneakersPage().getProductsNameText(item), SEARCH_KEY_WORD));
        }
    }

    @Test
    public void testAddProductToCart() {
        getHomePage().enterKeyWordToSearchInput(SEARCH_KEY_WORD)
                .clickOnSearchButton();
        getSearchSneakersPage().clickOnProduct();
        getProductPage().chooseSize()
                .clickOnAddToCartButton();
        assertTrue(getProductPage().getArticleNumberFromCart().contains(getProductPage().getArticleNumberFromProductPage()),
                String.format("Error: Expected \"%s\" contains \"%s\"", getProductPage().getArticleNumberFromCart(), getProductPage().getArticleNumberFromProductPage()));
        assertEquals(getProductPage().getCountOfProductsInCart(), EXPECTED_COUNT_OF_PRODUCTS_IN_CART);
    }

    @Test
    public void checkMainComponentsOnProductPage() {
        getHomePage().enterKeyWordToSearchInput(SEARCH_KEY_WORD)
                .clickOnSearchButton();
        getSearchSneakersPage().clickOnProduct();
        assertTrue(getProductPage().isActualProductPriceDisplayed(), "Error: Expected ActualProductPrice to be visible");
        assertTrue(getProductPage().isAddToCartButtonEnabled(), "Error: Expected AddToCartButton to be enabled");
        assertTrue(getProductPage().isProductNameDisplayed(), "Error: Expected ProductName to be visible");
    }
}