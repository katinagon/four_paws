package api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginEmailRequestModel {
    private LoginDataModel values;
    private String token;
}
