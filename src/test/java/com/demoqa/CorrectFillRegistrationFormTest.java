package com.demoqa;


import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CorrectFillRegistrationFormTest extends BaseTest {

    @Test
    public void successfulFillForm() {
        String firstName = "Name";
        String lastName = "Secondname";
        String email = "qwerty@qqq.ru";
        String gender = "Other";
        String phoneNumber = "1234567890";
        String birthMonth = "March";
        String birthYear = "2000";
        String birthDay = "10";
        String subject = "Arts";
        String hobby = "Music";
        String picturePath = "imgForTest/pngImg.png";
        String pictureName = "pngImg.png";
        String address = "Some street, 13";
        String state = "NCR";
        String city = "Delhi";

        Selenide.open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("input#firstName").setValue(firstName);
        $("input#lastName").setValue(lastName);
        $("#userEmail-wrapper input").setValue(email);
        $("label[for='gender-radio-3']").shouldBe(enabled).click();
        $("input#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText(birthMonth)).click();
        $$(".react-datepicker__year-select option").get(100).click();
        $$(".react-datepicker .react-datepicker__week .react-datepicker__day").findBy(text("10")).click();
        $("#subjectsContainer input").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(picturePath);
        $("#currentAddress").setValue(address);
        $$(".css-1wa3eu0-placeholder").findBy(text("Select State")).click();
        $("#react-select-3-option-0").click();
        $$(".css-1wa3eu0-placeholder").findBy(text("Select City")).click();
        $("#react-select-4-option-0").click();

        $("#submit").click();

        $(".modal-dialog").shouldBe(visible);
        $(".table-responsive").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text(gender),
                text(phoneNumber),
                text(birthDay + " " + birthMonth + "," + birthYear),
                text(subject),
                text(hobby),
                text(pictureName),
                text(address),
                text(state + " " + city)
        );
    }
}