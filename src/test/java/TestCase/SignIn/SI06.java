package TestCase.SignIn;

import static SetUp.Function.*;

public class SI06 {
    public static void main(String[] args) {
        set_spesific_testcase("SI06_Sign in with incorrect password");
        start_chromedriver();
        go_to_url("https://www.amazon.com/");
        debug();
        wait_until_element_exists("btnLogoAmazon");
        screenshot();
        click("txtHiSignIn");
        wait_until_element_exists("txtRegistEmail");
        screenshot();
        set_text("txtRegistEmail","nissakarima@gmail.com");
        screenshot();
        click("btnContinue");
        wait_until_element_exists("txtRegistPass");
        screenshot();
        set_text("txtRegistPass","cobasalah");
        screenshot();
        click("btnSignIn");
        debug();
        assert_equals("txtAuthErrorMessageBox", "Your password is incorrect");
        screenshot();
        quit_driver();
    }
}
