# Appium Airbnb Android Test

Simple automation testing Maven project on Airbnb Android with Appium framework.

## Requirements

- [Android SDK](https://developer.android.com/studio?gclid=CjwKCAjwtdeFBhBAEiwAKOIy51MuxH4XQhPduryf0JwNecFjMFBcg85SJR7_HJIrK9_yUeg_tcfWyRoCCIYQAvD_BwE&gclsrc=aw.ds#downloads)
- [Appium Desktop App](https://github.com/appium/appium-desktop/releases/tag/v1.21.0)
- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk16-downloads.html)

## Usage

### 1. Connect to own Android device
- Connect an Android device to your machine and allow developer mode.
- Install [Airbnb app](https://play.google.com/store/apps/details?id=com.airbnb.android&hl=en&gl=US) into this device 
- Get your device's information and replace it in ```src/test/java/tests/BaseClass.java``` as below
```bash
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "ANDROID_VERSION");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "DEVICE_MODEL_NAME");
            caps.setCapability(MobileCapabilityType.UDID, "UDID");
```
- To get ```UDID```, run the following command in cmd:
```bash
adb devices
```
### 2. Start Appium server
- Open Appium Desktop App
- Press ```Start Server v1.21.o```
- Go to ```File>New Session Window...```. A new window will pop out and wait for a few moments to load the content.
- Once loaded, paste the following in the ```JSON Representation``` section.
```bash
{
  "deviceName": "UDID",
  "platformName": "android",
  "appPackage": "com.airbnb.android",
  "appActivity": ".feat.homescreen.HomeActivity",
  "noReset": true
}
```
- Press ```Start Session``` at the bottom right corner.
- The Appium server is now connected to your Android device and will automatically opens up the installed Airbnb app.

### 3. Run the tests
- Go to ```src/test/java/tests/Tests.java``` and run this file in your IDE.

## License
[MIT](https://choosealicense.com/licenses/mit/)
