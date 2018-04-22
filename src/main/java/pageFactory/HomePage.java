package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    /**
     * 
     * All WebElements are identified by @FindBy annotation
     * 
     */

    WebDriver driver;

    @FindBy(name = "active")

    WebElement profile;

    
    @FindBy(xpath = "//*[contains(text(),'Hi')]")

    WebElement titleTxt;

    
    public HomePage(WebDriver driver) {

        this.driver = driver;

        // This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }


    // Get the title of Login Page

    public String getLoginTitle() {

        return titleTxt.getText();

    }
}
