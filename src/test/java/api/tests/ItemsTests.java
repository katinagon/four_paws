package api.tests;

import api.BaseApiTest;
import api.models.CartItem;
import api.models.ItemsRequestModel;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static api.requests.ItemsRequests.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static helpers.TestData.*;

@Owner("goncharova-ek")
@Tag("items-api")
@DisplayName("Товары API")
public class ItemsTests extends BaseApiTest {

    @Feature("Товары")
    @Story("Добавление товара")
    @DisplayName("Успешное добавление товара")
    @Test
    public void successAddItemAPITest() {
        CartItem cartItem = new CartItem(offerId, quantity);
        ItemsRequestModel itemsRequestModel = new ItemsRequestModel(List.of(cartItem));

        step("Добавление товара в корзину", () ->
                addItemRequest(itemsRequestModel));

        step("Проверка наличия товара в корзине", () ->
                checkFilledCartRequest());
    }

    @Feature("Товары")
    @Story("Удаление товара")
    @DisplayName("Успешное удаление товара")
    @Test
    public void successDeleteItemAPITest() {
        CartItem cartItem = new CartItem(offerId, quantity);
        ItemsRequestModel itemsRequestModel = new ItemsRequestModel(List.of(cartItem));

        step("Добавление товара в корзину", () ->
                addItemRequest(itemsRequestModel));

        step("Удаление товара из корзины", () ->
                deleteItemRequest());

        step("Проверка отсутствия товара в корзине", () ->
                checkEmptyCartRequest());
    }
}
