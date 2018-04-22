package scripts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageFactory.HomePage;
import pageFactory.LoginPage;

/**
 * Script tests log in a commerce website
 */
public class LogIn {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    private static final String LOGIN = "Login";
    private static final String CHECK_LOGIN = "Checking if login page is loading";

    /**
     * 
     * This test case will login in https://www.phptravels.net/login
     * Verify login page title 
     * Login to application
     * Verify the home page using welcome message
     */

    @Test
    public void loginWithValidCredential() {

        // Load login page
        System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.phptravels.net/login");
        loginPage = new LoginPage(driver);
        boolean isLoad = loginPage.getLoginTitle().contains(LOGIN);
        Assert.assertTrue(isLoad, CHECK_LOGIN);
        Reporter.log(CHECK_LOGIN,isLoad);
        
        // Login to application
        loginPage.login("user@phptravels.com", "demouser");
        homePage = new HomePage(driver);
        boolean isLogged = homePage.getLoginTitle().contains("Hi");
        Assert.assertTrue(isLogged, "Checking if it is a successful logged in");  
        Reporter.log("Login with valid credential test",isLogged);
        
        // Close browser
        driver.quit();
    }
    
    /**
     * 
     * This test case will login in https://www.phptravels.net/login
     * Verify login page title 
     * Login to application
     * Verify the home page using welcome message
     */

    @Test
    public void loginWithInvalidCredential() {

        // Load login page
        System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.phptravels.net/login");
        loginPage = new LoginPage(this.driver);
        boolean isLoad =loginPage.getLoginTitle().contains(LOGIN);
        Assert.assertTrue(isLoad, CHECK_LOGIN);
        Reporter.log(CHECK_LOGIN,isLoad);
        
        // Login to application with invalid credentals
        loginPage.login("user2@phptravels.com", "demouser2"); 
        Assert.assertTrue(isLoad, "Checking if it is a failed to login");  
        Reporter.log("Login with invalid credential test",isLoad);
        driver.quit();
    }
}
