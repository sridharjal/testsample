package scripts.MobileAutomation.Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WindowType;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.io.File;
import scripts.MobileAutomation.Config.LocalDriverManager;

public class WebDriverActions {

	/**
	 * navigate to URL.
	 *
	 * @param url
	 *            the URL to navigate to
	 * @throws Exception
	 *           
	 */
	public void navigateToUrl(String url) throws Exception{
		try {
			LocalDriverManager.getDriver().get(url);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * get current URL.
	 *
	 * @return String
	 *            the current URL
	 * @throws Exception
	 *           
	 */
	public String getCurrentUrl() throws Exception{
		try {
			return LocalDriverManager.getDriver().getCurrentUrl();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * get page title.
	 *
	 * @return String
	 *            the page title
	 * @throws Exception
	 *           
	 */
	public String getPageTitle() throws Exception{
		try {
			return LocalDriverManager.getDriver().getTitle();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * get page source.
	 *
	 * @return String
	 *            the page source
	 * @throws Exception
	 *           
	 */
	public String getPageSource() throws Exception{
		try {
			return LocalDriverManager.getDriver().getPageSource();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * navigate back.
	 *
	 * @throws Exception
	 *           
	 */
	public void navigateBack() throws Exception{
		try {
			LocalDriverManager.getDriver().navigate().back();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * navigate forward.
	 *
	 * @throws Exception
	 *           
	 */
	public void navigateForward() throws Exception{
		try {
			LocalDriverManager.getDriver().navigate().forward();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * refresh page.
	 *
	 * @throws Exception
	 *           
	 */
	public void refreshPage() throws Exception{
		try {
			LocalDriverManager.getDriver().navigate().refresh();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * close current window.
	 *
	 * @throws Exception
	 *           
	 */
	public void closeCurrentWindow() throws Exception{
		try {
			LocalDriverManager.getDriver().close();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * quit driver.
	 *
	 * @throws Exception
	 *           
	 */
	public void quitDriver() throws Exception{
		try {
			LocalDriverManager.getDriver().quit();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * wait for element to be visible.
	 *
	 * @param element
	 *            the web element
	 * @param timeoutInSeconds
	 *            the timeout in seconds
	 * @return WebElement
	 *            the visible element
	 * @throws Exception
	 *           
	 */
	public WebElement waitForElementToBeVisible(WebElement element, int timeoutInSeconds) throws Exception{
		try {
			WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), Duration.ofSeconds(timeoutInSeconds));
			return wait.until(ExpectedConditions.visibilityOf(element));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * wait for element to be clickable.
	 *
	 * @param element
	 *            the web element
	 * @param timeoutInSeconds
	 *            the timeout in seconds
	 * @return WebElement
	 *            the clickable element
	 * @throws Exception
	 *           
	 */
	public WebElement waitForElementToBeClickable(WebElement element, int timeoutInSeconds) throws Exception{
		try {
			WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), Duration.ofSeconds(timeoutInSeconds));
			return wait.until(ExpectedConditions.elementToBeClickable(element));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * wait for text to be present in element.
	 *
	 * @param element
	 *            the web element
	 * @param text
	 *            the text to wait for
	 * @param timeoutInSeconds
	 *            the timeout in seconds
	 * @return boolean
	 *            true if text is present
	 * @throws Exception
	 *           
	 */
	public boolean waitForTextToBePresentInElement(WebElement element, String text, int timeoutInSeconds) throws Exception{
		try {
			WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), Duration.ofSeconds(timeoutInSeconds));
			return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * wait for element to be invisible.
	 *
	 * @param element
	 *            the web element
	 * @param timeoutInSeconds
	 *            the timeout in seconds
	 * @return boolean
	 *            true if element is invisible
	 * @throws Exception
	 *           
	 */
	public boolean waitForElementToBeInvisible(WebElement element, int timeoutInSeconds) throws Exception{
		try {
			WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), Duration.ofSeconds(timeoutInSeconds));
			return wait.until(ExpectedConditions.invisibilityOf(element));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * click element.
	 *
	 * @param element
	 *            the web element to click
	 * @throws Exception
	 *           
	 */
	public void clickElement(WebElement element) throws Exception{
		try {
			element.click();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * enter text into element.
	 *
	 * @param element
	 *            the web element 
	 * @param text
	 *            the text to enter
	 * @throws Exception
	 *           
	 */
	public void enterText(WebElement element, String text) throws Exception{
		try {
			element.clear();
			element.sendKeys(text);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * get text from element.
	 *
	 * @param element
	 *            the web element 
	 * @return String
	 *            the element text
	 * @throws Exception
	 *           
	 */
	public String getText(WebElement element) throws Exception{
		try {
			return element.getText();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * get element attribute.
	 *
	 * @param element
	 *            the web element 
	 * @param attributeName
	 *            the attribute name
	 * @return String
	 *            the attribute value
	 * @throws Exception
	 *           
	 */
	public String getElementAttribute(WebElement element, String attributeName) throws Exception{
		try {
			return element.getAttribute(attributeName);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * check if element is displayed.
	 *
	 * @param element
	 *            the web element 
	 * @return boolean
	 *            true if element is displayed
	 * @throws Exception
	 *           
	 */
	public boolean isElementDisplayed(WebElement element) throws Exception{
		try {
			return element.isDisplayed();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * check if element is enabled.
	 *
	 * @param element
	 *            the web element 
	 * @return boolean
	 *            true if element is enabled
	 * @throws Exception
	 *           
	 */
	public boolean isElementEnabled(WebElement element) throws Exception{
		try {
			return element.isEnabled();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * check if element is selected.
	 *
	 * @param element
	 *            the web element 
	 * @return boolean
	 *            true if element is selected
	 * @throws Exception
	 *           
	 */
	public boolean isElementSelected(WebElement element) throws Exception{
		try {
			return element.isSelected();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * clear element text.
	 *
	 * @param element
	 *            the web element 
	 * @throws Exception
	 *           
	 */
	public void clearElement(WebElement element) throws Exception{
		try {
			element.clear();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	
	/**
	 * select radio button.
	 *
	 * @param element
	 *            the radio button element 
	 * @throws Exception
	 *           
	 */
	public void selectRadioButton(WebElement element) throws Exception{
		try {
			if (!element.isSelected()) {
				element.click();
			}
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	
	/**
	 * check checkbox (select it).
	 *
	 * @param element
	 *            the checkbox element 
	 * @throws Exception
	 *           
	 */
	public void checkCheckbox(WebElement element) throws Exception{
		try {
			if (!element.isSelected()) {
				element.click();
			}
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * uncheck checkbox (deselect it).
	 *
	 * @param element
	 *            the checkbox element 
	 * @throws Exception
	 *           
	 */
	public void uncheckCheckbox(WebElement element) throws Exception{
		try {
			if (element.isSelected()) {
				element.click();
			}
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	
	/**
	 * check if radio button is selected.
	 *
	 * @param element
	 *            the radio button element 
	 * @return boolean
	 *            true if radio button is selected
	 * @throws Exception
	 *           
	 */
	public boolean isRadioButtonSelected(WebElement element) throws Exception{
		try {
			return element.isSelected();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * check if checkbox is checked.
	 *
	 * @param element
	 *            the checkbox element 
	 * @return boolean
	 *            true if checkbox is checked
	 * @throws Exception
	 *           
	 */
	public boolean isCheckboxChecked(WebElement element) throws Exception{
		try {
			return element.isSelected();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * scroll to element.
	 *
	 * @param element
	 *            the web element to scroll to
	 * @throws Exception
	 *           
	 */
	public void scrollToElement(WebElement element) throws Exception{
		try {
			JavascriptExecutor js = (JavascriptExecutor) LocalDriverManager.getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * scroll by pixels.
	 *
	 * @param x
	 *            the horizontal pixels
	 * @param y
	 *            the vertical pixels
	 * @throws Exception
	 *           
	 */
	public void scrollByPixels(int x, int y) throws Exception{
		try {
			JavascriptExecutor js = (JavascriptExecutor) LocalDriverManager.getDriver();
			js.executeScript("window.scrollBy(" + x + ", " + y + ");");
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * scroll to top of page.
	 *
	 * @throws Exception
	 *           
	 */
	public void scrollToTop() throws Exception{
		try {
			JavascriptExecutor js = (JavascriptExecutor) LocalDriverManager.getDriver();
			js.executeScript("window.scrollTo(0, 0);");
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * scroll to bottom of page.
	 *
	 * @throws Exception
	 *           
	 */
	public void scrollToBottom() throws Exception{
		try {
			JavascriptExecutor js = (JavascriptExecutor) LocalDriverManager.getDriver();
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * click element using JavaScript.
	 *
	 * @param element
	 *            the web element to click
	 * @throws Exception
	 *           
	 */
	public void clickUsingJavaScript(WebElement element) throws Exception{
		try {
			JavascriptExecutor js = (JavascriptExecutor) LocalDriverManager.getDriver();
			js.executeScript("arguments[0].click();", element);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * highlight element.
	 *
	 * @param element
	 *            the web element to highlight
	 * @throws Exception
	 *           
	 */
	public void highlightElement(WebElement element) throws Exception{
		try {
			JavascriptExecutor js = (JavascriptExecutor) LocalDriverManager.getDriver();
			js.executeScript("arguments[0].style.border='3px solid red'", element);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * switch to window by handle.
	 *
	 * @param windowHandle
	 *            the window handle
	 * @throws Exception
	 *           
	 */
	public void switchToWindowByHandle(String windowHandle) throws Exception{
		try {
			LocalDriverManager.getDriver().switchTo().window(windowHandle);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * switch to window by title.
	 *
	 * @param windowTitle
	 *            the window title
	 * @throws Exception
	 *           
	 */
	public void switchToWindowByTitle(String windowTitle) throws Exception{
		try {
			Set<String> windowHandles = LocalDriverManager.getDriver().getWindowHandles();
			for (String handle : windowHandles) {
				LocalDriverManager.getDriver().switchTo().window(handle);
				if (LocalDriverManager.getDriver().getTitle().equals(windowTitle)) {
					break;
				}
			}
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * switch to new window.
	 *
	 * @param windowType
	 *            the type of window (TAB or WINDOW)
	 * @throws Exception
	 *           
	 */
	public void switchToNewWindow(WindowType windowType) throws Exception{
		try {
			LocalDriverManager.getDriver().switchTo().newWindow(windowType);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * get current window handle.
	 *
	 * @return String
	 *            the current window handle
	 * @throws Exception
	 *           
	 */
	public String getCurrentWindowHandle() throws Exception{
		try {
			return LocalDriverManager.getDriver().getWindowHandle();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * get all window handles.
	 *
	 * @return Set<String>
	 *            all window handles
	 * @throws Exception
	 *           
	 */
	public Set<String> getAllWindowHandles() throws Exception{
		try {
			return LocalDriverManager.getDriver().getWindowHandles();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * switch to frame by index.
	 *
	 * @param index
	 *            the frame index
	 * @throws Exception
	 *           
	 */
	public void switchToFrameByIndex(int index) throws Exception{
		try {
			LocalDriverManager.getDriver().switchTo().frame(index);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * switch to frame by name or ID.
	 *
	 * @param nameOrId
	 *            the frame name or ID
	 * @throws Exception
	 *           
	 */
	public void switchToFrameByNameOrId(String nameOrId) throws Exception{
		try {
			LocalDriverManager.getDriver().switchTo().frame(nameOrId);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * switch to frame by element.
	 *
	 * @param element
	 *            the frame element
	 * @throws Exception
	 *           
	 */
	public void switchToFrameByElement(WebElement element) throws Exception{
		try {
			LocalDriverManager.getDriver().switchTo().frame(element);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * switch to default content.
	 *
	 * @throws Exception
	 *           
	 */
	public void switchToDefaultContent() throws Exception{
		try {
			LocalDriverManager.getDriver().switchTo().defaultContent();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * accept alert.
	 *
	 * @throws Exception
	 *           
	 */
	public void acceptAlert() throws Exception{
		try {
			Alert alert = LocalDriverManager.getDriver().switchTo().alert();
			alert.accept();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * dismiss alert.
	 *
	 * @throws Exception
	 *           
	 */
	public void dismissAlert() throws Exception{
		try {
			Alert alert = LocalDriverManager.getDriver().switchTo().alert();
			alert.dismiss();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * get alert text.
	 *
	 * @return String
	 *            the alert text
	 * @throws Exception
	 *           
	 */
	public String getAlertText() throws Exception{
		try {
			Alert alert = LocalDriverManager.getDriver().switchTo().alert();
			return alert.getText();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * send keys to alert.
	 *
	 * @param text
	 *            the text to send
	 * @throws Exception
	 *           
	 */
	public void sendKeysToAlert(String text) throws Exception{
		try {
			Alert alert = LocalDriverManager.getDriver().switchTo().alert();
			alert.sendKeys(text);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * check if alert is present.
	 *
	 * @return boolean
	 *            true if alert is present
	 * @throws Exception
	 *           
	 */
	public boolean isAlertPresent() throws Exception{
		try {
			LocalDriverManager.getDriver().switchTo().alert();
			return true;
			
		} catch (Exception exception) {
			return false;
		}
	}
	
	/**
	 * select dropdown by visible text.
	 *
	 * @param element
	 *            the dropdown element
	 * @param text
	 *            the visible text
	 * @throws Exception
	 *           
	 */
	public void selectDropdownByVisibleText(WebElement element, String text) throws Exception{
		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * select dropdown by value.
	 *
	 * @param element
	 *            the dropdown element
	 * @param value
	 *            the value
	 * @throws Exception
	 *           
	 */
	public void selectDropdownByValue(WebElement element, String value) throws Exception{
		try {
			Select select = new Select(element);
			select.selectByValue(value);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * select dropdown by index.
	 *
	 * @param element
	 *            the dropdown element
	 * @param index
	 *            the index
	 * @throws Exception
	 *           
	 */
	public void selectDropdownByIndex(WebElement element, int index) throws Exception{
		try {
			Select select = new Select(element);
			select.selectByIndex(index);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * deselect all dropdown options.
	 *
	 * @param element
	 *            the dropdown element
	 * @throws Exception
	 *           
	 */
	public void deselectAllDropdownOptions(WebElement element) throws Exception{
		try {
			Select select = new Select(element);
			select.deselectAll();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * get selected dropdown option.
	 *
	 * @param element
	 *            the dropdown element
	 * @return WebElement
	 *            the selected option
	 * @throws Exception
	 *           
	 */
	public WebElement getSelectedDropdownOption(WebElement element) throws Exception{
		try {
			Select select = new Select(element);
			return select.getFirstSelectedOption();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * get all dropdown options.
	 *
	 * @param element
	 *            the dropdown element
	 * @return List<WebElement>
	 *            all dropdown options
	 * @throws Exception
	 *           
	 */
	public List<WebElement> getAllDropdownOptions(WebElement element) throws Exception{
		try {
			Select select = new Select(element);
			return select.getOptions();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * perform mouse hover.
	 *
	 * @param element
	 *            the element to hover over
	 * @throws Exception
	 *           
	 */
	public void mouseHover(WebElement element) throws Exception{
		try {
			Actions actions = new Actions(LocalDriverManager.getDriver());
			actions.moveToElement(element).perform();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * perform right click.
	 *
	 * @param element
	 *            the element to right click
	 * @throws Exception
	 *           
	 */
	public void rightClick(WebElement element) throws Exception{
		try {
			Actions actions = new Actions(LocalDriverManager.getDriver());
			actions.contextClick(element).perform();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * perform double click.
	 *
	 * @param element
	 *            the element to double click
	 * @throws Exception
	 *           
	 */
	public void doubleClick(WebElement element) throws Exception{
		try {
			Actions actions = new Actions(LocalDriverManager.getDriver());
			actions.doubleClick(element).perform();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * perform drag and drop.
	 *
	 * @param sourceElement
	 *            the source element
	 * @param targetElement
	 *            the target element
	 * @throws Exception
	 *           
	 */
	public void dragAndDrop(WebElement sourceElement, WebElement targetElement) throws Exception{
		try {
			Actions actions = new Actions(LocalDriverManager.getDriver());
			actions.dragAndDrop(sourceElement, targetElement).perform();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	
	
	/**
	 * set window size.
	 *
	 * @param width
	 *            the window width
	 * @param height
	 *            the window height
	 * @throws Exception
	 *           
	 */
	public void setWindowSize(int width, int height) throws Exception{
		try {
			Dimension dimension = new Dimension(width, height);
			LocalDriverManager.getDriver().manage().window().setSize(dimension);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * get window size.
	 *
	 * @return Dimension
	 *            the window size
	 * @throws Exception
	 *           
	 */
	public Dimension getWindowSize() throws Exception{
		try {
			return LocalDriverManager.getDriver().manage().window().getSize();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * set window position.
	 *
	 * @param x
	 *            the X coordinate
	 * @param y
	 *            the Y coordinate
	 * @throws Exception
	 *           
	 */
	public void setWindowPosition(int x, int y) throws Exception{
		try {
			Point position = new Point(x, y);
			LocalDriverManager.getDriver().manage().window().setPosition(position);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * get window position.
	 *
	 * @return Point
	 *            the window position
	 * @throws Exception
	 *           
	 */
	public Point getWindowPosition() throws Exception{
		try {
			return LocalDriverManager.getDriver().manage().window().getPosition();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * maximize window.
	 *
	 * @throws Exception
	 *           
	 */
	public void maximizeWindow() throws Exception{
		try {
			LocalDriverManager.getDriver().manage().window().maximize();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * minimize window.
	 *
	 * @throws Exception
	 *           
	 */
	public void minimizeWindow() throws Exception{
		try {
			LocalDriverManager.getDriver().manage().window().minimize();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * make window fullscreen.
	 *
	 * @throws Exception
	 *           
	 */
	public void fullscreenWindow() throws Exception{
		try {
			LocalDriverManager.getDriver().manage().window().fullscreen();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	
	
	/**
	 * set implicit wait.
	 *
	 * @param timeoutInSeconds
	 *            the timeout in seconds
	 * @throws Exception
	 *           
	 */
	public void setImplicitWait(int timeoutInSeconds) throws Exception{
		try {
			LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * set page load timeout.
	 *
	 * @param timeoutInSeconds
	 *            the timeout in seconds
	 * @throws Exception
	 *           
	 */
	public void setPageLoadTimeout(int timeoutInSeconds) throws Exception{
		try {
			LocalDriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeoutInSeconds));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	
	/**
	 * take screenshot.
	 *
	 * @return File
	 *            the screenshot file
	 * @throws Exception
	 *           
	 */
	public File takeScreenshot() throws Exception{
		try {
			TakesScreenshot screenshot = (TakesScreenshot) LocalDriverManager.getDriver();
			return screenshot.getScreenshotAs(OutputType.FILE);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * take screenshot as bytes.
	 *
	 * @return byte[]
	 *            the screenshot as bytes
	 * @throws Exception
	 *           
	 */
	public byte[] takeScreenshotAsBytes() throws Exception{
		try {
			TakesScreenshot screenshot = (TakesScreenshot) LocalDriverManager.getDriver();
			return screenshot.getScreenshotAs(OutputType.BYTES);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * take screenshot as base64.
	 *
	 * @return String
	 *            the screenshot as base64 string
	 * @throws Exception
	 *           
	 */
	public String takeScreenshotAsBase64() throws Exception{
		try {
			TakesScreenshot screenshot = (TakesScreenshot) LocalDriverManager.getDriver();
			return screenshot.getScreenshotAs(OutputType.BASE64);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}

}