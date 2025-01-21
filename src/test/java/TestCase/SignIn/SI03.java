package TestCase.SignIn;

import static SetUp.Function.*;

public class SI03 {
    public static void main(String[] args) {
        set_spesific_testcase("SI03_Sign in with email address in uppercase");
        start_chromedriver();
        go_to_url("https://www.amazon.com/");
        debug();
        wait_until_element_exists("btnLogoAmazon");
        screenshot();
        click("txtHiSignIn");
        wait_until_element_exists("txtRegistEmail");
        screenshot();
        set_text("txtRegistEmail","NISSAKARIMA@GMAIL.COM");
        screenshot();
        click("btnContinue");
        wait_until_element_exists("txtRegistPass");
        screenshot();
        set_text("txtRegistPass","kitacoba");
        screenshot();
        click("btnSignIn");
        screenshot();
        quit_driver();
    }
}
