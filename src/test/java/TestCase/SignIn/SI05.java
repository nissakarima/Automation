package TestCase.SignIn;

import static SetUp.Function.*;

public class SI05 {
    public static void main(String[] args) {
        set_spesific_testcase("SI05_Sign in with unregistered email address");
        start_chromedriver();
        go_to_url("https://www.amazon.com/");
        debug();
        wait_until_element_exists("btnLogoAmazon");
        screenshot();
        click("txtHiSignIn");
        wait_until_element_exists("txtRegistEmail");
        screenshot();
        set_text("txtRegistEmail","nisak@yahoo.com");
        screenshot();
        click("btnContinue");
        assert_equals("txtAuthErrorMessageBox","We cannot find an account with that email address");
        screenshot();
        quit_driver();
    }
}
