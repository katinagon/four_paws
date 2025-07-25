package helpers;

import api.models.AuthResponseModel;
import api.models.CurrentUserResponseModel;
import api.models.CustomerCartIdResponseModel;
import api.requests.HelpersRequests;

import static helpers.TestData.*;

public class LoginExtension {

    public void getToken() {
        AuthResponseModel response = HelpersRequests.getTokenRequest();
        token = response.getToken().getAccessToken();
    }

    public void getCustomerId() {
        CurrentUserResponseModel response = HelpersRequests.getCustomerIdRequest();
        customerId = response.getCustomerId();
    }

    public void getCustomerCartId() {
        CustomerCartIdResponseModel response = HelpersRequests.getCustomerCartIdRequest();
        customerCartId = response.getCustomerCartId();
    }
}
