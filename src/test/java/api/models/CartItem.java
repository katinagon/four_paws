package api.models;

import lombok.Data;

@Data
public class CartItem {
    private String offerId, quantity;
    private String cartItemId, activeForCheckout, cutPriceGroupId;

    public CartItem(String offerId, String quantity) {
        this.offerId = offerId;
        this.quantity = quantity;
    }
}
