package wrappers;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchCookieException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnableToSetCookieException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.safari.ConnectionClosedException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utils.Reporting;

public class GenericWrappers extends Reporting implements Wrappers {

	public RemoteWebDriver driver;
	
	public static Properties prop;
	
	public void loadObjects(){
		try {
			prop = new Properties();
			prop.load(new FileInputStream("./src/test/java/Object.properties"));
		} catch(NullPointerException e){
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
	}
	
	public void unloadObjects(){
		prop=null;
	}

	public void invokeApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			//System.out.println("The browser " + browser + " is launched successfully");
			reportStep("The browser " + browser + " is launched successfully", "pass");
		} catch (UnsupportedCommandException e) {
			reportStep("The webdriver has not sent the command properly ", "fail");
			//System.err.println("The webdriver has not sent the command properly ");
		} catch (UnreachableBrowserException e) {
//			System.out.println("The browser" + browser + " is unable to be opened");
			reportStep("The browser" + browser + " is unable to open", "Fail");
		} catch (ConnectionClosedException e) {
			// TODO: handle exception
//			System.err.println("Disconnection occured in the driver");
			reportStep("Disconnection occured in the driver", "Fail");
		} catch (TimeoutException e) {
			// TODO: handle exception
//			System.err.println("There is no response from the application");
			reportStep("Disconnection occured in the driver", "Fail");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
//			System.err.println("The browser " + browser + " is not launched successfully");
			reportStep("The browser " + browser + " is not launched successfully", "Fail");
			
		}
	}

	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(idValue).sendKeys(data);
//			System.out.println("The Element" + idValue + "is found & the data is entered ");
			reportStep("The Element" + idValue + "is found & the data is entered ", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
//			System.err.println("The Element with" + idValue + " is not found in the DOM");
			reportStep("The Element with" + idValue + " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + idValue + " is not visible in the Application ");
			reportStep("The Element with" + idValue + " is not visible in the Application ", "Fail");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + idValue + " is not clickable in the Application ");
			reportStep("The Element with" + idValue + " is not clickable in the Application ", "Fail");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + idValue + " is not intractable in the Application");
			reportStep("The Element with" + idValue + " is not interactable in the Application", "Fail");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + idValue + " is not stable in the Application");
			reportStep("The Element with" + idValue + " is not stable in the Application", "Fail");
		} catch (TimeoutException e) {
			// TODO: handle exception
//			System.err.println("Enough time is not there to perform the action");
			reportStep("Enough time is not there to perform the action", "Fail");
		} catch (WebDriverException e) {
			// TODO: handle exception
//			System.err.println("Unable to pass the data" + idValue + " due to unknown error");
			reportStep("Unable to pass the data" + idValue + " due to unknown error", "Fail");
		} 

	}

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(nameValue).sendKeys(data);
//			System.out.println("The Element" + nameValue + "is found & the data is entered ");
			reportStep("The Element" + nameValue + "is found & the data is entered ", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
//			System.err.println("The Element with" + nameValue + " is not found in the DOM");
			reportStep("The Element with" + nameValue + " is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + nameValue + " is not visible in the Application ");
			reportStep("The Element with" + nameValue + " is not visible in the Application ", "Fail");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + nameValue + " is not clickable in the Application ");
			reportStep("The Element with" + nameValue + " is not clickable in the Application", "Fail");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + nameValue + " is not intractable in the Application");
			reportStep("The Element with" + nameValue + " is not intractable in the Application", "Fail");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception		
//			System.err.println("The Element with" + nameValue + " is not stable in the Application");
			reportStep("The Element with" + nameValue + " is not stable in the Application", "Fail");
		} catch (TimeoutException e) {
			// TODO: handle exception
//			System.err.println("Enough time is not there to perform the action");
			reportStep("Enough time is not there to perform the action", "Fail");
		} catch (WebDriverException e) {
			// TODO: handle exception
//			System.err.println("Unable to pass the data" + nameValue + " due to unknown error");
			reportStep("Unable to pass the data" + nameValue + " due to unknown error", "Fail");
		} 
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
//			System.out.println("The Element" + xpathValue + "is found & the data is entered ");
			reportStep("The Element" + xpathValue + "is entered with data "+data, "pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
//			System.err.println("The Element with" + xpathValue + " is not found in the DOM");
			reportStep("The Element is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + xpathValue + " is not visible in the Application");
			reportStep("The Element with is not visible in the Application ", "Fail");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("The Element with is not intractable in the Application", "Fail");
//			System.err.println("The Element with" + xpathValue + " is not intractable in the Application");
		} catch (StaleElementReferenceException e) {
			// 
			reportStep("The Element with is not stable in the Application", "Fail");
//			System.err.println("The Element with" + xpathValue + " is not stable in the Application");
		} catch (TimeoutException e) {
			// TODO: handle exception
			reportStep("Enough time is not there to perform the action", "Fail");
//			System.err.println("Enough time is not there to perform the action");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unable to pass the data  due to unknown error", "Fail");
//			System.err.println("Unable to pass the data" + data + " due to unknown error");
		}

	}

	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		try {
			String actual = driver.getTitle();
			if (actual.equals(title)) {
				System.out.println("The title" + title + " is matched");
			} else {
				System.err.println("The title" + title + " is not matched");
			}
			reportStep("Title is matching as expected", "Pass");
		} catch (ElementNotVisibleException e) {
			// TODO Auto-generated catch block
//			System.err.println("The Element with" + title + " is not visible in the Application");
			reportStep("The Element with is not visible in the Application ", "Fail");
		} catch (ScriptTimeoutException e2) {
			// TODO: handle exception
			reportStep("The script is taking more time to return the value","Fail");
//			System.err.println("The script is taking more time to return the value");
		} catch (TimeoutException e) {
			// TODO: handle exception
			reportStep("Enough time is not there to perform the action", "Fail");
//			System.err.println("Enough time is not there to perform the action");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unable to pass the data  due to unknown error", "Fail");
//			System.err.println("Unable to pass the data" + data + " due to unknown error");
		
		}

	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			String actual = driver.findElementById(id).getText();
			if (actual.equals(text)) {
				System.out.println("The expected text" + text + " is matched with actual text" +actual);
			} else {
				System.err.println("The text" + text + " is not matched with actual text" +actual);
			}
			reportStep("The text is matched "+text, "Pass");
		} catch (ElementNotVisibleException e) {
			// TODO Auto-generated catch block
//			System.err.println("The Element with" + text + " is not visible in the Application");
			reportStep("The Element with" + text + " is not visible in the Application", "Fail");
		} catch (ScriptTimeoutException e2) {
			// TODO: handle exception
//			System.err.println("The script is taking more time to return the value");
			reportStep("The script is taking more time to return the value", "Fail");
		} catch (TimeoutException e) {
			// TODO: handle exception
//			System.err.println("Enough time is not there to perform the action");
			reportStep("Enough time is not there to perform the action", "Fail");
		} catch (WebDriverException e) {
			// TODO: handle exception
//			System.err.println("Unable to verify title due to unknown error");
			reportStep("Unable to verify title due to unknown error", "Fail");
		} 

	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String actual = driver.findElementByXPath(xpath).getText();
			System.out.println(text);
			if (actual.equals(text)) {
				System.out.println("The expected text" + text + " is matched with actual text  " +actual);
			} else {
				System.err.println("The text" + text + " is not matched with actual text  " +actual);
			}
		} catch (ElementNotVisibleException e) {
			// TODO Auto-generated catch block
			System.err.println("The Element with " + xpath +  "  is not visible in the Application");
			reportStep("The Element with" + text + " is not visible in the Application", "Fail");
		} catch (ScriptTimeoutException e2) {
			// TODO: handle exception
//			System.err.println("The script is taking more time to return the value");
			reportStep("The script is taking more time to return the value", "Fail");
		} catch (TimeoutException e) {
			// TODO: handle exception
//			System.err.println("Enough time is not there to perform the action");
			reportStep("Enough time is not there to perform the action", "Fail");
		} catch (WebDriverException e) {
			// TODO: handle exception
//			System.err.println("Unable to verify title due to unknown error");
			reportStep("Unable to verify title due to unknown error", "Fail");
		} 

	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			WebElement actual = driver.findElementByXPath(xpath);
			String actualtitle = actual.getText();
			System.out.println(actualtitle);
			if (actualtitle.contains(text)) {
				System.out.println("The text" + text + " is matched");
			} else {
				System.err.println("The text" + text + " is not matched");
			}reportStep("Text is verified", "Pass");
		} catch (ElementNotVisibleException e) {
			// TODO Auto-generated catch block
//			System.err.println("The Element with" + xpath + " is not visible in the Application");
			reportStep("The Element with" + xpath + " is not visible in the Application", "Fail");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + xpath + " is not Interactable in the Application");
			reportStep("The Element with" + xpath + " is not Interactable in the Application", "Fail");
		} catch (ScriptTimeoutException e2) {
			// TODO: handle exception
//			System.err.println("The script is taking more time to return the value");
			reportStep("The script is taking more time to return the value", "Fail");
		} catch (InvalidElementStateException e) {
			// TODO: handle exception
//			System.err.println("Unable to verify the text as the element is invalid");
			reportStep("Unable to verify the text as the element is invalid", "Fail");
		} catch (WebDriverException e) {
			// TODO: handle exception
//			System.err.println("Unknown error occured");
			reportStep("Unknown error occured", "Fail");
		} 
	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(id).click();
//			System.out.println("The Element" + id + "is found & the data is entered ");
			reportStep("The Element is found & the data is entered ", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
//			System.err.println("The Element with" + xpathValue + " is not found in the DOM");
			reportStep("The Element is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + xpathValue + " is not visible in the Application");
			reportStep("The Element with is not visible in the Application ", "Fail");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			reportStep("The Element with is not clickable in the Application ", "Fail");
//			System.err.println("The Element with" + id + " is not clickable in the Application ");
		}catch (StaleElementReferenceException e) {
			reportStep("The Element with is not stable in the Application", "Fail");
//			System.err.println("The Element with" + xpathValue + " is not stable in the Application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unable to click the element due to unknown error", "Fail");
//			System.err.println("Unable to click the element due to unknown error");
		} 	}

	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByClassName(classVal).click();
//			System.out.println("The Element" + classVal + "is found & the data is entered ");
			reportStep("The Element is found & the data is entered ", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
//			System.err.println("The Element with" + xpathValue + " is not found in the DOM");
			reportStep("The Element is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + xpathValue + " is not visible in the Application");
			reportStep("The Element with is not visible in the Application ", "Fail");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			reportStep("The Element with is not clickable in the Application ", "Fail");
//			System.err.println("The Element with" + id + " is not clickable in the Application ");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("The Element with is not Interactable in the Application", "Fail");
//			System.err.println("The Element with" + classVal + " is not intractable in the Application");
		} catch (StaleElementReferenceException e) {
			reportStep("The Element with is not stable in the Application", "Fail");
//			System.err.println("The Element with" + xpathValue + " is not stable in the Application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unable to click the element due to unknown error", "Fail");
//			System.err.println("Unable to click the element due to unknown error");
		}
	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(name).click();
			System.out.println("The Element" + name + "is found & the data is entered ");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
//			System.err.println("The Element with" + xpathValue + " is not found in the DOM");
			reportStep("The Element is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + xpathValue + " is not visible in the Application");
			reportStep("The Element with is not visible in the Application ", "Fail");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			reportStep("The Element with is not clickable in the Application ", "Fail");
//			System.err.println("The Element with" + id + " is not clickable in the Application ");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("The Element with is not Interactable in the Application", "Fail");
//			System.err.println("The Element with" + classVal + " is not intractable in the Application");
		} catch (StaleElementReferenceException e) {
			reportStep("The Element with is not stable in the Application", "Fail");
//			System.err.println("The Element with" + xpathValue + " is not stable in the Application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unable to click the element due to unknown error", "Fail");
//			System.err.println("Unable to click the element due to unknown error");
		}}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The Element" + name + "is found & the data is entered ");
			reportStep("The Element is found & the data is entered ", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
//			System.err.println("The Element with" + xpathValue + " is not found in the DOM");
			reportStep("The Element is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + xpathValue + " is not visible in the Application");
			reportStep("The Element with is not visible in the Application ", "Fail");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			reportStep("The Element with is not clickable in the Application ", "Fail");
//			System.err.println("The Element with" + id + " is not clickable in the Application ");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("The Element with is not Interactable in the Application", "Fail");
//			System.err.println("The Element with" + classVal + " is not intractable in the Application");
		} catch (StaleElementReferenceException e) {
			reportStep("The Element with is not stable in the Application", "Fail");
//			System.err.println("The Element with" + xpathValue + " is not stable in the Application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unable to click the element due to unknown error", "Fail");
//			System.err.println("Unable to click the element due to unknown error");
		}
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The Element" + name + "is found & the data is entered ");
			reportStep("The Element is found & the data is entered ", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
//			System.err.println("The Element with" + xpathValue + " is not found in the DOM");
			reportStep("The Element is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + xpathValue + " is not visible in the Application");
			reportStep("The Element with is not visible in the Application ", "Fail");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			reportStep("The Element with is not clickable in the Application ", "Fail");
//			System.err.println("The Element with" + id + " is not clickable in the Application ");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("The Element with is not Interactable in the Application", "Fail");
//			System.err.println("The Element with" + classVal + " is not intractable in the Application");
		} catch (StaleElementReferenceException e) {
			reportStep("The Element with is not stable in the Application", "Fail");
//			System.err.println("The Element with" + xpathValue + " is not stable in the Application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unable to click the element due to unknown error", "Fail");
//			System.err.println("Unable to click the element due to unknown error");
		}
	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
//			System.out.println("The Element" + xpathVal + "is found & the data is entered ");
			reportStep("The Element is found & the data is entered ", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
//			System.err.println("The Element with" + xpathValue + " is not found in the DOM");
			reportStep("The Element is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + xpathValue + " is not visible in the Application");
			reportStep("The Element with is not visible in the Application ", "Fail");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			reportStep("The Element with is not clickable in the Application ", "Fail");
//			System.err.println("The Element with" + id + " is not clickable in the Application ");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("The Element with is not Interactable in the Application", "Fail");
//			System.err.println("The Element with" + classVal + " is not intractable in the Application");
		} catch (StaleElementReferenceException e) {
			reportStep("The Element with is not stable in the Application", "Fail");
//			System.err.println("The Element with" + xpathValue + " is not stable in the Application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unable to click the element due to unknown error", "Fail");
//			System.err.println("Unable to click the element due to unknown error");
		}
	}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
//			System.out.println("The Element" + xpathVal + "is found & the data is entered ");
			reportStep("The Element is found & the data is entered ", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
//			System.err.println("The Element with" + xpathValue + " is not found in the DOM");
			reportStep("The Element is not found in the DOM", "Fail");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + xpathValue + " is not visible in the Application");
			reportStep("The Element with is not visible in the Application ", "Fail");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			reportStep("The Element with is not clickable in the Application ", "Fail");
//			System.err.println("The Element with" + id + " is not clickable in the Application ");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("The Element with is not Interactable in the Application", "Fail");
//			System.err.println("The Element with" + classVal + " is not intractable in the Application");
		} catch (StaleElementReferenceException e) {
			reportStep("The Element with is not stable in the Application", "Fail");
//			System.err.println("The Element with" + xpathValue + " is not stable in the Application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unable to click the element due to unknown error", "Fail");
//			System.err.println("Unable to click the element due to unknown error");
		}
	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		String textvalue = null;
		try {
			WebElement textid = driver.findElementById(idVal);
			textvalue = textid.getText();
//			System.out.println(textvalue);
			reportStep("Get text is successful", "Pass");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + xpathValue + " is not visible in the Application");
			reportStep("The Element with is not visible in the Application ", "Fail");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("The Element with is not Interactable in the Application", "Fail");
//			System.err.println("The Element with" + classVal + " is not intractable in the Application");
		} catch (ScriptTimeoutException e2) {
			// TODO: handle exception
			reportStep("The script is taking more time to return the value", "Fail");
//			System.err.println("The script is taking more time to return the value");
		} catch (InvalidElementStateException e) {
			// TODO: handle exception
			reportStep("The Element is invalid", "Fail");
//			System.err.println("The Element" + idVal + "is invalid");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unable to get the text due to unknown error", "Fail");
//			System.err.println("Unable to get the text due to unknown error");
		} 
		return textvalue;
	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		String textvalue=null;
		try {
			WebElement textxpath = driver.findElementByXPath(xpathVal);
			textvalue = textxpath.getText();
//			System.out.println(textvalue);
			reportStep("Get text is successful", "Pass");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
//			System.err.println("The Element with" + xpathValue + " is not visible in the Application");
			reportStep("The Element with is not visible in the Application ", "Fail");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("The Element with is not Interactable in the Application", "Fail");
//			System.err.println("The Element with" + classVal + " is not intractable in the Application");
		} catch (ScriptTimeoutException e2) {
			// TODO: handle exception
			reportStep("The script is taking more time to return the value", "Fail");
//			System.err.println("The script is taking more time to return the value");
		} catch (InvalidElementStateException e) {
			// TODO: handle exception
			reportStep("The Element is invalid", "Fail");
//			System.err.println("The Element" + idVal + "is invalid");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unable to get the text due to unknown error", "Fail");
//			System.err.println("Unable to get the text due to unknown error");
		} 
		return textvalue;
	}

	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement visibleid = driver.findElementById(id);
			Select byid = new Select(visibleid);
			byid.selectByVisibleText(value);
			reportStep("Text selection is successful", "Pass");
		} catch (ElementClickInterceptedException e) {
//			System.err.println("The Element with" + id + " is not clickable in the Application ");
			reportStep("The Element with is not clickable in the Application ", "Fail");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The Element with is unable to found in the DOM", "Fail");
//			System.err.println("The Element with" + id + " is unable to found in the DOM");
		} catch (NotFoundException e) {
			// TODO: handle exception
			reportStep("The Element with" + id + " doesn't exists in the DOM", "Fail");
//			System.err.println("The Element with" + id + " doesn't exists in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			reportStep("The Element with" + id + " is not visible in the Application", "Fail");
//			System.err.println("The Element with" + id + " is not visible in the Application ");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("The Element with" + id + " is not interactable in the Application", "Fail");
//			System.err.println("The Element with" + id + " is not intractable in the Application");
		} catch (ElementNotSelectableException e) {
			// TODO: handle exception
			reportStep("The Element with" + id + " is not selectable in the Application ", "Fail");
//			System.err.println("The Element with" + id + " is not selectable in the Application ");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			reportStep("The Element with" + id + " is not stable in the Application", "Fail");
//			System.err.println("The Element with" + id + " is not stable in the Application");
		} catch (ConnectionClosedException e) {
			// TODO: handle exception
			reportStep("Driver got disconnected", "Fail");
//			System.err.println("Driver got disconnected");
		} catch (TimeoutException e) {
			// TODO: handle exception
			reportStep("TimeOut exception has occured due to not enough time to complete the command", "Fail");
//			System.err.println("TimeOut exception has occurred due to not enough time to complete the command");
		} catch (ScriptTimeoutException e) {
			// TODO: handle exception
			reportStep("TimeOut exception has occured as it takes more time to perform the operation", "Fail");
//			System.err.println("TimeOut exception has occurred as it takes more time to perform the operation");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unable to select the value due to unknown error", "Fail");
//			System.err.println("Unable to select the value due to unknown error");
		} 	}

	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement indexid = driver.findElementById(id);
			Select byid = new Select(indexid);
			byid.selectByIndex(value);
			reportStep("Text selection is successful", "Pass");
	} catch (ElementClickInterceptedException e) {
//		System.err.println("The Element with" + id + " is not clickable in the Application ");
		reportStep("The Element with is not clickable in the Application ", "Fail");
	} catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		reportStep("The Element with is unable to found in the DOM", "Fail");
//		System.err.println("The Element with" + id + " is unable to found in the DOM");
	} catch (NotFoundException e) {
		// TODO: handle exception
		reportStep("The Element with" + id + " doesn't exists in the DOM", "Fail");
//		System.err.println("The Element with" + id + " doesn't exists in the DOM");
	} catch (ElementNotVisibleException e) {
		// TODO: handle exception
		reportStep("The Element with" + id + " is not visible in the Application", "Fail");
//		System.err.println("The Element with" + id + " is not visible in the Application ");
	} catch (ElementNotInteractableException e) {
		// TODO: handle exception
		reportStep("The Element with" + id + " is not interactable in the Application", "Fail");
//		System.err.println("The Element with" + id + " is not intractable in the Application");
	} catch (ElementNotSelectableException e) {
		// TODO: handle exception
		reportStep("The Element with" + id + " is not selectable in the Application ", "Fail");
//		System.err.println("The Element with" + id + " is not selectable in the Application ");
	} catch (StaleElementReferenceException e) {
		// TODO: handle exception
		reportStep("The Element with" + id + " is not stable in the Application", "Fail");
//		System.err.println("The Element with" + id + " is not stable in the Application");
	} catch (ConnectionClosedException e) {
		// TODO: handle exception
		reportStep("Driver got disconnected", "Fail");
//		System.err.println("Driver got disconnected");
	} catch (TimeoutException e) {
		// TODO: handle exception
		reportStep("TimeOut exception has occured due to not enough time to complete the command", "Fail");
//		System.err.println("TimeOut exception has occurred due to not enough time to complete the command");
	} catch (ScriptTimeoutException e) {
		// TODO: handle exception
		reportStep("TimeOut exception has occured as it takes more time to perform the operation", "Fail");
//		System.err.println("TimeOut exception has occurred as it takes more time to perform the operation");
	} catch (WebDriverException e) {
		// TODO: handle exception
		reportStep("Unable to select the value due to unknown error", "Fail");
//		System.err.println("Unable to select the value due to unknown error");
	} 	
	}

	public void switchToParentWindow() {
		// TODO Auto-generated method stub

		try {
			Set<String> allwin = driver.getWindowHandles();
			for (String curwin : allwin) {
				driver.switchTo().window(curwin);
				break;
			}
//			System.out.println("Browser control is switched to parent window");
			reportStep("Browser control is switched to parent window", "Pass");
		} catch (UnableToSetCookieException e) {
			// TODO Auto-generated catch block
//			System.err.println("Driver is unable to set the cookie for the window");
			reportStep("Driver is unable to set the cookie for the window", "Fail");
		} catch (SessionNotCreatedException e) {
			// TODO: handle exception
//			System.err.println("Session ID is not created for new window");
			reportStep("Session ID is not created for new window", "Fail");
		} catch (NoSuchWindowException e) {
			// TODO: handle exception
//			System.err.println("Target window doesn't exists to switch");
			reportStep("Target window doesn't exists to switch", "Fail");
		} catch (NoSuchCookieException e) {
			// TODO: handle exception
//			System.err.println("Cookie is not matching with the given cookie");
			reportStep("Cookie is not matching with the given cookie", "Fail");
		} catch (ConnectionClosedException e) {
			// TODO: handle exception
			reportStep("Driver got disconnected", "Fail");
//			System.err.println("Driver got disconnected");
		} catch (TimeoutException e) {
			// TODO: handle exception
			reportStep("TimeOut exception has occured due to not enough time to complete the command", "Fail");
//			System.err.println("TimeOut exception has occured due to not enough time to complete the command");
		} catch (ScriptTimeoutException e) {
			// TODO: handle exception
			reportStep("TimeOut exception has occured as it takes more time to perform the operation", "Fail");
//			System.err.println("TimeOut exception has occured as it takes more time to perform the operation");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unknown error occured", "Fail");
//			System.err.println("Unknown error occured");
		} 
	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> allwin = driver.getWindowHandles();
			for (String curwin : allwin) {
				driver.switchTo().window(curwin);
			}
//			System.out.println("Browser control is switched to last open window");
			reportStep("Browser control is switched to last open window", "Pass");
		} catch (UnableToSetCookieException e) {
			// TODO Auto-generated catch block
//			System.err.println("Driver is unable to set the cookie for the window");
			reportStep("Driver is unable to set the cookie for the window", "Fail");
		} catch (SessionNotCreatedException e) {
			// TODO: handle exception
//			System.err.println("Session ID is not created for new window");
			reportStep("Session ID is not created for new window", "Fail");
		} catch (NoSuchWindowException e) {
			// TODO: handle exception
//			System.err.println("Target window doesn't exists to switch");
			reportStep("Target window doesn't exists to switch", "Fail");
		} catch (NoSuchCookieException e) {
			// TODO: handle exception
//			System.err.println("Cookie is not matching with the given cookie");
			reportStep("Cookie is not matching with the given cookie", "Fail");
		} catch (ConnectionClosedException e) {
			// TODO: handle exception
			reportStep("Driver got disconnected", "Fail");
//			System.err.println("Driver got disconnected");
		} catch (TimeoutException e) {
			// TODO: handle exception
			reportStep("TimeOut exception has occured due to not enough time to complete the command", "Fail");
//			System.err.println("TimeOut exception has occured due to not enough time to complete the command");
		} catch (ScriptTimeoutException e) {
			// TODO: handle exception
			reportStep("TimeOut exception has occured as it takes more time to perform the operation", "Fail");
//			System.err.println("TimeOut exception has occured as it takes more time to perform the operation");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unknown error occured", "Fail");
//			System.err.println("Unknown error occured");
		} 
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
//			System.out.println("Alert is Accepted successfully");
			reportStep("Alert is Accepted successfully", "Pass");
		} catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
			reportStep("Alert is displayed but Webdriver is unable to perform alert operation", "Fail");
//			System.err.println("Alert is displayed but Webdriver is unable to perform alert operation");
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
			reportStep("No alert is present to get the text", "Fail");
//			System.err.println("No alert is present to get the text");
		} catch (TimeoutException e) {
			// TODO: handle exception
			reportStep("TimeOut exception has occured due to not enough time to complete the command", "Fail");
//			System.err.println("TimeOut exception has occured due to not enough time to complete the command");
		} catch (ScriptTimeoutException e) {
			// TODO: handle exception
			reportStep("TimeOut exception has occured as it takes more time to perform the operation", "Fail");
//			System.err.println("TimeOut exception has occured as it takes more time to perform the operation");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unknown error occured", "Fail");
//			System.err.println("Unknown error occured");
		} 
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
//			System.out.println("Alert is dismissed successfully");
			reportStep("Alert is dismissed successfully", "Pass");
		} catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
			reportStep("Alert is displayed but Webdriver is unable to perform alert operation", "Fail");
//			System.err.println("Alert is displayed but Webdriver is unable to perform alert operation");
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
			reportStep("No alert is present to get the text", "Fail");
//			System.err.println("No alert is present to get the text");
		} catch (TimeoutException e) {
			// TODO: handle exception
			reportStep("TimeOut exception has occured due to not enough time to complete the command", "Fail");
//			System.err.println("TimeOut exception has occured due to not enough time to complete the command");
		} catch (ScriptTimeoutException e) {
			// TODO: handle exception
			reportStep("TimeOut exception has occured as it takes more time to perform the operation", "Fail");
//			System.err.println("TimeOut exception has occured as it takes more time to perform the operation");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unknown error occured", "Fail");
//			System.err.println("Unknown error occured");
		} 
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		try {
			String alertext = driver.switchTo().alert().getText();
			System.out.println(alertext);
			reportStep("Get text is successful", "Pass");
		} catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
//			System.err.println("Alert is displayed but Webdriver is unable to perform alert operation");
			reportStep("Alert is displayed but Webdriver is unable to perform alert operation", "Fail");
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
//			System.err.println("No alert is present to get the text");
		} catch (TimeoutException e) {
			// TODO: handle exception
			reportStep("TimeOut exception has occured due to not enough time to complete the command", "Fail");
//			System.err.println("TimeOut exception has occured due to not enough time to complete the command");
		} catch (ScriptTimeoutException e) {
			// TODO: handle exception
			reportStep("TimeOut exception has occured as it takes more time to perform the operation", "Fail");
//			System.err.println("TimeOut exception has occured as it takes more time to perform the operation");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unknown error occured", "Fail");
//			System.err.println("Unknown error occured");
		} 
		return null;
	}

	public long takeSnap() {
		// TODO Auto-generated method stub

		long number = 0;
		try {
		number=	(long) (Math.floor(Math.random()*100000000)+1000000);
				
			File temp = driver.getScreenshotAs(OutputType.FILE);	
			File dest = new File("./reports/Screenshots/"+number+".png");
			FileUtils.copyFile(temp, dest);
			// System.out.println("Screen shot is taken and copied to the
			// destination folder, ./Screenshots/Snap1.png");
		//	reportStep("Take snap is successful", "Pass");
		} catch (ScreenshotException e) {
			reportStep("Unable to capture screen shot of this page", "Fail");
//			System.err.println("Unable to capture screen shot of this page");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			reportStep("Screen shot is not taken due to unknown error", "Fail");
//			System.err.println("Screen shot is not taken due to unknown error");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			reportStep("Screen shot is not taken due to IOE exception", "Fail");
//			System.err.println("Screen shot is not taken due to IOE exception");
		}
		return number;
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
//			System.out.println("Browser is closed successfully.");
			reportStep("Browser is closed successfully", "Pass");
		} catch (UnsupportedCommandException e) {
			// TODO Auto-generated catch block
			System.err.println("Driver doesn't send valid command to close the browsers");
//			reportStep("Driver doesn't send valid command to close the browsers", "Fail");
		} catch (UnreachableBrowserException e) {
			// TODO: handle exception
			reportStep("Unable to close the browser due to some crash in network/server", "Fail");
//			System.err.println("Unable to close the browser due to some crash in network/server");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Browser is not closed due to unknown error", "Fail");
//			System.err.println("Browser is not closed due to unknown error");
		}
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
//			System.out.println("All browsers are closed successfully");
			reportStep("All browsers are closed successfully", "Pass", false);
		} catch (UnsupportedCommandException e) {
			// TODO Auto-generated catch block
			System.err.println("Driver doesn't send valid command to close the browsers");
//			reportStep("Driver doesn't send valid command to close the browsers", "Fail");
		} catch (UnreachableBrowserException e) {
			// TODO: handle exception
			reportStep("Unable to close the browser due to some crash in network/server", "Fail");
//			System.err.println("Unable to close the browser due to some crash in network/server");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Browser is not closed due to unknown error", "Fail");
//			System.err.println("Browser is not closed due to unknown error");
		}
	}

	public void selectvaluebyXpath(String Xpath, String data) {
		// TODO Auto-generated method stub
		try {
			WebElement byvalue = driver.findElementByXPath(Xpath);
			Select xpathbyval = new Select(byvalue);
			xpathbyval.selectByValue(data);
			reportStep("Selection is successful", "Pass");
		} catch (ElementNotSelectableException e) {
			// TODO Auto-generated catch block
			reportStep("The Element is not selectable in the application", "Fail");
//			System.out.println("The Element is not selectable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unknown error occured", "Fail");
//			System.out.println("Unknown error occured");
		}

	}

	public void performKeyBoardOperationByXpath(String xpath, String actionName) {
		// TODO Auto-generated method stub

		try {
			if (actionName.equalsIgnoreCase("Tab")) {
				driver.findElementByXPath(xpath).sendKeys(Keys.TAB);
			} else if (actionName.equalsIgnoreCase("Pagedown")) {
				driver.findElementByXPath(xpath).sendKeys(Keys.PAGE_DOWN);

			} else if (actionName.equalsIgnoreCase("Enter")) {
				driver.findElementByXPath(xpath).sendKeys(Keys.ENTER);
			} else if (actionName.equalsIgnoreCase("Space")) {
				driver.findElementByXPath(xpath).sendKeys(Keys.SPACE);
			}
//			System.out.println("Keyboard operation is done");
			reportStep("Keyboard operation is done", "Pass");
		} catch (ElementNotInteractableException e) {
			// TODO Auto-generated catch block
			reportStep("The element is not interactable in the application", "Fail");
//			System.err.println("The element is not interactable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unknown error occured", "Fail");
//			System.err.println("Unknown error occured");
		}

	}

	public void performKeyBoardOperationById(String id, String actionName) {
		// TODO Auto-generated method stub
		try {
			if (actionName.equalsIgnoreCase("Tab")) {
				driver.findElementById(id).sendKeys(Keys.TAB);
			} else if (actionName.equalsIgnoreCase("Pagedown")) {
				driver.findElementById(id).sendKeys(Keys.PAGE_DOWN);

			} else if (actionName.equalsIgnoreCase("Enter")) {
				driver.findElementById(id).sendKeys(Keys.ENTER);
			}
//			System.out.println("Keyboard operation is done");
			reportStep("Keyboard operation is done", "Pass");
		} catch (ElementNotInteractableException e) {
			// TODO Auto-generated catch block
			reportStep("The element is not interactable in the application", "Fail");
//			System.err.println("The element is not interactable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unknown error occured", "Fail");
//			System.err.println("Unknown error occured");
		}

	}

	public void selectIndexByXpath(String Xpath, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement byvalue = driver.findElementByXPath(Xpath);
			Select xpathbyval = new Select(byvalue);
			xpathbyval.selectByIndex(value);
			reportStep("Selection is successfully", "Pass");
	} catch (ElementNotSelectableException e) {
		// TODO Auto-generated catch block
		reportStep("The Element is not selectable in the application", "Fail");
//		System.out.println("The Element is not selectable in the application");
	} catch (WebDriverException e) {
		// TODO: handle exception
		reportStep("Unknown error occured", "Fail");
//		System.out.println("Unknown error occured");
	}
	}

	public void sleep(long a) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(a);
//			System.out.println("Wait operation performed");
			reportStep("Wait operation performed", "Pass");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			reportStep("Unknown error occured", "Fail");
//			System.out.println("Unknown error occured");
		} catch (InterruptedException e) {
			// TODO: handle exception
			reportStep("Interrupted exception occurs", "Fail");
//			System.out.println("Interrupted exception occurs");
		}

	}

	public void selectValueByName(String name, String namevalue) {
		// TODO Auto-generated method stub
		try {
			WebElement selectval = driver.findElementByName(name);
			Select byname = new Select(selectval);
			byname.selectByValue(namevalue);
			reportStep("Selection is successfully", "Pass");
		} catch (ElementNotSelectableException e) {
			// TODO Auto-generated catch block
			reportStep("The Element is not selectable in the application", "Fail");
//			System.out.println("The Element is not selectable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unknown error occured", "Fail");
//			System.out.println("Unknown error occured");
		}

	}

	public void selectVisibileTextByName(String name, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement byname = driver.findElementByName(name);
			Select visibletext = new Select(byname);
			visibletext.selectByVisibleText(value);
			reportStep("Selection is successfully", "Pass");
		} catch (ElementNotSelectableException e) {
			// TODO Auto-generated catch block
//			System.err.println("The Element is not selectable in the application");
			reportStep("The Element is not selectable in the application", "Fail");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			reportStep("The Element is not interactable in the application", "Fail");
//			System.err.println("The Element is not interactable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unknown error occured", "Fail");
//			System.err.println("Unknown error occured");
		}		
		
	}

	public String getAttributeByXpath(String xpathvalue) {
		// TODO Auto-generated method stub
		String attval = null;
		try {
			WebElement Attrib = driver.findElementByXPath(xpathvalue);
			attval = Attrib.getAttribute("value");
//			System.out.println(attval);
			reportStep("Get attribute"+attval+ " is successful", "Pass");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			reportStep("The Element is not present in the application", "Pass");
//			System.err.println("The Element is not present in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unknown error occured", "Fail");
//			System.err.println("Unknown error occured");
		}
		return attval;
		
	}

	public void selectValueById(String id, String Idvalue) {
		// TODO Auto-generated method stub
		try {
			WebElement selectval = driver.findElementByName(id);
			Select byname = new Select(selectval);
			byname.selectByValue(Idvalue);
			reportStep("Selection is successful", "Pass");
		} catch (ElementNotSelectableException e) {
			// TODO Auto-generated catch block
			reportStep("The Element is not selectable in the application", "Fail");
//			System.out.println("The Element is not selectable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unknown error occured", "Fail");
//			System.out.println("Unknown error occured");	
	}

}

	public void selectIndexName(String Name, int index) {
		// TODO Auto-generated method stub
		try {
			WebElement indexid = driver.findElementByName(Name);
			Select byid = new Select(indexid);
			byid.selectByIndex(index);
		} catch (ElementClickInterceptedException e) {
			System.err.println("The Element with" + Name + " is not clickable in the Application ");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The Element with" + Name + " is unable to found in the DOM");
		} catch (NotFoundException e) {
			// TODO: handle exception
			System.err.println("The Element with" + Name + " doesn't exists in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The Element with" + Name + " is not visible in the Application ");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The Element with" + Name + " is not interactable in the Application");
		} catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The Element with" + Name + " is not selectable in the Application ");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The Element with" + Name + " is not stable in the Application");
		} catch (ConnectionClosedException e) {
			// TODO: handle exception
			System.err.println("Driver got disconnected");
		} catch (TimeoutException e) {
			// TODO: handle exception
			reportStep("Enough time is not there to perform the action", "Fail");
//			System.err.println("TimeOut exception has occured due to not enough time to complete the command");
		} catch (ScriptTimeoutException e) {
			// TODO: handle exception
			reportStep("The script is taking more time to return the value", "Fail");
//			System.err.println("TimeOut exception has occured as it takes more time to perform the operation");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unable to verify title due to unknown error","Fail");
//			System.err.println("Unable to select the value to unknown error");
		} 
		
	}

	public void getTitleByXpath(String xpath) {
		// TODO Auto-generated method stub
		try {
			String actual = driver.getTitle();
			System.out.println(actual);
			reportStep("Get title is successfull", "Pass");
		} catch (ElementNotVisibleException e) {
			// TODO Auto-generated catch block
			reportStep("The Element with" + xpath + " is not visible in the Application", "Fail");
//			System.err.println("The Element with" + xpath + " is not visible in the Application");
		} catch (ScriptTimeoutException e2) {
			// TODO: handle exception
			reportStep("The script is taking more time to return the value", "Fail");
//			System.err.println("The script is taking more time to return the value");
		} catch (TimeoutException e) {
			// TODO: handle exception
			reportStep("Enough time is not there to perform the action", "Fail");
//			System.err.println("Enough time is not there to perform the action");
		} catch (WebDriverException e) {
			// TODO: handle exception
			reportStep("Unable to verify title due to unknown error","Fail");
//			System.err.println("Unable to verify title due to unknown error");
		} 
	
	}

	
	public void sleep(int time) {
		// TODO Auto-generated method stub
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.navigate();
		List al =driver.findElementsByClassName("test");
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.alertIsPresent());
			
			
			
			
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.id(""))).build().perform();			
			Wait<WebDriver> wa = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(15))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoAlertPresentException.class);

				WebElement clickseleniumlink = wa.until(new Function<WebDriver, WebElement>() {


					@Override
					
					public WebElement apply(WebDriver t) {
						// TODO Auto-generated method stub
						return driver.findElementByClassName("");

					}
				});
			}
			
			
	public void switchToIndex(int index){
		
		Set<String> allwin = driver.getWindowHandles();
		List<String> listwin = new ArrayList<String>(allwin);
		String one = listwin.get(4);
		driver.switchTo().window(one).getTitle();
		
   for(int i =0;i<=listwin.size();i++){
			
			switch(i){
			
			case 0:String s = listwin.get(i);
			String s1=	driver.switchTo().window(s).getTitle();
			if(s1.equals("GOogle")){
				System.out.println(1);
			}
			else{
				System.out.println(0);				
			}	
			break;			
			
			case 1 :String ss = listwin.get(i);
			String s2=	driver.switchTo().window(ss).getTitle();
			if(s2.equals("GOogle")){
				System.out.println(1);
			}
			else{
				System.out.println(0);				
			}	
			break;					
			}
		}	
	//---------------------------------------------------------------------index from method argument
		
		Set<String> allwins = driver.getWindowHandles();
		for(int i =0;i<=allwins.size();i++){
			
			if(i==index){
				String s3 = listwin.get(i);
				String s4=	driver.switchTo().window(s3).getTitle();
			}
		}	
	}
		
	public void fileUpload() throws AWTException{
		
		StringSelection ss = new StringSelection("");
		Clipboard cb =Toolkit.getDefaultToolkit().getSystemClipboard();
		cb.setContents(ss, null);
		
		
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		
		
	}
		
	public void assertion() throws ClassNotFoundException, SQLException{
		
		String s5 = "test";
		WebElement ele = driver.findElement(By.id("id"));
		Assert.assertEquals(s5, ele);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(s5, ele);
		sa.assertAll();
		//----------------------------------------------------------------------------------
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)"); //vertical
		js.executeScript("window.scrollBy(500,0)");//horizontal
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); //bottom of the page
		
		js.executeScript("argument[0].scrollIntoView();", ele);
		//---------------------------------------------------------------------------------------
		
		Class.forName("");
		
		Connection con = DriverManager.getConnection("", "", "");
		
		Statement st = con.createStatement();
		
		ResultSet rs= st.executeQuery(" ");
		
		con.close();
		
		//-------------------------------------------------------------------------------------
		
		Integer I = new Integer(10);
		
		driver.findElement(By.id("test")).sendKeys(Keys.values());
		
		
		
	}
		
		
		
		
		
		
		
		
	

}
