package AssignmentIntern;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utilites.ExtentReport;

public class TC001_LoginTestcase{
public static WebDriver driver;

@BeforeClass
public void setup() {
	 driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://sakshingp.github.io/assignment/login.html");
}
@Test
public void CheckingAmountSorted() throws InterruptedException {
	LoginHomePage L=new LoginHomePage(driver);
	L.userName("Admin");
	L.passWord("admin");
	L.log();
	Thread.sleep(3000);
	L.Amount();
	ArrayList<Double> A=L.getAmmountList();
	System.out.println("Extracted Amount is : "  +A);
	
	boolean sorted=L.isSorted(A);
	if(sorted) {
		System.out.println("Sorted is working Correctly");
	}
	else {
		System.out.println("Sorted is not correct working properly");
	}
	ExtentReport.driver=driver;
	
	//driver.quit();
}


	

}
