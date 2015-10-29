package pages;

import Utils.Constant;
import Utils.TestBase;

public class ChangePasswordPage extends TestBase{

    String url = Constant.baseUrl + changePasswordPath;

    public void openPage(){
        driver.get(url);
    }
}
