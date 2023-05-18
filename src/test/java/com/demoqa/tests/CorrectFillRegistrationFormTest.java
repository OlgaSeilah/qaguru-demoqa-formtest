package com.demoqa.tests;


import com.demoqa.components.ResultModalWindow;
import com.demoqa.pages.StudentRegistrationFormPage;
import com.demoqa.test_data.enums.City;
import com.demoqa.test_data.enums.States;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.demoqa.allure.TagConstants.REGISTRATION;
import static com.demoqa.allure.TagConstants.REGRESS;
import static com.demoqa.test_data.TestData.*;

@Tags({@Tag(REGRESS), @Tag(REGISTRATION)})
public class CorrectFillRegistrationFormTest extends BaseTest {

    private StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();
    private ResultModalWindow resultModalWindow = new ResultModalWindow();
    
    @DisplayName("Заполнение формы регистрации корректными данными")
    @Test
    public void successfulFillForm() {
        
        String firstName = getFirstName(),
                lastName = getLastName(), 
                email = getEmail(), 
                gender = getGender(),
                phoneNumber = getPhoneNumber(10),
                birthMonth = getRandomMonth(),
                birthYear = getRandomYear(),
                birthDay = getRandomDay(),
                subject = getRandomSubject(),
                hobby = getRandomHobby(),
                picturePathPng = getPicturePathPng(),
                pictureNamePng = getPictureName(),
                address = getAddress();
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