package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {
    AndroidDriver driver;

    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "HUAWEI P10");
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.UDID, "7EX7N17323011027");
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);

            URL url = new URL ("http://127.0.0.1:4723/wd/hub");

            driver = new AndroidDriver<MobileElement>(url, caps);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @AfterTest
    public void teardown() {

    }
}
