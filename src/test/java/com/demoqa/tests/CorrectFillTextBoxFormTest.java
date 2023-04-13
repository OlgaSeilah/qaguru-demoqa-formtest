package com.demoqa.tests;


import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class CorrectFillTextBoxFormTest extends BaseTest {

    private TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    public void successfulFillForm() {
        String firstName = "Name";
        String lastName = "Secondname";
        String email = "qwerty@qqq.ru";
        String currentAddress = "55, Melikishvili Street";
        String permanentAddress = "13 Aladashvili street";


        textBoxPage.openPageWithClosingBottomAds()
                .setValueInInput("Full Name", firstName + " " + lastName)
                .setValueInInput("Email", email)
                .setValueInTextarea("Current Address", currentAddress)
                .setValueInTextarea("Permanent Address", permanentAddress)
                .clickBtn("Submit");
// проверка проводится на 1й странице, но делю на 2 блока для наглядности
        textBoxPage.checkResult("Name:", firstName + " " + lastName)
                .checkResult("Email:", email)
                .checkResult("Current Address :", currentAddress)
                .checkResult("Permananet Address :", permanentAddress);

    }
}