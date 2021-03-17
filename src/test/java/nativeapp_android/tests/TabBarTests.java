package nativeapp_android.tests;

import com.epam.jdi.light.mobile.elements.composite.MobileScreen;
import nativeapp.android.apidemos.views.ViewsPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static nativeapp.android.apidemos.IndexPage.viewsPage;
import static nativeapp.android.apidemos.views.TabsPage.scrollableButton;
import static nativeapp.android.apidemos.views.TabsPage.tabBar;
import static nativeapp.android.apidemos.views.TabsPage.tabContent;
import static nativeapp.android.apidemos.views.ViewsPage.tabsPage;

public class TabBarTests extends ApiDemosTestInit {

    @BeforeMethod
    public void initSteps() {
        viewsPage.click();
        MobileScreen.scrollToElementInList(ViewsPage.tabsPage);
        tabsPage.click();
        scrollableButton.click();
    }

    @Test
    public void clickTabBarByNumberTest(){
        tabBar.selectByNumber(2);
        tabBar.is().selected("TAB 2");
        tabContent.is().text("Content for tab with tag Tab 2");
    }

    @Test
    public void clickTabBarByTabNameTest(){
        tabBar.selectByText("TAB 2");
        tabBar.is().selected("TAB 2");
        tabContent.is().text("Content for tab with tag Tab 2");
    }
}
