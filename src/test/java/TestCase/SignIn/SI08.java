package TestCase.SignIn;

import static SetUp.Function.*;

public class SI08 {
    public static void main(String[] args) {
        set_spesific_testcase("SI08_Sign in with invalid email address format");
        start_chromedriver();
        go_to_url("https://www.amazon.com/");
        debug();
        wait_until_element_exists("btnLogoAmazon");
        screenshot();
        click("txtHiSignIn");
        wait_until_element_exists("txtRegistEmail");
        screenshot();
        set_text("txtRegistEmail","nissakarima@gmail@com");
        screenshot();
        click("btnContinue");
        assert_equals("txtAuthEmailInvalid","Wrong or Invalid email address or mobile phone number. Please correct and try again.");
        screenshot();
        quit_driver();
    }
}
