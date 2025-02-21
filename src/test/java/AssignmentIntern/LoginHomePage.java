package AssignmentIntern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilites.ExtentReport;



public class LoginHomePage extends BaseClass{
	
	public LoginHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Ensure this is present
    }
	

	@FindBy(id="username") WebElement UserID;
	@FindBy(id="password") WebElement pwd;
    @FindBy(id="log-in")WebElement login;
    @FindBy(xpath="//th[@id='amount']") WebElement amnt;
    @FindBy(xpath = "//td[last()]") List<WebElement> checkValues;
   
	public void userName(String user) {
    	UserID.sendKeys(user);
    }
    public void  passWord(String passwd) {
    	pwd.sendKeys(passwd);
    }
    public void  log() {
    	login.click();
    }
    public void Amount() {
    	amnt.click();
    }
    
    public ArrayList<Double> getAmmountList(){
    	
    	ArrayList<Double> amnlist=new ArrayList<Double>();
    	for(WebElement element:checkValues) {
    		String text=element.getText().replace("USD", "").replace(",", "").replace(" ","").trim();
    		amnlist.add(Double.parseDouble(text));
    	}
		return amnlist;
    	
    }
    public boolean isSorted(ArrayList<Double> original) {
    	ArrayList<Double> sorted=new ArrayList<Double>(original);
    	Collections.sort(sorted);
    	if(original.equals(sorted)) {
    		System.out.println("Amount is Ascending Order");
    		return true;
    	}
    	Collections.reverse(sorted);
    	if(original.equals(sorted)) {
    		System.out.println("Amount is Descending Order");
    		return true;
    	}
    	System.out.println("Amount is not sorted");
		return false;
    	
    }
   
		
}
