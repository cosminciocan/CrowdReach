package pages;

import Utils.Constant;
import Utils.TestBase;

/***
 * Created by cciocan on 22-Oct-15.
 */
public class ChangePasswordPage extends TestBase{

    String url = Constant.baseUrl + changePasswordPath;





    public void openPage(){
        driver.get(url);
    }
}
