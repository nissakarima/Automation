package TestCase.SignIn;

import static SetUp.Function.*;

public class SI07 {
    public static void main(String[] args) {
        set_spesific_testcase("SI07_Sign in with empty fields");
        start_chromedriver();
        go_to_url("https://www.amazon.com/");
        debug();
        wait_until_element_exists("btnLogoAmazon");
        screenshot();
        click("txtHiSignIn");
        wait_until_element_exists("txtRegistEmail");
        screenshot();
        click("btnContinue");
        assert_equals("txtAuthEmailMissing","Enter your email or mobile phone number");
        screenshot();
        quit_driver();
    }
}
