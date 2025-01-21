package TestCase.SignUp;

import static SetUp.Function.*;

public class SU02 {
    public static void main(String[] args) {
        set_spesific_testcase("Register with valid details with mobile number");
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
        set_text("txtRegistEmail","87825896321");
        set_text("txtRegistPass","cobain");
        set_text("txtRegistPassCheck","cobain");
        click("btnCountryCode");
        wait_for_seconds(2);
        click("strCountryCode");
        wait_for_seconds(2);
        screenshot();
        click("btnContinue");
        debug();
        assert_equals("txtVerify", "Verify mobile number");
        screenshot();
        quit_driver();
    }
}
