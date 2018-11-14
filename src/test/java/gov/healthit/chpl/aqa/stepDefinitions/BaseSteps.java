package gov.healthit.chpl.aqa.stepDefinitions;

import java.io.File;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import gov.healthit.chpl.aqa.pageObjects.BasePage;
/** Base class for step definition files. */
public class BaseSteps {
    private EventFiringWebDriver driver;
    private WebDriverWait wait;
    private String url = System.getProperty("url");
    private String filePath = System.getProperty("filePath");
    protected static final long TIMEOUT = 30;
    protected static final long LONG_TIMEOUT = 120;
    protected static final String CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /** Default constructor. */
    public BaseSteps() {
        super();
        this.driver = Hooks.getDriver();
        this.setWait(new WebDriverWait(this.driver, TIMEOUT));
        if (StringUtils.isEmpty(this.url)) {
            this.setUrl("http://localhost:3000/");
        }
        if (StringUtils.isEmpty(this.filePath)) {
            String tempDirectory = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources";
            this.setFilePath(tempDirectory);
        }
    }
    /**
     * Click CHPL Resources Top Navigation.
     */
    public void iclickCHPLResourcesTopNavigationLink() {
        wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(BasePage.chplResourcesDropdown(driver))).click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(final EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(final String filePath) {
        this.filePath = filePath;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(final WebDriverWait wait) {
        this.wait = wait;
    }
}
