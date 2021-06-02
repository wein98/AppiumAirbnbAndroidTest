package tests;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Tests extends BaseClass {
    @Test
    public void testNavigation() {
        // navigates to wishlists tab
        driver.findElementById("com.airbnb.android:id/2131430671").click();

        String tabTitle = "Wishlists";

        Assert.assertEquals(tabTitle, driver.findElementById("com.airbnb.android:id/title").getText());

        System.out.println("Completed navigation test");
    }

    @Test
    public void testSearch() {
        // go to explore tab
        driver.findElementById("com.airbnb.android:id/2131430657").click();

        // click on the search element
        driver.findElementById("com.airbnb.android:id/2131430591").click();
        driver.findElementById("com.airbnb.android:id/2131430619").sendKeys("melaka");

        List<WebElement> elements = (List<WebElement>) driver.findElementById("com.airbnb.android:id/recycler_view").findElements(By.className("android.widget.FrameLayout"));

        if (elements.size() > 0) {
            elements.get(1).click();
        }

        System.out.println("Completed search test");

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
    }

    @Test
    public void testFillUpForm() {
        // go to login tab
        driver.findElementById("com.airbnb.android:id/2131430653").click();

        // taps log in button
        driver.findElementById("com.airbnb.android:id/2131429258").click();

        // click drop down option for country/region
        driver.findElementById("com.airbnb.android:id/2131428067").click();

        List<WebElement> mobileElement = (List<WebElement>) driver.findElements(By.className("android.widget.CheckedTextView"));
        // choose Afghanistan (+93)
        mobileElement.get(1).click();

        // phone number edittext
        MobileElement phoneField = (MobileElement) driver.findElementById("com.airbnb.android:id/2131428770");
        phoneField.sendKeys("123456789a");

        boolean isErrorShown = false;

        // test non-numeric input shows error msg
        if (driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")
                .isDisplayed()) {
            isErrorShown = true;
        }

        Assert.assertEquals(true, isErrorShown);

        // test numeric input doesn't shows error msg
        phoneField.sendKeys("1234567890");

        if (driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]")
                .isDisplayed()) {
            isErrorShown = false;
        }

        Assert.assertEquals(false, isErrorShown);

        System.out.println("Completed fill up form test");
    }
}
