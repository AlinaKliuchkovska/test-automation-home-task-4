package intertoptests;

import intertoppages.HomePage;
import intertoppages.ProductPage;
import intertoppages.SearchSneakersPage;
import intertoppages.WishlistPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import utils.CapabilityFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected static ThreadLocal<RemoteWebDriver> driverTreadLocal = new ThreadLocal<>();
    private CapabilityFactory capabilityFactory = new CapabilityFactory();

    private static final String INTERTOP_URL = "https://intertop.ua/";
    private static final String REMOTE_WEB_DRIVER_URL = "http://192.168.1.22:4444/wd/hub";

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        driverTreadLocal.set(new RemoteWebDriver(new URL(REMOTE_WEB_DRIVER_URL), capabilityFactory.getCapabilities(browser)));
        getDriver().manage().window().maximize();
        getDriver().get(INTERTOP_URL);
    }

    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }

    @AfterClass
    void terminate() {
        driverTreadLocal.remove();
    }

    public WebDriver getDriver() {
        return driverTreadLocal.get();
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public ProductPage getProductPage() {
        return new ProductPage(getDriver());
    }

    public SearchSneakersPage getSearchSneakersPage() {
        return new SearchSneakersPage(getDriver());
    }

    public WishlistPage getWishlistPage() {
        return new WishlistPage(getDriver());
    }
}