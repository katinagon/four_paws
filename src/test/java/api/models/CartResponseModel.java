package api.models;

import lombok.Data;

import java.util.List;

@Data
public class CartResponseModel {
    private List<CartItem> items;
    private CartTotal total;
}
