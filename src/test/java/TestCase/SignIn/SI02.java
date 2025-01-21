package TestCase.SignIn;

import static SetUp.Function.*;

public class SI02 {
    public static void main(String[] args) {
        set_spesific_testcase("SI02_Sign in with mobile number");
        start_chromedriver();
        go_to_url("https://www.amazon.com/");
        debug();
        wait_until_element_exists("btnLogoAmazon");
        screenshot();
        click("txtHiSignIn");
        wait_until_element_exists("txtRegistEmail");
        screenshot();
        set_text("txtRegistEmail","087777405299");
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
