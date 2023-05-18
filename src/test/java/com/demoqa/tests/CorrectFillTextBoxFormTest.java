package com.demoqa.tests;


import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.*;

import static com.demoqa.allure.TagConstants.REGRESS;
import static com.demoqa.allure.TagConstants.TEXT_BOX;
import static com.demoqa.test_data.TestData.*;

@Tags({@Tag(REGRESS), @Tag(TEXT_BOX)})
public class CorrectFillTextBoxFormTest extends BaseTest {

    private TextBoxPage textBoxPage = new TextBoxPage();

    private String firstName;
    private String lastName;
    private String email;
    private String currentAddress;
    private String permanentAddress;

    @BeforeEach
    public void precondition() {
        firstName = getFirstName();
        lastName = getLastName();
        email = getEmail();
        currentAddress = getAddress();
        permanentAddress = getAddress();

        textBoxPage.openPageWithClosingBottomAds();
    }

    @DisplayName("Заполнение формы textBox корректными данными")
    @Test
    public void successfulFillForm() {
        textBoxPage.setValueInInput("Full Name", firstName + " " + lastName)
                .setValueInInput("Email", email)
                .setValueInTextarea("Current Address", currentAddress)
                .setValueInTextarea("Permanent Address", permanentAddress)
                .clickBtn("Submit");

        textBoxPage.checkResult("Name:", firstName + " " + lastName)
                .checkResult("Email:", email)
                .checkResult("Current Address :", currentAddress)
                .checkResult("Permananet Address :", permanentAddress);

    }
}