package com.demoqa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private final SelenideElement formHeaderText = $(".main-header"),
    button = $("button.btn");
    private final ElementsCollection formInputTextareaLabels = $$("#userForm label"),
    resultRows = $$("#output p");


    @Step("Open page \"/text-box\"")
    public TextBoxPage openPageWithClosingBottomAds() {
        open("/text-box");

        formHeaderText.shouldHave(text("Text Box"));

        return this;
    }

    @Step("Set value \"{text}\" in input \"{inputName}\"")
    public TextBoxPage setValueInInput(String inputName, String text) {
        formInputTextareaLabels.findBy(text(inputName)).parent().parent().$("input").setValue(text);

        return this;
    }

    @Step("Set value \"{text}\" in area \"{inputName}\"")
    public TextBoxPage setValueInTextarea(String inputName, String text) {
        formInputTextareaLabels.findBy(text(inputName)).parent().parent().$("textarea").setValue(text);

        return this;
    }

    @Step("Check that value in row \"{rowName}\" is \"{value}\"")
    public TextBoxPage checkResult(String rowName, String value) {
        resultRows.findBy(text(rowName)).shouldHave(text(value));

        return this;
    }

    @Step("Click button \"{btnName}\"")
    public TextBoxPage clickBtn(String btnName) {
        button.shouldHave(text(btnName)).click();

        return this;
    }



}
