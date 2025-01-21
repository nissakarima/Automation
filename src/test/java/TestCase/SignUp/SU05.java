package TestCase.SignUp;

import static SetUp.Function.*;
import static SetUp.Function.screenshot;

public class SU05 {
    public static void main(String[] args) {
        set_spesific_testcase("Register with empty fields");
        start_chromedriver();
        go_to_url("https://www.amazon.com/");
        debug();
        wait_until_element_exists("btnLogoAmazon");
        screenshot();
        hover("txtHiSignIn");
        wait_for_seconds(2);
        screenshot();
        click("txtStartHere");
        wait_until_element_exists("txtRegistYourName");
        screenshot();
        click("btnContinue");
        assert_equals("txtNameContextMessage","Enter your name");
        assert_equals("txtEmailContextMessage", "Enter your email or mobile phone number");
        assert_equals("txtPassContextMessage","Minimum 6 characters required");
        screenshot();
        quit_driver();
    }
}
