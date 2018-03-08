package com.disney.cast.platform.vacationplanner.ui.common;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.String.format;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.By.xpath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.disney.automation.webframework.pageobject.PageElement;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;

/**
 * WebElement Wrapper that features method for presence
 *
 * @author erick.ricardez
 */
public final class NWElement extends PageElement {
    private static final int DEFAULT_TIMEOUT = 3500;
    private static final int DEFAULT_POLLING = 500;
    private static final int DEFAULT_INDEX = -1;
    private Supplier<Optional<WebElement>> nwoElement;
    private final By originLocator;
    private final NWElement parentNWElement;
    private final int possibleIndex;
    private final Map<String, NWElement> struct = new HashMap<String, NWElement>();
    private final Map<String, List<NWElement>> structsList = new HashMap<>();
    private final Map<String, ElementListsHandler> elementLists = new HashMap<>();

    public NWElement(By locator) {
        this(locator, DEFAULT_TIMEOUT, DEFAULT_POLLING);
    }

    public NWElement(By locator, long timeout, long polling) {
        this(DEFAULT_INDEX, locator, timeout, polling);
    }

    private NWElement(NWElement parentNWElement, final By locator, long timeout, long polling) {
        this(parentNWElement, DEFAULT_INDEX, locator, timeout, polling);
    }

    public NWElement(int atIndex, By locator, long timeout, long polling) {
        super(locator);
        this.parentNWElement = null;
        this.possibleIndex = atIndex;
        this.originLocator = locator;
        setNWElementConfiguration(timeout, polling);
    }

    private NWElement(NWElement parentNWElement, int atIndex, By locator, long timeout, long polling) {
        super(locator);
        this.parentNWElement = parentNWElement;
        this.originLocator = locator;
        this.possibleIndex = atIndex;
        setNWElementConfiguration(timeout, polling);
    }

    private NWElement() {
        super(name("void"));
        this.possibleIndex = DEFAULT_INDEX;
        this.parentNWElement = null;
        this.originLocator = null;
        this.nwoElement = () -> Optional.absent();
    }

    public static NWElement findNWElement(By locator) {
        return new NWElement(locator);
    }

    public static NWElement findNWElement(By locator, long timeoutMilliseconds, long pollingMilliseconds) {
        return new NWElement(locator, timeoutMilliseconds, pollingMilliseconds);
    }

    public static NWElement findNWElement(String keyWithLocator) {
        return new NWElement(getLocatorFromTextKey(keyWithLocator));
    }

    public static NWElement findNWElement(String keyWithLocator, long timeout, long polling) {
        return new NWElement(getLocatorFromTextKey(keyWithLocator), timeout, polling);
    }

    public static NWElement findNWElementById(String id) {
        return new NWElement(id(id));
    }

    public static NWElement findNWElementByName(String name) {
        return new NWElement(name(name));
    }

    public static NWElement findNWElementByCssSelector(String cssSelector) {
        return new NWElement(cssSelector(cssSelector));
    }

    public static NWElement findNWElementByXpath(String xpath) {
        return new NWElement(xpath(xpath));
    }

    public static NWElement findNWElementByTagName(String tagName) {
        return new NWElement(tagName(tagName));
    }

    public static List<NWElement> findNWElements(WebDriver driver, By locator) {
        return findNWElements(driver, locator, 1);
    }

    public static List<NWElement> findNWElements(WebDriver driver, By locator, int greaterThanOrEqualsToListSize) {
        return findNWElements(driver, locator, greaterThanOrEqualsToListSize, DEFAULT_TIMEOUT);
    }

    public static List<NWElement> findNWElements(WebDriver driver, By locator, int greaterThanOrEqualsToListSize,
            long timeout) {
        if (greaterThanOrEqualsToListSize > 0) {
            waitForCondition(() -> driver.findElements(locator).size() >= greaterThanOrEqualsToListSize, timeout);
        }
        List<WebElement> elements = driver.findElements(locator);
        List<NWElement> nwelements = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            nwelements.add(new NWElement(i, locator, DEFAULT_TIMEOUT, DEFAULT_POLLING));
        }
        return nwelements;
    }

    public boolean successfulClick() {
        if (isPresent() && isDisplayed() && isEnabled()) {
            click();
            return TRUE;
        }
        return FALSE;
    }

    public boolean successfulSendKeys(String stringInput) {
        if (isPresent()) {
            clear();
            sendKeys(stringInput);
            return TRUE;
        }
        return FALSE;
    }

    public boolean isPresentAndDisplayed() {
        return waitForCondition(() -> isPresent() && isDisplayed(), 5000);
    }

    public boolean hasCompleteVisibility() {
        return waitForCondition(() -> isPresent() && isDisplayed() && isEnabled(), 5000);
    }

    public boolean successfulSelectOption(String option) {
        if (isPresent() && "select".equalsIgnoreCase(getTagName())) {
            select(getWebElement(), option);
            return TRUE;
        }
        return FALSE;
    }

    /**
     * Method that confirms that the element was found by the locator at the moment of the NWElement
     * creation.
     *
     * @return true if the element was found in the DOM.
     */
    public boolean isPresent() {
        return nwoElement.get().isPresent();
    }

    /**
     * Method that returns the WebElement wrapped at the current NWElement.
     *
     * @return WebElement that is contained in the current NWElement.
     */
    public WebElement getWebElement() {
        return nwoElement.get().get();
    }

    /**
     * Method that returns the locator that was specified at the moment of creating the NWElement
     * after having been found in the DOM.
     *
     * @return By locator
     */
    public By getInnerLocator() {
        return originLocator;
    }

    /**
     * Method that returns the locator String
     *
     * @return locator String
     */
    public String getLocatorString() {
        String loc = originLocator.toString();
        return loc.substring(loc.indexOf(":") + 1).trim();
    }

    /**
     * Method that gets the NWElement parent if any. In case this is the root the parent element
     * will be absent.
     *
     * @return NWElement is the parent node of the current element if there's any.
     */
    public NWElement getParentNWElement() {
        if (null == parentNWElement) {
            return new NWElement();
        } else {
            return parentNWElement;
        }
    }

    /**
     * Method that appends a NWElement by passing a locator of a sub element and a <B>name</B> to
     * retrieve the NWElement.
     *
     * @param name
     * @param locator
     * @return NWElement The element just appended
     * @see getChild
     */
    public NWElement appendChildLocator(String name, By locator) {
        struct.put(name, new NWElement(this, locator, DEFAULT_TIMEOUT, DEFAULT_POLLING));
        return struct.get(name);
    }

    /**
     * Method that returns a sub NWElement of the current NWElement
     *
     * @param locator
     *            used to find the sub element at the current element's context
     * @return NWElement found by the locator passed
     */
    public NWElement findSubNWElement(By locator) {
        return new NWElement(this, locator, DEFAULT_TIMEOUT, DEFAULT_POLLING);
    }

    /**
     * Method that appends a NWElement by passing a locator of a sub element and a <B>name</B> to
     * retrieve the NWElement.
     *
     * @param name
     * @param locator
     * @return
     */
    public NWElement appendChildLocator(Object name, By locator) {
        return appendChildLocator(name.toString(), locator);
    }

    /**
     * Method that appends a NWElement by passing a string with a suffix and locator of a sub
     * element and a <B>name</B> to retrieve the NWElement. The suffixes allowed must be:
     * '<B>i:</B>' for id, '<B>n:</B>' for name, '<B>x:</B>' for xpath, and '<B>t:</B>' for tagName
     *
     * @param name
     * @param keyWithLocator
     * @return NWElement The element just appended
     */
    public NWElement appendChildLocator(String name, String keyWithLocator) {
        return appendChildLocator(name, getLocatorFromTextKey(keyWithLocator));
    }

    /**
     * Method that retrieves the child node appended previously with the method <B>
     * appendChildLocator </B>
     *
     * @param name
     *            used to retrieve the element
     * @return NWElement that was retrieved by name
     */
    public NWElement getChild(String name) {
        return struct.get(name) != null ? struct.get(name) : new NWElement();
    }

    /**
     * Method that retrieves the child node appended previously with the method <B>
     * appendChildLocator </B>
     *
     * @param name
     *            used to retrieve the element
     * @return NWElement that was retrieved by name
     */
    public NWElement getChild(Object name) {
        return getChild(name.toString());
    }

    /**
     * Method that retrieves the NWElement children nodes from the current NWElement after having
     * assigned the list with a name.
     *
     * @param listName
     *            the key to retrieve the List of NWElements
     * @return List<NWElement>
     */
    public List<NWElement> getChildrenList(String listName) {
        return structsList.get(listName);
    }

    /**
     * Method that retrieves the NWElement children nodes from the current NWElement after having
     * assigned the list with a name.
     *
     * @param listName
     *            the key to retrieve the list of NWElements. It is adviceable to use enum types for
     *            the sake of clarity.
     * @return List<NWElement>
     */
    public List<NWElement> getChildrenList(Object listName) {
        return getChildrenList(listName.toString());
    }

    /**
     * Method used to append a list of sub NWElements at the current NWElement
     *
     * @param name
     *            assigned to identify the appended list
     * @param locator
     *            locator at which the sub elements are found
     * @return the list of NWElements
     */
    public List<NWElement> appendChildrenLocator(String name, By locator) {
        List<NWElement> nwelements = findSubNWElements(locator);
        structsList.put(name, nwelements);
        return nwelements;
    }

    /**
     * Method used to append a list of sub NWElements at the current NWElement
     *
     * @param name
     *            assigned to identify the appended list
     * @param locator
     *            locator at which the sub elements are found
     * @return the list of NWElements
     */
    public List<NWElement> appendChildrenLocator(Object name, By locator) {
        return appendChildrenLocator(name.toString(), locator);
    }

    /**
     * Method that return a list of NWElements found at the current NWElement Caller by locator
     *
     * @param locator
     *            used to retrieve sub elements of the current NWElement
     * @return list of NWElements found as sub elements of current element caller
     */
    public List<NWElement> findSubNWElements(By locator) {
        return findSubNWElements(locator, 0);
    }

    /**
     * Method that return a list of NWElements found at the current NWElement Caller by locator
     *
     * @param locator
     *            used to retrieve sub elements of the current NWElement
     * @return list of NWElements found as sub elements of current element caller
     */
    public List<NWElement> findSubNWElements(By locator, int greaterThanOrEqualsToListSize) {
        if (greaterThanOrEqualsToListSize > 0) {
            expectedElementsRetrieved(this.findElements(locator), greaterThanOrEqualsToListSize, DEFAULT_TIMEOUT);
        }
        List<NWElement> nwelements = new ArrayList<>();
        int listSize = this.findElements(locator).size();
        for (int i = 0; i < listSize; i++) {
            nwelements.add(new NWElement(this, i, locator, DEFAULT_TIMEOUT, DEFAULT_POLLING));
        }
        return nwelements;
    }

    /**
     * Method that retrieves the text in a web element after waiting for an expected text a time
     * defined by the <B> timeout </B> passed. This is used for dynamic elements that the text
     * contained is changed with a little delay
     *
     * @param text
     * @param timeout
     * @return String text that is displayed after waiting or after having matched the expected
     *         text.
     */
    public String getTextAfterWaitingTextToChange(String text, long timeout) {
        waitForCondition(() -> !getText().equals(text), timeout);
        return getText();
    }

    /**
     * Method that confirms if an expected text is present after waiting a time span specified by
     * the <B> timeout </B> or after being matched regardless the timeout was not happened
     *
     * @param text
     * @param timeout
     * @return
     */
    public boolean isTextEqualsAfterWaiting(String text, long timeout) {
        waitForCondition(() -> !getText().equals(text), timeout);
        return getText().equals(text);
    }

    private static boolean expectedElementsRetrieved(List<WebElement> elements,
            int greaterThanOrEqualstoListSizeExpected,
            long timeout) {
        try {
            waitForListContents(elements, timeout)
                    .until(new Predicate<List<WebElement>>() {
                        @Override
                        public boolean apply(List<WebElement> elements) {
                            return elements.size() >= greaterThanOrEqualstoListSizeExpected;
                        }
                    });
        } catch (TimeoutException te) {
        }
        return elements.size() == greaterThanOrEqualstoListSizeExpected;
    }

    private static FluentWait<List<WebElement>> waitForListContents(List<WebElement> elements, long timeout) {
        return new FluentWait<List<WebElement>>(elements)
                .pollingEvery(DEFAULT_POLLING, MILLISECONDS)
                .withTimeout(timeout, MILLISECONDS)
                .ignoring(StaleElementReferenceException.class);
    }

    /**
     * Method that retrieves the list created by calling previously the method
     * putElementsListByLocator
     *
     * @see putElementsListByLocator
     * @param listName
     * @param index
     * @return
     */
    public WebElement getElementAtNamedList(String listName, int index) {
        try {
            elementLists.get(listName).list.get(index).getTagName();
        } catch (StaleElementReferenceException sere) {
            if (!putElementsListByLocator(listName, elementLists.get(listName).locator)) {
                throw new RuntimeException(format("Elements at list %s are not available anymore", listName));
            }
        }
        return elementLists.get(listName).list.get(index);
    }

    public WebElement getElementAtNamedList(Object listName, int index) {
        return getElementAtNamedList(listName.toString(), index);
    }

    /**
     * Method that returns the number of elements contained in the named List
     *
     * @param listName
     *            used to retrieve the list added with <B>putElementsListByLocator</B>
     * @return number of elements in named list
     * @see putElementsListByLocator
     */
    public int getNamedListSize(String listName) {
        return elementLists.get(listName).list.size();
    }

    /**
     * Method that returns the number of elements contained in the named List
     *
     * @param listName
     *            used to retrieve the list added with <B>putElementsListByLocator</B>
     * @return number of elements in named list
     * @see putElementsListByLocator
     */
    public int getNamedListSize(Object listName) {
        return getNamedListSize(listName.toString());
    }

    /**
     * Method that creates a list of WebElements by passing the corresponding locator and a name
     * assigned to retrieve this list.
     *
     * @param listName
     *            Used to identify the list created with the web elements related to the locator
     * @param elementsLocator
     *            Locator that retrieves a list of WebElements
     * @return true if elements were found and false if the list is empty
     */
    public boolean putElementsListByLocator(String listName, By elementsLocator) {
        try {
            new FluentWait<NWElement>(this)
                    .pollingEvery(DEFAULT_POLLING, MILLISECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .withTimeout(DEFAULT_TIMEOUT,
                            MILLISECONDS)
                    .until(new Predicate<NWElement>() {
                        @Override
                        public boolean apply(NWElement nwelement) {
                            return !nwelement.findElements(elementsLocator).isEmpty();
                        }
                    });
        } catch (TimeoutException te) {
        }
        elementLists.put(listName,
                new ElementListsHandler(elementsLocator, this.findElements(elementsLocator)));
        return !elementLists.get(listName).list.isEmpty();
    }

    public boolean putElementsListByLocator(Object listName, By elementsLocator) {
        return putElementsListByLocator(listName.toString(), elementsLocator);
    }

    public void changeTimeSettings(long timeout, long polling) {
        setNWElementConfiguration(timeout, polling);
    }

    private void setNWElementConfiguration(long timeout, long polling) {
        if (0 > possibleIndex) {
            if (getParentNWElement().isPresent()) {
                nwoElement = () -> getCoreElementFromParent(timeout, polling);
            } else {
                nwoElement = () -> getCoreElement(timeout, polling);
            }
        } else {
            if (getParentNWElement().isPresent()) {
                nwoElement = () -> getIndexedCoreElementFromParent(timeout, polling);
            } else {
                nwoElement = () -> getIndexedCoreElement(timeout, polling);
            }
        }
    }

    private final Optional<WebElement> getCoreElementFromParent(long timeout, long polling) {
        if (waitForCondition(() -> !getParentNWElement().findElements(getInnerLocator()).isEmpty(), timeout,
                polling)) {
            return Optional.of(getParentNWElement().findElement(getInnerLocator()));
        }
        return Optional.absent();
    }

    private final Optional<WebElement> getCoreElement(long timeout, long polling) {
        if (waitForCondition(() -> !getDriver().findElements(getInnerLocator()).isEmpty(), timeout, polling)) {
            return Optional.of(getDriver().findElement(getInnerLocator()));
        }
        return Optional.absent();
    }

    private final Optional<WebElement> getIndexedCoreElement(long timeout, long polling) {
        if (waitForCondition(() -> getDriver().findElements(getInnerLocator()).size() > possibleIndex, timeout,
                polling)) {
            return Optional.of(getDriver().findElements(getInnerLocator()).get(possibleIndex));
        }
        return Optional.absent();
    }

    private final Optional<WebElement> getIndexedCoreElementFromParent(long timeout, long polling) {
        if (waitForCondition(() -> getParentNWElement().findElements(getInnerLocator()).size() > possibleIndex,
                timeout, polling)) {
            return Optional.of(getParentNWElement().findElements(getInnerLocator()).get(possibleIndex));
        }
        return Optional.absent();
    }

    /**
     * Method that returns the text contained in the element. If the element is not present it
     * returns an empty string reassuring that there won't be any exception thrown
     *
     * @return text if present in the element, other wise, an empty string is returned
     */
    public String assuredGetText() {
        return isPresent() ? getText() : "";
    }

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return nwoElement.get().get().getScreenshotAs(target);
    }

    public void click() {
        nwoElement.get().get().click();
    }

    public void submit() {
        nwoElement.get().get().submit();
    }

    public void sendKeys(CharSequence... keysToSend) {
        nwoElement.get().get().sendKeys(keysToSend);
    }

    public void clear() {
        nwoElement.get().get().clear();
    }

    public String getTagName() {
        return nwoElement.get().get().getTagName();
    }

    public String getAttribute(String name) {
        return nwoElement.get().get().getAttribute(name);
    }

    public boolean isSelected() {
        return nwoElement.get().get().isSelected();
    }

    public boolean isEnabled() {
        return nwoElement.get().get().isEnabled();
    }

    public String getText() {
        return nwoElement.get().get().getText();
    }

    public List<WebElement> findElements(By by) {
        return nwoElement.get().get().findElements(by);
    }

    public WebElement findElement(By by) {
        return nwoElement.get().get().findElement(by);
    }

    public boolean isDisplayed() {
        return nwoElement.get().get().isDisplayed();
    }

    public Point getLocation() {
        return nwoElement.get().get().getLocation();
    }

    public Dimension getSize() {
        return nwoElement.get().get().getSize();
    }

    public Rectangle getRect() {
        return nwoElement.get().get().getRect();
    }

    public String getCssValue(String propertyName) {
        return nwoElement.get().get().getCssValue(propertyName);
    }

    public static boolean waitForCondition(GenericCondition elementState) {
        return waitForCondition(elementState, DEFAULT_TIMEOUT, DEFAULT_POLLING);
    }

    public static boolean waitForCondition(GenericCondition elementState, long timeout) {
        return waitForCondition(elementState, timeout, DEFAULT_POLLING);
    }

    public static boolean waitForCondition(GenericCondition condition, long timeout, long polling) {
        try {
            waitFor(condition, timeout, DEFAULT_POLLING)
                    .until(new Predicate<NWElement.GenericCondition>() {
                        @Override
                        public boolean apply(GenericCondition state) {
                            return state.conditionIsTrue();
                        }
                    });
        } catch (TimeoutException te) {
        }
        return condition.conditionIsTrue();
    }

    private static FluentWait<GenericCondition> waitFor(GenericCondition state, long timeout, long polling) {
        return new FluentWait<GenericCondition>(state)
                .pollingEvery(polling, MILLISECONDS)
                .withTimeout(timeout, MILLISECONDS)
                .ignoring(StaleElementReferenceException.class);
    }

    public static By getLocatorFromTextKey(String keyWithLocator) {
        if (!keyWithLocator.substring(0, 2).matches("(i|n|c|t|x):")) {
            throw new RuntimeException(
                    "The string passed must contained a valid prefix like: 'i:' for id, 'n:' for name, 'c:' for cssSelector, 't:' for tagName or 'x:' for xpath");
        }
        Locator locator = Locator.getLocatorFromKey(keyWithLocator.substring(0, 1));
        String locatorString = keyWithLocator.substring(2, keyWithLocator.length());
        switch (locator) {
            case ID:
                return id(locatorString);
            case NAME:
                return name(locatorString);
            case CSS:
                return cssSelector(locatorString);
            case XPATH:
                return xpath(locatorString);
            case TAGNAME:
                return tagName(locatorString);
        }
        throw new RuntimeException("Unknown Type");
    }

    private enum Locator {
        ID("i"), NAME("n"), CSS("c"), XPATH("x"), TAGNAME("t");
        private final String key;

        private Locator(String key) {
            this.key = key;
        }

        public static Locator getLocatorFromKey(String key) {
            for (Locator l : Locator.values()) {
                if (key.equals(l.key)) {
                    return l;
                }
            }
            throw new RuntimeException("Invalid key. Locator not found.");
        }
    }

    public WebDriver getWebDriver() {
        return getWebDriver();
    }

    private static final class ElementListsHandler {
        private final By locator;
        private final List<WebElement> list;

        public ElementListsHandler(By locator, List<WebElement> list) {
            this.locator = locator;
            this.list = list;
        }
    }

    public interface GenericCondition {
        boolean conditionIsTrue();
    }
}