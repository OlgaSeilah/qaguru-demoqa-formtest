package com.demoqa.tests;


import com.demoqa.components.ResultModalWindow;
import com.demoqa.pages.StudentRegistrationFormPage;
import org.junit.jupiter.api.Test;

public class CorrectFillRegistrationFormTest extends BaseTest {

    private StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();
    private ResultModalWindow resultModalWindow = new ResultModalWindow();
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
        String picturePath = "img_for_test/pngImg.png";
        String pictureName = "pngImg.png";
        String address = "Some street, 13";
        String state = "NCR";
        String city = "Delhi";


        studentRegistrationFormPage.openPageWithClosingBottomAds()
                .setName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .clickGenderLabel(gender)
                .setUserPhoneNumber(phoneNumber)
                .openCalendar()
                .chooseBirthDate(birthMonth, birthYear, birthDay)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(picturePath)
                .setCurrentAddress(address)
                .openDropdown("Select State")
                .chooseOptionInStateDropdown()
                .openDropdown("Select City")
                .chooseOptionInCityDropdown()
                .clickSubmitBtn();

        resultModalWindow.checkModalWindowIsVisible()
                .checkRowHasResult("Student Name", firstName + " " + lastName)
                .checkRowHasResult("Student Email", email)
                .checkRowHasResult("Gender", gender)
                .checkRowHasResult("Mobile", phoneNumber)
                .checkRowHasResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .checkRowHasResult("Subjects", subject)
                .checkRowHasResult("Hobbies", hobby)
                .checkRowHasResult("Picture", pictureName)
                .checkRowHasResult("Address", address)
                .checkRowHasResult("State and City", state + " " + city);
    }
}