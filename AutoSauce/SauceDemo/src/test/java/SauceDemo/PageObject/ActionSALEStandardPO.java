package SauceDemo.PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActionSALEStandardPO extends BasePO {

    @FindBy(id="user-name")
    public WebElement inputUsername;

    @FindBy(id="password")
    public WebElement inputPassword;

    @FindBy(id="login-button")
    public WebElement buttonLogin;


    @FindBy(id="first-name")
    public WebElement inputFirstName;

    @FindBy(id="last-name")
    public WebElement inputLastName;

    @FindBy(id="postal-code")
    public WebElement inputPostalCode;

    @FindBy(id="checkout")
    public WebElement buttonCheckout;

    @FindBy(css="#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3")
    public WebElement spanErrorComprador;

    




    public ActionSALEStandardPO(WebDriver driver) {
        super(driver);
    }



    public void action_logar(String username,String senha){
        inputUsername.sendKeys(username+Keys.TAB);
        inputPassword.sendKeys(senha);
        buttonLogin.click();
    }
    

    public void CadastraComprador(String name,String lastName,String zipCode){
        inputFirstName.sendKeys(name+Keys.TAB);
        inputLastName.sendKeys(lastName+Keys.TAB);
        inputPostalCode.sendKeys(zipCode);
    }

    public String obterSpan(){
        return spanErrorComprador.getText();
    }


    
}
