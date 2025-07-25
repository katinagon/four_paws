package api.models;

import lombok.Data;

@Data
public class CurrentUserResponseModel {
    private String id, phone, email, name, lastName, gender, dateEmailConfirmation, birthDate, customerId, manzana,
            externalId, keycloakId, cardNumber, isElectronicCheckAccepted;
}
