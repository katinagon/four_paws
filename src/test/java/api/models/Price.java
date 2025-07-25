package api.models;

import lombok.Data;

@Data
public class Price {
    private String priceValue, oldPriceValue, discountPercentValue, currency;
}
