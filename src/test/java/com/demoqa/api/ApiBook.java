package com.demoqa.api;

import com.demoqa.models.AddBookBodyModel;
import com.demoqa.models.IsbnModel;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.demoqa.spec.StoreSpec.*;
import static io.restassured.RestAssured.given;

public class ApiBook {

    @Step("Add a book")
    public static void bookAdd(String bookId, String userId, String token) {

        IsbnModel isbnModel = new IsbnModel();
        isbnModel.setIsbn(bookId);
        List<IsbnModel> isbn = new ArrayList<>();
        isbn.add(isbnModel);

        AddBookBodyModel bookAddingInfo = new AddBookBodyModel();
        bookAddingInfo.setCollectionOfIsbns(isbn);
        bookAddingInfo.setUserId(userId);

        given(bookAddSpec)
                .header("Authorization", "Bearer " + token)
                .body(bookAddingInfo)
                .when()
                .post()
                .then()
                .spec(bookAddResponseSpec);
    }

    @Step("Delete all books from a user's profile")
    public static void bookDeletion(String userId, String token) {

        given(bookDeleteRequestSpec)
                .header("Authorization", "Bearer " + token)
                .param("UserId", userId)
                .when()
                .delete()
                .then()
                .spec(bookDeleteResponseSpec);
    }
}
