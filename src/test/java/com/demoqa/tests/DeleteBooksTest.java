package com.demoqa.tests;

import com.demoqa.data.DataTest;
import com.demoqa.models.LoginResponseModel;
import com.demoqa.pages.ProfilePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.demoqa.api.ApiAuth.successfulAuthorisation;
import static com.demoqa.api.ApiBook.bookAdd;
import static com.demoqa.api.ApiBook.bookDeletion;

public class DeleteBooksTest extends BaseTest {
    ProfilePage profilePage = new ProfilePage();
    DataTest dataTest = new DataTest();

    @DisplayName("Delete book from user profile")
    @Test
    void bookDeleteTest() {
        LoginResponseModel loginResponse = successfulAuthorisation(dataTest.login, dataTest.password);
        bookDeletion(loginResponse.getUserId(), loginResponse.getToken());
        bookAdd(dataTest.bookId, loginResponse.getUserId(), loginResponse.getToken());
        bookDeletion(loginResponse.getUserId(), loginResponse.getToken());

        open(baseUrl + "/images/Toolsqa.jpg");
        getWebDriver().manage().addCookie(new Cookie("userID", loginResponse.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("expires", loginResponse.getExpires()));
        getWebDriver().manage().addCookie(new Cookie("token", loginResponse.getToken()));

        open(baseUrl + "/profile");
        profilePage.emptyTableCheck();
    }
}
