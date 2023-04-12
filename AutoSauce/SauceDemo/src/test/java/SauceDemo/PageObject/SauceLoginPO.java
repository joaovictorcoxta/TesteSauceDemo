package SauceDemo.PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceLoginPO extends BasePO{

@FindBy(id="user-name")
public WebElement inputUsername;

@FindBy(id="password")
public WebElement inputPassword;

@FindBy(id="login-button")
public WebElement buttonLogin;

@FindBy(id="about_sidebar_link")
public WebElement sidebarAbout;

@FindBy(css="#login_button_container > div > form > div.error-message-container.error > h3")
public WebElement mensage_error;

    /**
     * costrutor para criação da pagina a ser automatizada
     * @param driver driver da pagina escolhida,no caso foi a sauce.
     */
    public SauceLoginPO(WebDriver driver) {
        super(driver);
    }

public void action_logar(String username,String senha){
    inputUsername.sendKeys(username+Keys.TAB);
    inputPassword.sendKeys(senha);
    buttonLogin.click();
    
}

public String obterMensagem(){
    return mensage_error.getText();
}


public void clean_login(){
    inputUsername.clear();
    inputPassword.clear();
}

//esse metodo serve para capturar alfo da pagina,no caso vou optar pela url da pagina

    
}
