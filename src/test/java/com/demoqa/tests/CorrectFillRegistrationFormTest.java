package com.demoqa.tests;


import com.demoqa.components.ResultModalWindow;
import com.demoqa.pages.StudentRegistrationFormPage;
import com.demoqa.test_data.enums.City;
import com.demoqa.test_data.enums.States;
import org.junit.jupiter.api.Test;

import static com.demoqa.test_data.TestData.*;

public class CorrectFillRegistrationFormTest extends BaseTest {

    private StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();
    private ResultModalWindow resultModalWindow = new ResultModalWindow();
    @Test
    public void successfulFillForm() {

        String firstName = getFirstName();
        String lastName = getLastName();
        String email = getEmail();
        String gender = getGender();
        String phoneNumber = getPhoneNumber(10);
        String birthMonth = getRandomMonth();
        String birthYear = getRandomYear();
        String birthDay = getRandomDay();
        String subject = getRandomSubject();
        String hobby = getRandomHobby();
        String picturePathPng = getPicturePathPng();
        String pictureNamePng = getPictureName();
        String address = getAddress();
        States state = getRandomState();
        City city = getCityForState(state);

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
                .uploadPicture(picturePathPng)
                .setCurrentAddress(address)
                .openDropdown("Select State")
                .chooseOptionInStateCityDropdown(state.getValue())
                .openDropdown("Select City")
                .chooseOptionInStateCityDropdown(city.getValue())
                .clickSubmitBtn();

        resultModalWindow.checkModalWindowIsVisible()
                .checkRowHasResult("Student Name", firstName + " " + lastName)
                .checkRowHasResult("Student Email", email)
                .checkRowHasResult("Gender", gender)
                .checkRowHasResult("Mobile", phoneNumber)
                .checkRowHasResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .checkRowHasResult("Subjects", subject)
                .checkRowHasResult("Hobbies", hobby)
                .checkRowHasResult("Picture", pictureNamePng)
                .checkRowHasResult("Address", address)
                .checkRowHasResult("State and City", state.getValue() + " " + city.getValue());
    }
}