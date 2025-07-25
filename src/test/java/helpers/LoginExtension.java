package helpers;

import api.models.AuthResponseModel;
import api.requests.AuthApiRequests;
import static helpers.TestData.*;

public class LoginExtension {
    AuthResponseModel response = AuthApiRequests.authRequest();
    response.getTokenObj();
}
