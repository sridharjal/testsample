package scripts.MobileAutomation.Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
import java.time.Duration;
import java.util.Arrays;
import scripts.MobileAutomation.Config.LocalDriverManager;

public class AppiumActions {
	
	/**
	 * click Element.
	 *
	 * @param webElement
	 *            the web element 
	 * @throws Exception
	 *           
	 */
	public void clickElement(WebElement el) throws Exception{
		try {
			el.click();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	
	/**
	 * enter text into text field.
	 *
	 * @param webElement
	 *            the web element 
	 * @param text
	 *            the text to enter
	 * @throws Exception
	 *           
	 */
	public void enterText(WebElement el, String text) throws Exception{
		try {
			el.clear();
			el.sendKeys(text);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * retrieve text from element.
	 *
	 * @param webElement
	 *            the web element 
	 * @return String
	 *            the text content
	 * @throws Exception
	 *           
	 */
	public String retrieveText(WebElement el) throws Exception{
		try {
			return el.getText();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * scroll down using web element.
	 *
	 * @param webElement
	 *            the web element to scroll on
	 * @throws Exception
	 *           
	 */
	public void scrollDownUsingElement(WebElement el) throws Exception{
		try {
			Point location = el.getLocation();
			Dimension size = el.getSize();
			int centerX = location.getX() + size.getWidth() / 2;
			int startY = location.getY() + size.getHeight() / 4; // Start from 1/4 of element height
			int endY = location.getY() + (size.getHeight() * 3 / 4); // End at 3/4 of element height
			
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence scrollDown = new Sequence(finger, 1);
			scrollDown.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY));
			scrollDown.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			scrollDown.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), centerX, endY));
			scrollDown.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(scrollDown));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * scroll up using web element.
	 *
	 * @param webElement
	 *            the web element to scroll on
	 * @throws Exception
	 *           
	 */
	public void scrollUpUsingElement(WebElement el) throws Exception{
		try {
			Point location = el.getLocation();
			Dimension size = el.getSize();
			int centerX = location.getX() + size.getWidth() / 2;
			int startY = location.getY() + (size.getHeight() * 3 / 4); // Start from 3/4 of element height
			int endY = location.getY() + size.getHeight() / 4; // End at 1/4 of element height
			
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence scrollUp = new Sequence(finger, 1);
			scrollUp.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY));
			scrollUp.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			scrollUp.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), centerX, endY));
			scrollUp.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(scrollUp));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * swipe left using web element.
	 *
	 * @param webElement
	 *            the web element to swipe on
	 * @throws Exception
	 *           
	 */
	public void swipeLeftUsingElement(WebElement el) throws Exception{
		try {
			Point location = el.getLocation();
			Dimension size = el.getSize();
			int startX = location.getX() + (size.getWidth() * 3 / 4); // Start from 3/4 of element width
			int endX = location.getX() + size.getWidth() / 4; // End at 1/4 of element width
			int centerY = location.getY() + size.getHeight() / 2;
			
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence swipeLeft = new Sequence(finger, 1);
			swipeLeft.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, centerY));
			swipeLeft.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			swipeLeft.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, centerY));
			swipeLeft.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(swipeLeft));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * swipe right using web element.
	 *
	 * @param webElement
	 *            the web element to swipe on
	 * @throws Exception
	 *           
	 */
	public void swipeRightUsingElement(WebElement el) throws Exception{
		try {
			Point location = el.getLocation();
			Dimension size = el.getSize();
			int startX = location.getX() + size.getWidth() / 4; // Start from 1/4 of element width
			int endX = location.getX() + (size.getWidth() * 3 / 4); // End at 3/4 of element width
			int centerY = location.getY() + size.getHeight() / 2;
			
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence swipeRight = new Sequence(finger, 1);
			swipeRight.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, centerY));
			swipeRight.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			swipeRight.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, centerY));
			swipeRight.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(swipeRight));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * scroll down using coordinates.
	 *
	 * @param startX
	 *            the start X coordinate
	 * @param startY
	 *            the start Y coordinate
	 * @param endX
	 *            the end X coordinate
	 * @param endY
	 *            the end Y coordinate
	 * @throws Exception
	 *           
	 */
	public void scrollDownUsingCoordinates(int startX, int startY, int endX, int endY) throws Exception{
		try {
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence scrollDown = new Sequence(finger, 1);
			scrollDown.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
			scrollDown.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			scrollDown.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, endY));
			scrollDown.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(scrollDown));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * scroll up using coordinates.
	 *
	 * @param startX
	 *            the start X coordinate
	 * @param startY
	 *            the start Y coordinate
	 * @param endX
	 *            the end X coordinate
	 * @param endY
	 *            the end Y coordinate
	 * @throws Exception
	 *           
	 */
	public void scrollUpUsingCoordinates(int startX, int startY, int endX, int endY) throws Exception{
		try {
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence scrollUp = new Sequence(finger, 1);
			scrollUp.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
			scrollUp.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			scrollUp.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, endY));
			scrollUp.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(scrollUp));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * swipe left using coordinates.
	 *
	 * @param startX
	 *            the start X coordinate
	 * @param startY
	 *            the start Y coordinate
	 * @param endX
	 *            the end X coordinate
	 * @param endY
	 *            the end Y coordinate
	 * @throws Exception
	 *           
	 */
	public void swipeLeftUsingCoordinates(int startX, int startY, int endX, int endY) throws Exception{
		try {
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence swipeLeft = new Sequence(finger, 1);
			swipeLeft.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
			swipeLeft.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			swipeLeft.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, endY));
			swipeLeft.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(swipeLeft));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * swipe right using coordinates.
	 *
	 * @param startX
	 *            the start X coordinate
	 * @param startY
	 *            the start Y coordinate
	 * @param endX
	 *            the end X coordinate
	 * @param endY
	 *            the end Y coordinate
	 * @throws Exception
	 *           
	 */
	public void swipeRightUsingCoordinates(int startX, int startY, int endX, int endY) throws Exception{
		try {
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence swipeRight = new Sequence(finger, 1);
			swipeRight.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
			swipeRight.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			swipeRight.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, endY));
			swipeRight.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(swipeRight));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * zoom in using coordinates.
	 *
	 * @param centerX
	 *            the center X coordinate
	 * @param centerY
	 *            the center Y coordinate
	 * @param distance
	 *            the distance to zoom
	 * @throws Exception
	 *           
	 */
	public void zoomInUsingCoordinates(int centerX, int centerY, int distance) throws Exception{
		try {
			PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
			PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
			
			Sequence finger1Sequence = new Sequence(finger1, 1);
			Sequence finger2Sequence = new Sequence(finger2, 1);
			
			// Start both fingers at center, then move them apart
			finger1Sequence.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
			finger1Sequence.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			finger1Sequence.addAction(finger1.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), centerX - distance, centerY));
			finger1Sequence.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			finger2Sequence.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
			finger2Sequence.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			finger2Sequence.addAction(finger2.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), centerX + distance, centerY));
			finger2Sequence.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(finger1Sequence, finger2Sequence));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * zoom out using coordinates.
	 *
	 * @param centerX
	 *            the center X coordinate
	 * @param centerY
	 *            the center Y coordinate
	 * @param distance
	 *            the distance to zoom
	 * @throws Exception
	 *           
	 */
	public void zoomOutUsingCoordinates(int centerX, int centerY, int distance) throws Exception{
		try {
			PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
			PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
			
			Sequence finger1Sequence = new Sequence(finger1, 1);
			Sequence finger2Sequence = new Sequence(finger2, 1);
			
			// Start both fingers apart, then move them together
			finger1Sequence.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX - distance, centerY));
			finger1Sequence.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			finger1Sequence.addAction(finger1.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), centerX, centerY));
			finger1Sequence.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			finger2Sequence.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX + distance, centerY));
			finger2Sequence.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			finger2Sequence.addAction(finger2.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), centerX, centerY));
			finger2Sequence.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(finger1Sequence, finger2Sequence));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * zoom in using web element.
	 *
	 * @param webElement
	 *            the web element to zoom on
	 * @throws Exception
	 *           
	 */
	public void zoomInUsingElement(WebElement el) throws Exception{
		try {
			Point location = el.getLocation();
			Dimension size = el.getSize();
			int centerX = location.getX() + size.getWidth() / 2;
			int centerY = location.getY() + size.getHeight() / 2;
			int distance = Math.min(size.getWidth(), size.getHeight()) / 4; // Use 1/4 of smaller dimension
			
			zoomInUsingCoordinates(centerX, centerY, distance);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * zoom out using web element.
	 *
	 * @param webElement
	 *            the web element to zoom on
	 * @throws Exception
	 *           
	 */
	public void zoomOutUsingElement(WebElement el) throws Exception{
		try {
			Point location = el.getLocation();
			Dimension size = el.getSize();
			int centerX = location.getX() + size.getWidth() / 2;
			int centerY = location.getY() + size.getHeight() / 2;
			int distance = Math.min(size.getWidth(), size.getHeight()) / 4; // Use 1/4 of smaller dimension
			
			zoomOutUsingCoordinates(centerX, centerY, distance);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * select radio button.
	 *
	 * @param webElement
	 *            the web element 
	 * @throws Exception
	 *           
	 */
	public void selectRadioButton(WebElement el) throws Exception{
		try {
			if (!el.isSelected()) {
				el.click();
			}
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * select checkbox.
	 *
	 * @param webElement
	 *            the web element 
	 * @param select
	 *            true to select, false to unselect
	 * @throws Exception
	 *           
	 */
	public void selectCheckbox(WebElement el, boolean select) throws Exception{
		try {
			if (select && !el.isSelected()) {
				el.click();
			} else if (!select && el.isSelected()) {
				el.click();
			}
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	

	
	/**
	 * tap using web element.
	 *
	 * @param webElement
	 *            the web element 
	 * @throws Exception
	 *           
	 */
	public void tapUsingElement(WebElement el) throws Exception{
		try {
			Point location = el.getLocation();
			Dimension size = el.getSize();
			int centerX = location.getX() + size.getWidth() / 2;
			int centerY = location.getY() + size.getHeight() / 2;
			
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence tap = new Sequence(finger, 1);
			tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
			tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(tap));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * tap using coordinates.
	 *
	 * @param x
	 *            the X coordinate
	 * @param y
	 *            the Y coordinate
	 * @throws Exception
	 *           
	 */
	public void tapUsingCoordinates(int x, int y) throws Exception{
		try {
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence tap = new Sequence(finger, 1);
			tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
			tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(tap));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * double tap using web element.
	 *
	 * @param webElement
	 *            the web element 
	 * @throws Exception
	 *           
	 */
	public void doubleTapUsingElement(WebElement el) throws Exception{
		try {
			Point location = el.getLocation();
			Dimension size = el.getSize();
			int centerX = location.getX() + size.getWidth() / 2;
			int centerY = location.getY() + size.getHeight() / 2;
			
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence doubleTap = new Sequence(finger, 1);
			doubleTap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
			doubleTap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			doubleTap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			doubleTap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			doubleTap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(doubleTap));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * double tap using coordinates.
	 *
	 * @param x
	 *            the X coordinate
	 * @param y
	 *            the Y coordinate
	 * @throws Exception
	 *           
	 */
	public void doubleTapUsingCoordinates(int x, int y) throws Exception{
		try {
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence doubleTap = new Sequence(finger, 1);
			doubleTap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
			doubleTap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			doubleTap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			doubleTap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			doubleTap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(doubleTap));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * long press using web element.
	 *
	 * @param webElement
	 *            the web element 
	 * @param duration
	 *            the duration in seconds to press
	 * @throws Exception
	 *           
	 */
	public void longPressUsingElement(WebElement el, int duration) throws Exception{
		try {
			Point location = el.getLocation();
			Dimension size = el.getSize();
			int centerX = location.getX() + size.getWidth() / 2;
			int centerY = location.getY() + size.getHeight() / 2;
			
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence longPress = new Sequence(finger, 1);
			longPress.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
			longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			longPress.addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofSeconds(duration)));
			longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(longPress));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * long press using coordinates.
	 *
	 * @param x
	 *            the X coordinate
	 * @param y
	 *            the Y coordinate
	 * @param duration
	 *            the duration in seconds to press
	 * @throws Exception
	 *           
	 */
	public void longPressUsingCoordinates(int x, int y, int duration) throws Exception{
		try {
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence longPress = new Sequence(finger, 1);
			longPress.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
			longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			longPress.addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofSeconds(duration)));
			longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(longPress));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * drag and drop between two elements.
	 *
	 * @param sourceElement
	 *            the source web element to drag from
	 * @param targetElement
	 *            the target web element to drop to
	 * @throws Exception
	 *           
	 */
	public void dragAndDrop(WebElement sourceElement, WebElement targetElement) throws Exception{
		try {
			Point sourceLocation = sourceElement.getLocation();
			Dimension sourceSize = sourceElement.getSize();
			int sourceCenterX = sourceLocation.getX() + sourceSize.getWidth() / 2;
			int sourceCenterY = sourceLocation.getY() + sourceSize.getHeight() / 2;
			
			Point targetLocation = targetElement.getLocation();
			Dimension targetSize = targetElement.getSize();
			int targetCenterX = targetLocation.getX() + targetSize.getWidth() / 2;
			int targetCenterY = targetLocation.getY() + targetSize.getHeight() / 2;
			
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence dragDrop = new Sequence(finger, 1);
			dragDrop.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceCenterX, sourceCenterY));
			dragDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			dragDrop.addAction(finger.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), targetCenterX, targetCenterY));
			dragDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(dragDrop));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * drag and drop using coordinates.
	 *
	 * @param startX
	 *            the start X coordinate
	 * @param startY
	 *            the start Y coordinate
	 * @param endX
	 *            the end X coordinate
	 * @param endY
	 *            the end Y coordinate
	 * @throws Exception
	 *           
	 */
	public void dragAndDropUsingCoordinates(int startX, int startY, int endX, int endY) throws Exception{
		try {
			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence dragDrop = new Sequence(finger, 1);
			dragDrop.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
			dragDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			dragDrop.addAction(finger.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), endX, endY));
			dragDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			LocalDriverManager.getAppiumDriver().perform(Arrays.asList(dragDrop));
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * get element attribute value.
	 *
	 * @param webElement
	 *            the web element 
	 * @param attributeName
	 *            the name of the attribute
	 * @return String
	 *            the attribute value
	 * @throws Exception
	 *           
	 */
	public String getElementAttribute(WebElement el, String attributeName) throws Exception{
		try {
			return el.getAttribute(attributeName);
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * check if element is displayed.
	 *
	 * @param webElement
	 *            the web element 
	 * @return boolean
	 *            true if element is displayed
	 * @throws Exception
	 *           
	 */
	public boolean isElementDisplayed(WebElement el) throws Exception{
		try {
			return el.isDisplayed();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * check if element is enabled.
	 *
	 * @param webElement
	 *            the web element 
	 * @return boolean
	 *            true if element is enabled
	 * @throws Exception
	 *           
	 */
	public boolean isElementEnabled(WebElement el) throws Exception{
		try {
			return el.isEnabled();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * check if element is selected.
	 *
	 * @param webElement
	 *            the web element 
	 * @return boolean
	 *            true if element is selected
	 * @throws Exception
	 *           
	 */
	public boolean isElementSelected(WebElement el) throws Exception{
		try {
			return el.isSelected();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * get element size.
	 *
	 * @param webElement
	 *            the web element 
	 * @return Dimension
	 *            the size of the element
	 * @throws Exception
	 *           
	 */
	public Dimension getElementSize(WebElement el) throws Exception{
		try {
			return el.getSize();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * get element location.
	 *
	 * @param webElement
	 *            the web element 
	 * @return Point
	 *            the location of the element
	 * @throws Exception
	 *           
	 */
	public Point getElementLocation(WebElement el) throws Exception{
		try {
			return el.getLocation();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * clear text field.
	 *
	 * @param webElement
	 *            the web element 
	 * @throws Exception
	 *           
	 */
	public void clearText(WebElement el) throws Exception{
		try {
			el.clear();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}
	
	/**
	 * submit form.
	 *
	 * @param webElement
	 *            the web element (form or form element)
	 * @throws Exception
	 *           
	 */
	public void submitForm(WebElement el) throws Exception{
		try {
			el.submit();
			
		} catch (Exception exception) {
			throw new Exception(exception);
		}
	}

}