package api.models;

import lombok.Data;

@Data
public class TokenModel {
    private String accessToken, refreshToken, tokenType, expiresIn, sessionState, scope, refreshExpiresIn;
}
