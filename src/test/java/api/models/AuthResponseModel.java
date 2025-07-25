package api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class AuthResponseModel {
    private List<TokenModel> tokenObj;
}
