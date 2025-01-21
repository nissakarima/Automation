package TestCase.SignUp;

import static SetUp.Function.*;
import static SetUp.Function.quit_driver;

public class SU07 {
    public static void main(String[] args) {
        set_spesific_testcase("Register password and password confirmation fields match but less than 6 character");
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
        set_text("txtRegistYourName","Nisa");
        set_text("txtRegistEmail","Nisa@email.co.id");
        set_text("txtRegistPass","coba");
        set_text("txtRegistPassCheck","coba");
        wait_for_seconds(2);
        screenshot();
        click("btnContinue");
        assert_equals("txtAuthPassInvalid", "Minimum 6 characters required");
        screenshot();
        quit_driver();
    }
}
