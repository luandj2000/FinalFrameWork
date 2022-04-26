package frameWorkClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	//Declare Webdriver
	public static WebDriver driver;
	
	//constructor
	public BasePage() {
		if (driver == null) {
			//Get Parameter values
			
			//String browser = getDataConfigPropeties("browser");
			//String URL = getDataConfigPropeties("systemUnderTest");
			//String pdriverDir = getDataConfigPropeties("driverdir");
			// String pdriverDirFireFox = getDataConfirgPropeties("driverdirFirefox");
			// String pdriverDirEdge = getDataConfirgPropeties("driverdirEdge");
//			String browser = "chrome";
//			String URL = "https://www.takealot.com/";
//			String pdriverDir = "C:\\Selenium\\";
			String browser = getDataConfigProperties("browser");
			String URL = getDataConfigProperties("URL");
			String pdriverDir = getDataConfigProperties("pdriverDir");
			
			//check if parameter passed as "chrome"
			if (browser.equalsIgnoreCase("chrome")) {
			//Set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver", pdriverDir + "chromedriver.exe");
			//create an instance of chrome
			driver = new ChromeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			else if (browser.equalsIgnoreCase("firefox")) {
				//Set path to geckodriver.exe
				System.setProperty("webdriver.gecko.driver", pdriverDir+"geckodriver.exe");
				//create an instance of firefox
				driver = new FirefoxDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			else if (browser.equalsIgnoreCase("edge")) {
				//Set path to MicrosoftWebDriver.exe
				System.setProperty("webdriver.edge.driver",pdriverDir+"MicrosoftWebDriver.exe");
				//create an instance of edge
				driver = new EdgeDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
	}
}
	//Method to read the config
	public String getDataConfigProperties(String propertyName) {
		// Property set
		//System.out.println("in config")
		Properties p = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream("config.properties");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			p.load(is);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(propertyName);
	}
	//Wait for elements
	public void waitForElement(int elementWait, By pLocator) {
	WebDriverWait wait = new WebDriverWait(driver, elementWait);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pLocator));
	}
	
	//Wait for click
	public void waitforClick(int elementWait, By pLocator) {
	WebDriverWait wait = new WebDriverWait(driver, elementWait);
	wait.until(ExpectedConditions.elementToBeClickable(pLocator));
	}
	
	//Wait for Url
	public void waitForUrl(int elementWait, String urlContainer) {
	WebDriverWait wait = new WebDriverWait(driver, elementWait);
	wait.until(ExpectedConditions.urlContains(urlContainer));
	}
	
	//Get element text
	public String getElementText(By pLocator) {
	String elementText = getElement(pLocator).getText();
	return elementText;
	}

	//Click element
	public void clickElement(By pLocator) {
		waitforClick(30, pLocator);
		getElement(pLocator).click();
		
	}
	
	//Check if element exists
	public boolean elementExists(By pLocator) {
		boolean display = getElement(pLocator).isDisplayed();
		return display;
	}
	
	//Get element
	public WebElement getElement(By pLocator) {
		waitforClick(30, pLocator);
		return driver.findElement(pLocator);
	}
	
	//Clean up
	public void cleanUp() {
		driver.quit();
	}
	
	//Enter text
	public void enterText(By pLocator, String searchText) {
		waitforClick(30, pLocator);
		driver.findElement(pLocator).sendKeys(searchText);
		
	}
	
	//Clear text
	public void clearText(By pLocator) {
		waitforClick(30, pLocator);
		driver.findElement(pLocator).clear();
	}
	
	//Select from drop-down
	public void selectDropDown(By pLocator, String pValue) {
		waitForElement(20,pLocator);
		// Create an instance of the dropdown object
		Select sDropDown = new Select(getElement(pLocator));
		// Populate the DropDown
		sDropDown.selectByVisibleText(pValue);
	}
	
	// Switch window
	public void switchToNewTab() {
		Set<String> handles = driver.getWindowHandles();//selenium will check how many windows are currently open,
														// this will store the ID for both parent and child window
		Iterator<String> it = handles.iterator(); // using the it object you can access the ID
		String parentWindowID = it.next();
		String childWindowID = it.next();
		driver.switchTo().window(childWindowID); // switch to new window by passing the ID of the child window
	}
	
	public void switchToParent() {
		Set<String> handles = driver.getWindowHandles(); //selenium will check how many windows are currently open
														// this will store the ID for both parent and child
		Iterator<String> it = handles.iterator(); //using the it object you can access the ID
		String parentWindowID = it.next();
		String childWindowID = it.next();
		driver.switchTo().window(parentWindowID); // switch to new window by passing the ID of the parent window
	}

	public void closeChildBrowserTab() {
		Set<String> handles = driver.getWindowHandles(); // selenium will check how many windows are currently open,
		Iterator<String> it = handles.iterator();		//  this will store the ID for both parent and child window
		String parentWindowID = it.next();				//  using the it object you can aacess the ID
		String childWindowID = it.next();
		driver.switchTo().window(childWindowID);
		driver.close();
		driver.switchTo().window(parentWindowID);
	}
	public boolean isChildBrowser() {
		Set<String> handles = driver.getWindowHandles();
		int tabNum = handles.size();
		boolean isChildResponse = false;
		if(tabNum >1) {
			isChildResponse = true;
		}
		return isChildResponse;
	}
	

}
