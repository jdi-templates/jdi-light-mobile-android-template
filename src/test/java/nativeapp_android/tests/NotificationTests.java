package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.common.MobileKeyboard;
import com.epam.jdi.light.mobile.elements.composite.AndroidScreen;
import io.appium.java_client.android.nativekey.AndroidKey;
import nativeapp.android.apidemos.NotifyPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.mobile.elements.common.MobileDevice.sendSMS;
import static nativeapp.android.apidemos.NotifyPage.appIcon;
import static nativeapp.android.apidemos.NotifyPage.appName;
import static nativeapp.android.apidemos.NotifyPage.clearAllButton;
import static nativeapp.android.apidemos.NotifyPage.markAsRead;
import static nativeapp.android.apidemos.NotifyPage.messageNames;
import static nativeapp.android.apidemos.NotifyPage.messageTexts;
import static nativeapp.android.apidemos.NotifyPage.notificationMessagingContent;
import static nativeapp.android.apidemos.NotifyPage.notificationName;
import static nativeapp.android.apidemos.NotifyPage.notificationPanel;
import static nativeapp.android.apidemos.NotifyPage.reply;
import static nativeapp.android.apidemos.NotifyPage.send;
import static nativeapp.android.apidemos.NotifyPage.timeStamp;

public class NotificationTests extends ApiDemosTestInit {

    public static final String NUMBER = "333-4545";
    public static final String MESSAGES = "Messages";
    public static final String MESSAGE = "Hello From Tests";
    public static final String TEST_MESSAGE = "a";
    public static final String NOW = "now";
    public static final String YOU = "You";

    @BeforeMethod
    public void initSteps() {
        sendSMS(NUMBER, MESSAGE);
        AndroidScreen.openNotificationPanel();
        NotifyPage.notificationPanel.waitFor(5);
    }

    @Test
    public void contentInformationTest() {
        appIcon.is().displayed();
        appName.has().text(MESSAGES);
        timeStamp.has().text(NOW);
        notificationMessagingContent.has().text(MESSAGE);
        notificationName.has().text(NUMBER);
    }

    @Test
    public void actionsMarkAsReadTest() {
        notificationPanel.is().displayed();
        markAsRead.tap();
        NotifyPage.notificationMessagingContent.is().disappear();
    }

    @Test
    public void actionsReplyTest() {
        notificationPanel.is().displayed();
        reply.tap();
        MobileKeyboard.pressKey(AndroidKey.A);
        send.tap();
        messageNames.get(1).is().text(NUMBER);
        messageNames.get(2).is().text(YOU);
        messageTexts.get(1).is().text(MESSAGE);
        messageTexts.get(2).is().text(TEST_MESSAGE);
    }

    @AfterMethod
    public void afterMethodCloseStatusBar() {
        if (clearAllButton.isDisplayed()) clearAllButton.tap();
        if (markAsRead.isDisplayed()) markAsRead.tap();
        AndroidScreen.closeNotificationPanel();
    }
}