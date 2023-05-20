package com.demoqa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.components.CalendarComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private final SelenideElement formHeaderText = $(".practice-form-wrapper h5"),
            firstNameInput = $("input#firstName"),
            lastNameInput = $("input#lastName"),
            userEmailInput = $("#userEmail-wrapper input"),
            genderRadioBtnLabel = $("#genterWrapper"),
            userPhoneNumber = $("input#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsContainerInput = $("#subjectsContainer input"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            optionInCityDropdown = $("#react-select-4-option-0"),
            submitBtn = $("#submit");

    private final ElementsCollection dropdowns = $$("#stateCity-wrapper .css-1wa3eu0-placeholder"),
    statesCitiesOptions = $$(".css-11unzgr div");

    @Step("Open \"/automation-practice-form\" with closing adds")
    public StudentRegistrationFormPage openPageWithClosingBottomAds() {
        open("/automation-practice-form");

        formHeaderText.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    @Step("Set name \"{name}\"")
    public StudentRegistrationFormPage setName(String name) {
        firstNameInput.setValue(name);

        return this;
    }

    @Step("Set last \"{lastName}\"")
    public StudentRegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    @Step("Set email \"{email}\"")
    public StudentRegistrationFormPage setEmail(String email) {
        userEmailInput.setValue(email);

        return this;
    }

    @Step("Choose gender {gender}")
    public StudentRegistrationFormPage clickGenderLabel(String gender) {
        genderRadioBtnLabel.$(byText(gender)).click();

        return this;
    }

    @Step("Set phone number \"{phoneNumber}\"")
    public StudentRegistrationFormPage setUserPhoneNumber(String phoneNumber) {
        userPhoneNumber.setValue(phoneNumber);

        return this;
    }

    @Step("Click on date of birth input")
    public StudentRegistrationFormPage openCalendar() {
        dateOfBirthInput.click();

        return this;
    }

    @Step("Select birth date")
    public StudentRegistrationFormPage chooseBirthDate(String birthMonth, String birthYear, String birthDay) {
        calendarComponent.selectMonth(birthMonth)
                .selectYear(birthYear)
                .selectDay(birthDay);

        return this;
    }

    @Step("Set subject {subject}")
    public StudentRegistrationFormPage setSubject(String subject) {
        subjectsContainerInput.setValue(subject).pressEnter();

        return this;
    }

    @Step("Set hobby {hobby}")
    public StudentRegistrationFormPage setHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();

        return this;
    }

    @Step("Upload picture from classpath \"{picturePath}\"")
    public StudentRegistrationFormPage uploadPicture(String picturePath) {
        uploadPictureInput.uploadFromClasspath(picturePath);

        return this;
    }

    @Step("Set current address \"{address}\"")
    public StudentRegistrationFormPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);

        return this;
    }

    @Step("Click on dropdown \"{dropdownLabel}\"")
    public StudentRegistrationFormPage openDropdown(String dropdownLabel) {
        dropdowns.findBy(text(dropdownLabel))
                .scrollIntoView(false)
                .click();

        return this;
    }

    @Step("Find value  \"{value}\"")
    public StudentRegistrationFormPage chooseOptionInStateCityDropdown(String value) {
        statesCitiesOptions.findBy(text(value)).scrollIntoView(false).click();

        return this;
    }

    @Step("Click submit button")
    public StudentRegistrationFormPage clickSubmitBtn() {
        submitBtn.click();

        return this;
    }
}
