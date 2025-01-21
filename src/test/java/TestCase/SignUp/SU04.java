package TestCase.SignUp;

import static SetUp.Function.*;

public class SU04 {
    public static void main(String[] args) {
        set_spesific_testcase("Register password and password confirmation fields match");
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
        set_text("txtRegistPass","cobain");
        set_text("txtRegistPassCheck","cobain");
        wait_for_seconds(2);
        screenshot();
        click("btnContinue");
        debug();
        assert_equals("txtVerify", "Verify email address");
        screenshot();
        quit_driver();
    }
}
