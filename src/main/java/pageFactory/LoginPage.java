package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * POM contains all element and methods to interact with login page
 */
public class LoginPage {

    WebDriver driver;
    
    /*
     * Login Email
     */

    @FindBy(name = "username")
    WebElement userTxt;
    
    /*
     * Login Password
     */

    @FindBy(name = "password")
    WebElement passwordTxt;
    
    /*
     * Login Button
     */

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginBtn;
    
    /**
     * Constructor for LoginPage
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Set user login Id
     * @param strUserName login Id
     */

    public void setUserName(String strUserName) {    
        userTxt.sendKeys(strUserName);
    }

    /**
     * Set user password
     * @param strPassword password
     */
    public void setPassword(String strPassword) {
        passwordTxt.sendKeys(strPassword);
    }

    /**
     * Click login button
     */

    public void clickLogin() {
        loginBtn.click();
    }

    /**
     * Get log in page title
     * @return page title
     */

    public String getLoginTitle() {
        return this.driver.getTitle();
    }


    /**
     * Login to home page
     * @param strUserName
     * @param strPasword
     */
    public void login(String strUserName, String strPasword) {
        this.setUserName(strUserName);
        this.setPassword(strPasword);
        this.clickLogin();
    }
}
