package com.demoqa.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
    private final SelenideElement monthSelect = $(".react-datepicker__month-select");
    private final ElementsCollection yearSelectOption = $$(".react-datepicker__year-select option"),
            daySelectOption = $$(".react-datepicker .react-datepicker__week .react-datepicker__day");

    @Step("Select month {birthMonth}")
    public CalendarComponent selectMonth(String birthMonth) {
        monthSelect.$(byText(birthMonth)).click();

        return this;
    }

    @Step("Select year {birthYear}")
    public CalendarComponent selectYear(String birthYear) {
        yearSelectOption.findBy(text(birthYear)).click();

        return this;
    }


    @Step("Select day {birthDay}")
    public CalendarComponent selectDay(String birthDay) {
        daySelectOption.findBy(text(birthDay)).shouldBe(visible, Duration.ofSeconds(6)).click();

        return this;
    }
}
