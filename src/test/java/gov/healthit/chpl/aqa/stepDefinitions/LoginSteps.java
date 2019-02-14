package gov.healthit.chpl.aqa.stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gov.healthit.chpl.aqa.pageObjects.LoginPage;

/**
 * Class LoginSteps definition.
 */
public class LoginSteps extends Base {

    private String roleAdminUsername = System.getProperty("roleAdminUsername");
    private String roleAdminPassword = System.getProperty("roleAdminPassword");
    private String roleOncUsername = System.getProperty("roleOncUsername");
    private String roleOncPassword = System.getProperty("roleOncPassword");
    private String roleAcbUsername = System.getProperty("roleAcbUsername");
    private String roleAcbPassword = System.getProperty("roleAcbPassword");
    /**
     * Constructor creates new driver.
     */
    public LoginSteps() {
        if (StringUtils.isEmpty(roleAdminUsername)) {
            throw new IllegalArgumentException("Missing value for roleAdminUsername!");
        }
        if (StringUtils.isEmpty(roleAdminPassword)) {
            throw new IllegalArgumentException("Missing value for roleAdminPassword!");
        }
        if (StringUtils.isEmpty(roleOncUsername)) {
            throw new IllegalArgumentException("Missing value for roleOncUsername!");
        }
        if (StringUtils.isEmpty(roleOncPassword)) {
            throw new IllegalArgumentException("Missing value for roleOncPassword!");
        }
        if (StringUtils.isEmpty(roleAcbUsername)) {
            throw new IllegalArgumentException("Missing value for roleAcbUsername!");
        }
        if (StringUtils.isEmpty(roleAcbPassword)) {
            throw new IllegalArgumentException("Missing value for roleAcbPassword!");
        }
    }

    /**
     * Verify login attempt was successful.
     * @param name as AQA Admin, AQA ONC or AQA ACB
     */
    @Then("^I should be logged in to CHPL as \"([^\"]*)\"$")
    public void verifyLoginWasSuccessful(final String name) {
        String actualString = LoginPage.welcomeText(getDriver()).getText();
        assertTrue(actualString.contains(name));
    }

    /**
     * Log the user in as given ROLE.
     * @param role as ROLE_ADMIN, ROLE_ONC or ROLE_ACB
     */
    @Given("^I'm logged in as \"([^\"]*)\"$")
    public void logInAsRole(final String role) {
        String username = null;
        String password = null;
        if (role.equalsIgnoreCase("ROLE_ADMIN")) {
            username = roleAdminUsername;
            password = roleAdminPassword;
        } else if (role.equalsIgnoreCase("ROLE_ONC")) {
            username = roleOncUsername;
            password = roleOncPassword;
        } else if (role.equalsIgnoreCase("ROLE_ACB")) {
            username = roleAcbUsername;
            password = roleAcbPassword;
        } else {
            throw new IllegalArgumentException("Incorrect role found: " + role);
            }
        getDriver().get(getUrl() + "#/admin/dpManagement");
        WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(LoginPage.username(getDriver())));
        LoginPage.username(getDriver()).sendKeys(username);
        LoginPage.password(getDriver()).sendKeys(password);
        LoginPage.loginButton(getDriver()).click();
        getWait().until(ExpectedConditions.visibilityOf(LoginPage.welcomeText(getDriver())));
    }
}

